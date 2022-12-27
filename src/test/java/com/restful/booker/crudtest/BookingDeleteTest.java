package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class BookingDeleteTest extends TestBase {
    @Test
    public void deleteBookingById() {

        Response response = given()
                .header("Authorization", "Bearer 4f228aeb52d5def")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=4f228aeb52d5def")
                .pathParam("id", 2115)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}
