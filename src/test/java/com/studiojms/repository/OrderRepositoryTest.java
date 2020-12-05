package com.studiojms.repository;

import com.studiojms.model.Order;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

@QuarkusTest
public class OrderRepositoryTest {

    @InjectMock
    OrderRepository orderRepository;

    @Test
    public void testIfListAllReturnsCorrectOrders() {
        Order first = new Order();
        Order second = new Order();

        final ArrayList<Order> orders = new ArrayList<>();
        orders.add(first);
        orders.add(second);

        Mockito.when(orderRepository.listAll()).thenReturn(orders);

        Assertions.assertSame(second, orderRepository.listAll().get(1));
    }
}
