package com.studiojms.resource;

import com.studiojms.model.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return User.listAll();
    }

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(User user) {
        User.add(user);
        return Response.created(null).build();
    }
}
