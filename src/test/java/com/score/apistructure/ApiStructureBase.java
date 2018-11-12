package com.score.apistructure;

import com.score.applicationmetods.ApplicationMethod;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiStructureBase {
    ApplicationMethod app = new ApplicationMethod();

    String BASE_URI = app.getQuery();
    String BASE_PATH_FOOTBALL = "/api/v1/football";
    String BASE_PATH_HOCKEY = "/api/v1/ice_hockey";
    String BASE_PATH_BASKETBALL = "/api/v1/basketball";
    String BASE_PATH_TENNIS = "/api/v1/tennis";

    public void getSetup(String base_path){
     RestAssured.baseURI = BASE_URI;
     RestAssured.basePath = base_path;
    }


    public void checkScheme(String service_rout, String scheme_path){
        Response response =
       given()
       .when()
               .get(service_rout)
               .then()
               .extract().response();


        String responseString = response.asString();
        assertThat(responseString, matchesJsonSchemaInClasspath(scheme_path));


    }

    @BeforeTest
    public void setup(){
        getSetup(BASE_PATH_FOOTBALL);
    }

    @Test
    public void checkTestScheme(){
        checkScheme("/cups/1732/season/3693/tree","schema/tournamentcuptree_schema.json");
    }





}
