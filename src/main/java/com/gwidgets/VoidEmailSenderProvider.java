package com.gwidgets;

import org.keycloak.email.EmailException;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.models.UserModel;

import java.util.Map;

public class VoidEmailSenderProvider implements EmailSenderProvider {
    @Override
    public void send(Map<String, String> config, UserModel user, String subject, String textBody, String htmlBody) throws EmailException {
        System.out.println("Sending email to "+user.getEmail()+" with subject "+subject);
    }

    @Override
    public void send(Map<String, String> map, String s, String s1, String s2, String s3) throws EmailException {
        System.out.println("Sending email to "+s+" with subject "+s1+" and body "+s2);
    }

    @Override
    public void close() {

    }
}
