package org.hibernate.bugs.genericgenerator;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.annotation.Nullable;

@Table(name = "`ky_Post`")
@Entity
public class Post extends AbstractEntity {

    private String title;
    private String body;

    @Basic(optional = false)
    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Basic(optional = false)
    @Nullable
    public String getBody() {
        return body;
    }

    public void setBody(@Nullable String body) {
        this.body = body;
    }

}
