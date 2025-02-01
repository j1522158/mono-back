package jp.co.monocrea.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jp.co.monocrea.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
