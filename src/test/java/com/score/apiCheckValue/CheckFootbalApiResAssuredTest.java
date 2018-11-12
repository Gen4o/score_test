package com.score.apiCheckValue;

import com.score.applicationmetods.ApplicationMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;


public class CheckFootbalApiResAssuredTest {


    ApplicationMethod app = new ApplicationMethod();


    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://live.777score.com";
      //RestAssured.baseURI = "https://sportstat24.com";
       // RestAssured.baseURI = "https://777score.com:8880";


    }


    public List<String> getMatchesNumId () {

        Response response;
        response = given()
        .when()
                .get("/soccer/matches/live")

        .then().statusCode(200).extract().response();

        String id  = response.path("id_string");
      String stringRespons = response.asString();
        JsonPath jsonPath = new JsonPath(stringRespons);
        List <String> matchesNumID = jsonPath.getList("matches.bm");
        return  matchesNumID;
    }


    @Test
    public void isLiveTrue () {
        Response response;
        response = given()
                .when()
                .get("/soccer/matches/live")
                .then().statusCode(200).log().body().extract().response();

        String id  = response.path("id_string");
        String stringRespons = response.asString();
        JsonPath jsonPath = new JsonPath(stringRespons);
        //jsonPath.setRoot("matches");

        String name = null;
        //String isLive = null;
        String isLiveTrue = jsonPath.param("name", true).getString("matches.findAll {matches -> matches.isLive == name }");
        String isLive = (jsonPath.param("name", true).getJsonObject("matches.findAll {matches -> matches.isLive == name}")).toString();
        System.out.println("Live" + isLiveTrue);
        JsonPath l = new JsonPath(isLive);
        System.out.println(jsonPath);
        System.out.println(isLive);
        List<String> matchesNumId = l.getList(".bm");
        System.out.println(matchesNumId);


    }


    @Test
    public void getStatusFromMatcehsLive(){
        List<String> matches = getMatchesNumId();

           for (String l : matches) {
               try { given().log().uri()
                       .get("/soccer/match/" + l)
                       .then().statusCode(200).log().status();
           }
               catch (AssertionError e){
                   System.out.println(e);
               }
       }
        System.out.println(matches);
    }


}
