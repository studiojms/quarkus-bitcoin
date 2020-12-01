package com.studiojms.resource;

import com.studiojms.model.Order;
import com.studiojms.repository.OrderRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/order")
public class OrderResource {
    @Inject
    OrderRepository orderRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() {
        return orderRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Order order) {
        order.setDate(LocalDate.now());
        order.setStatus("SENT");
        orderRepository.persist(order);
    }
}
