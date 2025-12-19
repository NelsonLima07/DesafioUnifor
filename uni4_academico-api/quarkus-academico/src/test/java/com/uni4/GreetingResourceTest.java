package com.uni4;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.CoreMatchers.not;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    @Test
    void testLoginUsuariosEndpoint() {

        String login = "{" 
                + "\"username\": \"coordenador\","
                + "\"password\": \"1234\""
                + "}";        
        given().contentType(ContentType.JSON).body(login)
        .when().post("/auth/login") 
        .then()
            .statusCode(200)
            .body("access_token", notNullValue())
            .body("access_token", not(emptyString()));
    }

}