package org.hibernate.bugs;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.bugs.idgeneratortype.AbstractEntity;
import org.hibernate.bugs.idgeneratortype.Post;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Test;

/**
 * Test case for overriding {@link org.hibernate.annotations.IdGeneratorType}
 */
public class OverrideIdGeneratorTypeTestCase extends BaseCoreFunctionalTestCase {

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class[]{
                AbstractEntity.class,
                Post.class
        };
    }

    @Override
    protected String[] getOrmXmlFiles() {
        // Hard-wired override for testing purposes
        return new String[] {
                "identifier-strategy.xml"
        };
    }

    @Test
    public void testSaveEntity() {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();

        Post post = new Post();
        post.setTitle("Post title");
        post.setBody("Post body");
        session.save(post);

        transaction.commit();
        session.close();
    }

}
