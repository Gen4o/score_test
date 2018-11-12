package com.score.apiTests;

import com.score.applicationmetods.ApplicationMethod;
import com.score.applicationmetods.TestDataProviders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ApiTest777Tennis {

    String domen;

//    @DataProvider
//    public Iterator<Object[]> tennisApiLinks() throws IOException {
//        List<Object[]> list = new ArrayList<Object[]>();
//        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/api_links/tennisApiLinks.txt")));
//        String line = reader.readLine();
//        while (line != null){
//            list.add(new Object[]{line});
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }
    ApplicationMethod app = new ApplicationMethod();
    Logger logger = LoggerFactory.getLogger(ApiTest777Tennis.class);

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Test Start "  + m.getName() + "with parameters " + Arrays.asList(p));

    }
    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());

    }

    @Parameters({"domen" })
    @BeforeMethod(alwaysRun = true)
    public String getDomen(String domenFromParametrs){
        domen = domenFromParametrs;
        return domen;
    }

    @Test(dataProvider = "tennisApiLinks", dataProviderClass = TestDataProviders.class)
    //check tests with links from data providers

    public void checkApiServices(String api){
        String url = domen + api;
        logger.info(url);
        Assert.assertEquals(app.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get Tennis matches by date
    /api/v1/tennis/matches-by-date/
     */
    public void tennisMatchesByDate(){
        String url = app.getQuery() + "/api/v1/tennis/matches-by-date?date=" + app.getDate();

        Assert.assertEquals(app.requestConnection(url), "200_Ok");
        logger.info(app.requestConnection(url));

    }
}
