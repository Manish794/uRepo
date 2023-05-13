package com.manish.spring.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator {
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
