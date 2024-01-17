package com.ucodeacademy.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiStepDefinitions {

    Response response;
    Map<String, Object> body = new HashMap<>();



    @When("User provides name as {string} and price {double} in body sends post request to {string}")
    public void user_provides_name_as_and_price_in_body_sends_post_request_to(String name, Double price, String endpoint) {

        body.put("name",name);
        body.put("price",price);

        System.out.println(body);

            response = given().contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(endpoint);

            response.prettyPrint();
    }
    @Then("Product should be created")
    public void product_should_be_created() {
        String s = response.jsonPath().getString("name");
        Assert.assertEquals(body.get("name"),s);
    }
    @Then("Status code should {int}")
    public void status_code_should(Integer int1) {
     response.then().assertThat().statusCode(201);
    }
    @Then("Response body should contain newly added product")
    public void response_body_should_contain_newly_added_product() {
     double price = response.jsonPath().getDouble("price");
     Assert.assertEquals(body.get("price"),price);
    }


}
