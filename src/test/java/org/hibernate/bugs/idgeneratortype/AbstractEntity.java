package org.hibernate.bugs.idgeneratortype;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import javax.annotation.Nullable;

@MappedSuperclass
public class AbstractEntity {

    private Long id;

    @Id
    @CustomSequence
    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

}
