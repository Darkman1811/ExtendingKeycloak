package com.gwidgets.spi;

import com.gwidgets.entities.SubscribtionJpaEntity;
import org.apache.james.mime4j.dom.datetime.DateTime;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.jpa.entities.UserEntity;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreetingEventListnerProvider implements EventListenerProvider {
    private static Logger logger = Logger.getLogger("com.gwidgets.spi.GreetingEventListnerProvider");
    private final GreetingProvider greetingProvider;

    private final EntityManager entityManager;
    public GreetingEventListnerProvider(GreetingProvider greetingProvider, EntityManager entityManager) {
        this.greetingProvider = greetingProvider;
        this.entityManager = entityManager;
    }

    @Override
    public void onEvent(Event event) {
        if(event.getType()== EventType.LOGIN){
            System.out.println("================= EVENT DETECTED =================");
            greetingProvider.sayHi();
            SubscribtionJpaEntity entity = new SubscribtionJpaEntity();
            entity.setId(UUID.randomUUID());
            UserEntity userEntity = new UserEntity();
            userEntity.setId(event.getUserId());
            entity.setUser(userEntity);
            entity.setCreated(LocalDateTime.now());
            entity.setModified(LocalDateTime.now());
            entityManager.persist(entity);
            entityManager.flush();
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
