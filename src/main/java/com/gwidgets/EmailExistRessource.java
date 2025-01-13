package com.gwidgets;


import org.keycloak.models.KeycloakSession;
import org.keycloak.services.managers.AppAuthManager;
import org.keycloak.services.managers.AuthenticationManager;

import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.QueryParam;


public class EmailExistRessource {

    private final KeycloakSession session;

    public EmailExistRessource(KeycloakSession session) {
        this.session = session;
    }

    @GET
    public ResultDao emailExist(@QueryParam("email") String email) {

        AuthenticationManager.AuthResult authResult = new AppAuthManager.BearerTokenAuthenticator(session)
                .setRealm(session.getContext().getRealm())
                .setConnection(session.getContext().getConnection())
                .setHeaders(session.getContext().getRequestHeaders())
                .authenticate();

        if (authResult == null) {
           // logger.debug("Token not valid");
            throw new NotAuthorizedException("Authorization denied this endpoint needs auhtentication");
        }


       boolean rs= session.users().getUserByEmail(session.getContext().getRealm(),email)!=null;
        return new ResultDao(rs);
    }
}
