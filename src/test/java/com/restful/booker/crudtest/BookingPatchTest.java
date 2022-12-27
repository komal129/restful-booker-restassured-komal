package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class BookingPatchTest extends TestBase {
    @Test
    public void updateBooking() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2023-11-05");
        bookingdates.put("checkout", "2023-11-15");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Shane");
        bookingPojo.setLastname("Jhones");
        bookingPojo.setTotalprice(250);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("Brunch");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 4f228aeb52d5def")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}
