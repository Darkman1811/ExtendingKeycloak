package com.gwidgets.authz;

import org.keycloak.Config;
import org.keycloak.authorization.AuthorizationProvider;
import org.keycloak.authorization.model.Policy;
import org.keycloak.authorization.model.ResourceServer;
import org.keycloak.authorization.policy.provider.PolicyProvider;
import org.keycloak.authorization.policy.provider.PolicyProviderAdminService;
import org.keycloak.authorization.policy.provider.PolicyProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.representations.idm.authorization.AbstractPolicyRepresentation;
import org.keycloak.representations.idm.authorization.PolicyRepresentation;

import java.util.List;

public class CustomPolicyProviderFactory implements PolicyProviderFactory<AbstractPolicyRepresentation> {
    @Override
    public String getName() {
        return "custom-policy-provider-2";
    }

    @Override
    public String getGroup() {
        return "CUSTOM-GROUP";
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public PolicyProvider create(AuthorizationProvider authorizationProvider) {
        return new CustomPolicyProvider();
    }

    @Override
    public AbstractPolicyRepresentation toRepresentation(Policy policy, AuthorizationProvider authorizationProvider) {
        return null;
    }

    @Override
    public Class<AbstractPolicyRepresentation> getRepresentationType() {
         return AbstractPolicyRepresentation.class;
    }

    @Override
    public void onCreate(Policy policy, AbstractPolicyRepresentation representation, AuthorizationProvider authorization) {

    }

    @Override
    public void onUpdate(Policy policy, AbstractPolicyRepresentation representation, AuthorizationProvider authorization) {

    }

    @Override
    public void onRemove(Policy policy, AuthorizationProvider authorization) {

    }

    @Override
    public void onImport(Policy policy, PolicyRepresentation representation, AuthorizationProvider authorization) {

    }

    @Override
    public void onExport(Policy policy, PolicyRepresentation representation, AuthorizationProvider authorizationProvider) {

    }

    @Override
    public PolicyProviderAdminService getAdminResource(ResourceServer resourceServer, AuthorizationProvider authorization) {
        return PolicyProviderFactory.super.getAdminResource(resourceServer, authorization);
    }

    @Override
    public PolicyProvider create(KeycloakSession keycloakSession) {
        return new CustomPolicyProvider();
    }

    @Override
    public void init(Config.Scope scope) {
        System.out.println("CustomPolicyProviderFactory.init");
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "custom-policy-provider-2";
    }

    @Override
    public int order() {
        return 100;
    }

    @Override
    public List<ProviderConfigProperty> getConfigMetadata() {
        return PolicyProviderFactory.super.getConfigMetadata();
    }

    // Implement other default methods if necessary
}
