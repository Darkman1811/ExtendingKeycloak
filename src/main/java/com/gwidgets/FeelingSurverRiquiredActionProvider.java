package com.gwidgets;

import org.keycloak.authentication.InitiatedActionSupport;
import org.keycloak.authentication.RequiredActionContext;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.events.EventType;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.jpa.entities.UserAttributeEntity;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.sessions.AuthenticationSessionModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.UUID;

public class FeelingSurverRiquiredActionProvider implements RequiredActionProvider {




    @Override
    public void evaluateTriggers(RequiredActionContext requiredActionContext) {
        var now = LocalDate.now();
        if (now.getDayOfWeek() == DayOfWeek.MONDAY && !now.toString().equals(requiredActionContext.getUser().getFirstAttribute("last_triggered_date"))) {
            requiredActionContext.getUser().addRequiredAction("feeling-survey");
            // I had to add this, otherwise the action will be triggered indefinitely on Mondays
            // and the user will not be able to use the app, we need a condition to escape after the first add
            addAttribute(requiredActionContext, "last_triggered_date", LocalDate.now().toString());
        }

    }

    @Override
    public void requiredActionChallenge(RequiredActionContext requiredActionContext) {
        requiredActionContext.challenge(requiredActionContext.form().createForm("feeling-survey.ftl"));
    }

    @Override
    public void processAction(RequiredActionContext context) {
        var skip = context.getHttpRequest().getFormParameters().getFirst("skip");
        if (skip != null) {
            context.success();
            return;
        }
        var feeling = context.getHttpRequest().getFormParameters().getFirst("feeling");
        addAttribute(context, "feeling", feeling);
        context.success();
    }



    private void addAttribute(RequiredActionContext context, String attributeName, String attributeValue) {
        var entityManager = context.getSession().getProvider(JpaConnectionProvider.class).getEntityManager();
        var lastSurveyDate = new UserAttributeEntity();
       // EventType.PUSHED_AUTHORIZATION_REQUEST
       // EventType.AUTHREQID_TO_TOKEN
        lastSurveyDate.setName(attributeName);
        lastSurveyDate.setValue(attributeValue);
        var userEntity = new UserEntity();
        userEntity.setId(context.getUser().getId());
        lastSurveyDate.setUser(userEntity);
        lastSurveyDate.setId(UUID.randomUUID().toString());
        entityManager.persist(lastSurveyDate);
    }



    @Override
    public void close() {

    }
}
