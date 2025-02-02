package jp.co.monocrea.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jp.co.monocrea.entity.User;
import jp.co.monocrea.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserResource {
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        List<User> users = userRepository.listAll();
        if (users == null) {
            return new ArrayList<>();
        }
        return users;
    }

    @POST
    public User createUser(User user) {
        userRepository.persist(user);
        return user;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, User updatedUser) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new WebApplicationException("User not found", 404);
        }
        user.name = updatedUser.name;
        userRepository.persist(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        userRepository.deleteById(id);
        return Response.noContent().build();
    }
}

