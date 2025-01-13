package com.gwidgets.spi;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GreetingEventListnerProvider implements EventListenerProvider {
    private static Logger logger = Logger.getLogger("com.gwidgets.spi.GreetingEventListnerProvider");
    private final GreetingProvider greetingProvider;

    public GreetingEventListnerProvider(GreetingProvider greetingProvider) {
        this.greetingProvider = greetingProvider;
    }

    @Override
    public void onEvent(Event event) {
        if(event.getType()== EventType.LOGIN){
            System.out.println("Login event detected");
            greetingProvider.sayHi();
        }

        if(event.getType()== EventType.PUSHED_AUTHORIZATION_REQUEST){
            System.out.println("================= PUSHED_AUTHORIZATION_REQUEST event detected =================");
            greetingProvider.sayHi();
        }
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
    }

    @Override
    public void close() {

    }
}
