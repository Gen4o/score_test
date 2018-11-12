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

public class Pages777scoreTest {
//    @DataProvider
//    public Iterator<Object[]> pages777scoreLinks() throws IOException {
//        List<Object[]> list = new ArrayList<Object[]>();
//        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/pages777score.txt")));
//        String line = reader.readLine();
//        while (line != null){
//            list.add(new Object[]{line});
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }
    ApplicationMethod app = new ApplicationMethod();
    Logger logger = LoggerFactory.getLogger(Pages777scoreTest.class);

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Test Start "  + m.getName() +" " + app.getQuery() + " with parameters " + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());
    }

    // Пробросить домен в метод в котором будут данные от датапровайдера
    String domen;
    @Parameters({"domen" })
    @BeforeMethod
    public String getDomen(String domenFromParametrs){
        domen = domenFromParametrs;
        System.out.println(domen);
        return domen;
    }

    @Test(dataProvider = "pages777scoreLinks", dataProviderClass = TestDataProviders.class)
    //check tests with links from data providers

    public void check777scorePages(String uri){
        String url = domen + uri;
        logger.info(url);
        Assert.assertEquals(app.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }






}
