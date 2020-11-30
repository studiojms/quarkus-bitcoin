package com.studiojms.resource;

import com.studiojms.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @GET
    public Response list() {
        System.out.println("TEST");
        return Response.ok(User.listAll()).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(User user) {
        User.persist(user);
        return Response.created(null).build();
    }
}
