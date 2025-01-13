package com.gwidgets.authz;

import org.keycloak.authorization.policy.evaluation.Evaluation;
import org.keycloak.authorization.policy.provider.PolicyProvider;

public class CustomPolicyProvider implements PolicyProvider {

    @Override
    public void evaluate(Evaluation evaluation) {

        // Implement the policy evaluation logic here
    }

    @Override
    public void close() {
        // Release resources if necessary
    }
}