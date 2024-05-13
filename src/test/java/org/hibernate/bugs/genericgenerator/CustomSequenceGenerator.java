package org.hibernate.bugs.genericgenerator;

import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;

/**
 * Defines the sequence name using a naming convention for table names
 */
public class CustomSequenceGenerator extends SequenceStyleGenerator {

    public static final String STRATEGY_NAME = "ky-seq";

    public static final String TABLE_PREFIX = "ky_";

    public static final String SEQUENCE_PREFIX = "kys";

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        Properties appliedParams = new Properties();
        appliedParams.putAll(params);
        String tableName = params.getProperty(SequenceStyleGenerator.TABLE);
        String sequenceName = tableName.replace(TABLE_PREFIX, SEQUENCE_PREFIX);
        appliedParams.put(SequenceStyleGenerator.SEQUENCE_PARAM, sequenceName);

        super.configure(type, appliedParams, serviceRegistry);
    }

}
