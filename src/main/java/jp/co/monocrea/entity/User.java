package jp.co.monocrea.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String name;
}
