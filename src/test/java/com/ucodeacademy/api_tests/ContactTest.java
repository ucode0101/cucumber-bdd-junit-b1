package com.ucodeacademy.api_tests;

import com.ucodeacademy.utility.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ContactTest {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = ConfigReader.getProperty("contact.url");
    }
    // login to generate token
    // Delete all Contacts
    File credential = new File("src/test/resources/json_files/credentials.json");

    @Test
    public void deleteAllContacts(){

        // first login to generate token
        Response response = given().contentType(ContentType.JSON)
                .body(credential)
                .when()
                .post("/users/login");
        String token = response.jsonPath().getString("token");

        // second get all contacts
        response = given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .when()
                .get("/contacts");

        // Store all contact ids in a list
        List<String> ids = response.jsonPath().getList("_id");

        // loop and get each contact id
        // and delete each contact by id
        for (String eachID : ids){
            response = given().auth().oauth2(token)
                    .contentType(ContentType.JSON)
                    .when()
                    .delete("/contacts/"+eachID);
            response.prettyPrint();
        }

    }
}
