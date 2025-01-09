package com.gwidgets;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.policy.PasswordPolicyProvider;
import org.keycloak.policy.PasswordPolicyProviderFactory;
import org.keycloak.policy.PolicyError;

public class DollarPasswordPolicyProvider implements PasswordPolicyProvider   {

    @Override
    public PolicyError validate(RealmModel realmModel, UserModel userModel, String s) {
        return validate(null,s);
    }

    @Override
    public PolicyError validate(String s, String s1) {

        if(s1!=null) {
            return s1.startsWith("$") ? null : new PolicyError("Password must start with $");
        }else {
            System.out.println("Password is null");
            return null;
        }
    }

    @Override
    public Object parseConfig(String s) {
        return null;
    }

    @Override
    public void close() {

    }
}
