package objektno2.fit.resource;

import jakarta.annotation.security.RolesAllowed;
import objektno2.fit.exeption.ResourceNotFound;
import objektno2.fit.model.User;
import objektno2.fit.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jose4j.jwk.Use;

import java.util.List;

@Path("/user")
public class UserResource {

    @Inject
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addUser")
    public Response addUser(User user) {
        try {
            userService.createUser(user);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllUsers")
    public Response getAllUsers() {
        List<User> users;
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(e.getMessage())
                    .build();
        }
        return Response.ok(users).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findByEmail")
    public Response findByEmail(@QueryParam("email") String email) {
        if (email == null || email.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Email nije proslijeđen")
                    .build();
        }
        try {
            User user = userService.findByEmail(email);
            return Response.ok(user).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/getTimezoneByIp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimezoneByIp(@QueryParam("userId") Long userId){
        try{
            User user = userService.assignTimeZoneByIp(userId);
            return Response.ok(user).build();
        }
        catch (ResourceNotFound e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }


}