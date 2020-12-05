package com.studiojms.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
public class UserTest {

    @Test
    public void testIfFindByIdOptionalReturnsCorrectUser() {
        PanacheMock.mock(User.class);

        User user = new User();
        final Optional<PanacheEntityBase> userOptional = Optional.of(user);

        Mockito.when(User.findByIdOptional(99)).thenReturn(userOptional);

        Assertions.assertSame(user, User.findByIdOptional(99).get());
    }
}
