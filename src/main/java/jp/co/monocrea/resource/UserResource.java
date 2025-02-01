package jp.co.monocrea.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jp.co.monocrea.entity.User;
import jp.co.monocrea.repository.UserRepository;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    public List<User> getUsers() {
        return userRepository.listAll();
    }

    @POST
    public User createUser(User user) {
        userRepository.persist(user);
        return user;
    }

    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") Long id, User updatedUser) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new WebApplicationException("User not found", 404);
        }
        user.name = updatedUser.name;
        userRepository.persist(user);
        return user;
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id) {
        userRepository.deleteById(id);
    }
}

