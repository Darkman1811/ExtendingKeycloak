package com.gwidgets;

import org.keycloak.Config;
import org.keycloak.authentication.RequiredActionFactory;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class FeelingSurveyRequiredActionProviderFactory implements RequiredActionFactory {
    @Override
    public String getDisplayText() {
        return "How do you feel ?";
    }



    @Override
    public RequiredActionProvider create(KeycloakSession keycloakSession) {
        return new FeelingSurverRiquiredActionProvider();
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
        return "feeling-survey";
    }



}
