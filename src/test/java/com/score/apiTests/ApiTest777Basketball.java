package com.score.apiTests;

import com.score.applicationmetods.ApplicationMethod;
import com.score.applicationmetods.TestDataProviders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ApiTest777Basketball {

    ApplicationMethod app = new ApplicationMethod();
    Logger logger = LoggerFactory.getLogger(ApiTest777Basketball.class);

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Test Start "  + m.getName() + "with parameters " + Arrays.asList(p));

    }

    String domen;
    @Parameters({"domen" })
    @BeforeMethod(alwaysRun = true)
    public String getDomen(String domenFromParametrs){
        domen = domenFromParametrs;
        return domen;
    }



    @Test(dataProvider = "basketballApiLinks", dataProviderClass = TestDataProviders.class)
    //check tests with links from data providers

    public void checkApiServices(String api){
        String url = domen + api;
        logger.info(url);
        Assert.assertEquals(app.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get matches by date
     */
    public void basketballMatchesByDate(){
        String url = domen + "/api/v1/basketball/matches-by-date?date="+ app.getDate();
        logger.info(ApplicationMethod.getDate() +" " + ApplicationMethod.requestConnection(url));
        logger.info(url);
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");

    }
    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());

    }
}
