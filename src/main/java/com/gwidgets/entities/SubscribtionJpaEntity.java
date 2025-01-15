package com.gwidgets.entities;

import org.keycloak.models.jpa.entities.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscription")
public class SubscribtionJpaEntity  {

    public SubscribtionJpaEntity() {
    }

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.REFRESH, targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private UserEntity user;

    private LocalDateTime created;
    private LocalDateTime modified;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
