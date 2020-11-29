package com.studiojms.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BitcoinResourceTest {

    @Test
    public void testRequestStatusCodeIs200() {
        RestAssured
                .given().get("bitcoin")
                .then().statusCode(200);
    }
}
