package com.test;

import com.test.domain.AuthorizationPosition;
import com.test.domain.ProductAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class TestService implements ApplicationListener {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextRefreshedEvent) {
            AuthorizationPosition authorizationPosition = new AuthorizationPosition();

            ProductAttributes productAttributes = new ProductAttributes();
            productAttributes.addAuthorizationPositionByProductAttributes(authorizationPosition);

            entityManager.persist(productAttributes);
        }
    }
}
