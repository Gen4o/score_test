package com.score.apiTests;

import com.score.applicationmetods.ApplicationMethod;
import com.score.applicationmetods.TestDataProviders;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class BetaPageTest {
    ApplicationMethod app = new ApplicationMethod();


    @Parameters({"domen"})
    @BeforeTest
    public void getSetup(String domen){
        RestAssured.baseURI = domen;
        System.out.println(baseURI);
    }


    @Test(dataProvider = "pages777scoreLinks", dataProviderClass = TestDataProviders.class)
    public void checkPageConnectionTest(String pageRout){
        app.pageResponseChecking(pageRout);
    }


}
