package org.hibernate.bugs.idgeneratortype;

import org.hibernate.id.OptimizableGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import javax.annotation.Nonnull;
import java.lang.reflect.Member;
import java.util.Properties;

public class CustomSequenceGenerator extends SequenceStyleGenerator {

    public static final String TABLE_PREFIX = "ky_";

    public static final String SEQUENCE_PREFIX = "kys";

    private final CustomSequence config;

    public CustomSequenceGenerator(@Nonnull CustomSequence config, @Nonnull Member annotatedMember,
                                   @Nonnull CustomIdGeneratorCreationContext context) {
        this.config = config;
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        Properties appliedParams = new Properties();
        appliedParams.putAll(params);
        appliedParams.put(OptimizableGenerator.INITIAL_PARAM, config.startWith());
        appliedParams.put(OptimizableGenerator.INCREMENT_PARAM, config.incrementBy());
        String tableName = params.getProperty(SequenceStyleGenerator.TABLE);
        String sequenceName = tableName.replace(TABLE_PREFIX, SEQUENCE_PREFIX);
        appliedParams.put(SequenceStyleGenerator.SEQUENCE_PARAM, sequenceName);

        super.configure(type, appliedParams, serviceRegistry);
    }

}
