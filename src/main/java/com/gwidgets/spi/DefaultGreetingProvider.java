package com.gwidgets.spi;

import org.keycloak.models.KeycloakContext;

public class DefaultGreetingProvider implements GreetingProvider {


    KeycloakContext keycloakContext;

    public DefaultGreetingProvider(KeycloakContext keycloakContext) {
        this.keycloakContext = keycloakContext;
    }

    @Override
    public void sayHi() {
        if(keycloakContext.getAuthenticationSession()!=null) {
            System.out.println("Hello from DefaultGreetingProvider, authenticated user: " + keycloakContext.getAuthenticationSession().getAuthenticatedUser().getUsername());
        } else {
            System.out.println("Hello from DefaultGreetingProvider, no authenticated user");
        }
    }

    @Override
    public void close() {

    }
}
