package com.studiojms.resource;

import com.studiojms.model.Order;
import com.studiojms.repository.OrderRepository;
import com.studiojms.service.OrderService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@Path("/order")
public class OrderResource {
    @Inject
    OrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() {
        return orderService.listAll();
    }

    @POST
    @Transactional
    @RolesAllowed("USER")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(@Context SecurityContext securityContext, Order order) {
        orderService.insert(securityContext, order);
    }
}
