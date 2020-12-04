package com.studiojms.service;

import com.studiojms.model.Order;
import com.studiojms.model.User;
import com.studiojms.repository.OrderRepository;
import com.studiojms.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {
    @Inject
    OrderRepository orderRepository;

    @Inject
    UserRepository userRepository;

    public void insert(SecurityContext securityContext, Order order) {
        final Optional<User> userOptional = userRepository.findByIdOptional(order.getUserId());
        final User user = userOptional.orElseThrow();

        if (!user.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("Invalid logged user. The provided user is not the same as the authenticated user");
        }

        order.setDate(LocalDate.now());
        order.setStatus("SENT");

        orderRepository.persist(order);
    }

    public List<Order> listAll() {
        return orderRepository.listAll();
    }
}
