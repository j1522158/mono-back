package jp.co.monocrea.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jp.co.monocrea.entity.User;
import jp.co.monocrea.service.UserService;
import java.util.List;


@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, User updatedUser) {
        User updated = userService.updateUser(id, updatedUser);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}


