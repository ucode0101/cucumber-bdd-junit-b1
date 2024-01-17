package com.ucodeacademy.api_tests;

import com.ucodeacademy.pojo.ProductRequestBody;
import com.ucodeacademy.pojo.ProductsResponseBody;
import com.ucodeacademy.utility.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProductEndToEndTesting {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = ConfigReader.getProperty("product.url");
    }

    // get post body from json file
    File requestBody = new File("src/test/resources/json_files/product.json");


    @Test
    public void addProduct(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/products");

        response.then().assertThat().statusCode(201);

        response.prettyPrint();
    }

    // add a new product with Map object

    @Test
    public void addProductMap(){
        // note: you will not do api testing this way
        String productName = ConfigReader.getProperty("name");
        String s = ConfigReader.getProperty("price");
        double price = Double.parseDouble(s);

        Map<String, Object> product = new HashMap<>();

        product.put("name", productName);
        product.put("price", price);

        Response response = given().contentType(ContentType.JSON)
                .body(product)
                .when()
                .post("/products");

        response.prettyPrint();

    }

    // add a product with POJO
    @Test
    public void addProductPojo(){
        ProductRequestBody pojoBody = new ProductRequestBody("Dragon Fruit",6.79);

        Response response = given().contentType(ContentType.JSON)
                .body(pojoBody)
                .when()
                .post("/products");
        response.then().assertThat().statusCode(201);

        // store response body in ProductResponseBody object (POJO)
        ProductsResponseBody responseBody = response.as(ProductsResponseBody.class);

        System.out.println(responseBody);


    }









}
