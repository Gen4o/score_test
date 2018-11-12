package com.score.apiTests;

import com.score.applicationmetods.ApplicationMethod;
import com.score.applicationmetods.TestDataProviders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ApiTest777Hockey {

    ApplicationMethod app = new ApplicationMethod();
    Logger logger = LoggerFactory.getLogger(ApiTest777Hockey.class);

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Test Start "  + m.getName() + "with parameters " + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());

    }

    String domen;
    @Parameters({"domen" })
    @BeforeMethod(alwaysRun = true)
    public String getDomen(String domenFromParametrs){
        domen = domenFromParametrs;
        return domen;
    }


    @Test(dataProvider = "hockeyApiLinks", dataProviderClass = TestDataProviders.class)
    //check tests with links from data providers

    public void checkApiServices(String api){
        String url = domen + api;
        Assert.assertEquals(app.requestConnection(url), "200_Ok");
        logger.info(url);
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get ice Hockey matches by date
    /api/v1/tennis/matches-by-date/
     */
    public void hockeyMatchesByDate(){
        String url = domen + "/api/v1/ice_hockey/matches-by-date?date=" + app.getDate();

        Assert.assertEquals(app.requestConnection(url), "200_Ok");
        logger.info(app.requestConnection(url));

    }
}
