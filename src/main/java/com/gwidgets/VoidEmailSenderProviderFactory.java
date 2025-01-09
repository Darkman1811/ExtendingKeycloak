package com.gwidgets;

import org.keycloak.Config;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.email.EmailSenderProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class VoidEmailSenderProviderFactory implements EmailSenderProviderFactory {
    @Override
    public EmailSenderProvider create(KeycloakSession keycloakSession) {
        return new VoidEmailSenderProvider();
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

    @Override
    public int order() {
        return 1;
    }

    @Override
    public List<ProviderConfigProperty> getConfigMetadata() {
        return EmailSenderProviderFactory.super.getConfigMetadata();
    }
}
