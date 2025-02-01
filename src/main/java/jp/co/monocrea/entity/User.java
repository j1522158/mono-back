package jp.co.monocrea.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User extends PanacheEntity {
    @Column(nullable = false)
    public String name;
}
