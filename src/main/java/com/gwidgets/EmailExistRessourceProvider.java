package com.gwidgets;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class EmailExistRessourceProvider implements RealmResourceProvider {
    private final KeycloakSession session;

    public EmailExistRessourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return new EmailExistRessource(session);
    }

    @Override
    public void close() {

    }

}
