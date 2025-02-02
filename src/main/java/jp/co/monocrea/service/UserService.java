package jp.co.monocrea.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jp.co.monocrea.entity.User;
import jp.co.monocrea.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = userRepository.listAll();
        if (users == null || users.isEmpty()) {
            return new ArrayList<>();
        }
        return users;
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new WebApplicationException("User not found", 404);
        }
        user.name = updatedUser.name;
        userRepository.persist(user);
        return user;
    }

    @Transactional
    public void deleteUser(Long id) {
        boolean deleted = userRepository.deleteById(id);
        if (!deleted) {
            throw new WebApplicationException("User not found", 404);
        }
    }
}

