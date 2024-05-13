package org.hibernate.bugs.idgeneratortype;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType(CustomSequenceGenerator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface CustomSequence {

    int startWith() default 1;

    int incrementBy() default 50;

}
