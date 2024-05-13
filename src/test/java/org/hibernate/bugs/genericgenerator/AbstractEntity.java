package org.hibernate.bugs.genericgenerator;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.annotation.Nullable;

@MappedSuperclass
public class AbstractEntity {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomSequenceGenerator.STRATEGY_NAME)
    @GenericGenerator(name = CustomSequenceGenerator.STRATEGY_NAME, type = CustomSequenceGenerator.class, parameters = {
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1")
    })
    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

}
