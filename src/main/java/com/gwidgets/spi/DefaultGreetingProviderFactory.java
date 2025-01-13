package com.gwidgets.spi;

import com.gwidgets.spi.DefaultGreetingProvider;
import com.gwidgets.spi.GreetingProvider;
import com.gwidgets.spi.GreetingProviderFactory;
import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class DefaultGreetingProviderFactory implements GreetingProviderFactory {
    @Override
    public GreetingProvider create(KeycloakSession keycloakSession) {
        return new DefaultGreetingProvider(keycloakSession.getContext());
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
        return "default";
    }
}
