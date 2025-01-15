package com.gwidgets.entities;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

import java.util.Arrays;
import java.util.List;

public class SubscriptionJpaEntityProvider implements JpaEntityProvider {
    @Override
    public List<Class<?>> getEntities() {
        return Arrays.asList(SubscribtionJpaEntity.class);
    }

    @Override
    public String getChangelogLocation() {
        return "META-INF/changelog-subscription.xml";
    }

    @Override
    public String getFactoryId() {
        return "subscription-jpa-entity";
    }

    @Override
    public void close() {

    }
}
