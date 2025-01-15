package com.gwidgets.entities;

import org.keycloak.Config;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class SubscribtionJpaEntityProviderFactory implements JpaEntityProviderFactory {
    @Override
    public JpaEntityProvider create(KeycloakSession keycloakSession) {
        return new SubscriptionJpaEntityProvider();
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "jpa-subscription-entity";
    }
}
