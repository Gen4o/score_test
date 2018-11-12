package com.score.apiTests;

import com.score.applicationmetods.ApplicationMethod;
import com.score.applicationmetods.TestDataProviders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LiveConnectionTest {


    ApplicationMethod app = new ApplicationMethod();
    Logger logger = LoggerFactory.getLogger(LiveConnectionTest.class);

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Test Start "  + m.getName() + "with parameters " + Arrays.asList(p));

    }



    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());

    }
    @Test(groups = {"liveConnection"},dataProvider = "liveConnection", dataProviderClass = TestDataProviders.class)
    /*
    Check  information about tennis live
     */

    public void checkLiveConnection(String sport) {
        String url;
        if (app.getQuery().equals("https:777score.com")) {
            url = "https://sportstat24.com/" + sport + "/matches/live";
        } else {
            url = "https://live.777score.com/"+ sport +"/matches/live";
        }
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(url);
        logger.info(ApplicationMethod.requestConnection(url));

    }


    //Закрыли доступ на 8880, сделали ноду через localhost
//    String domen;
//    @Parameters({"domen" })
//    @BeforeTest( groups ={"links8880"})
//    public String getDomen(String domenFromParametrs){
//        domen = domenFromParametrs;
//        return domen;
//    }
//
//    @Test(groups = {"links8880"}, dataProvider = "links8880", dataProviderClass = TestDataProviders.class)
//    public void liveConnection8880(String local){
//        String url = domen + local;
//        logger.info(url);
//        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
//        logger.info(ApplicationMethod.requestConnection(url));
//    }

}
