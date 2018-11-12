package com.score.apiTests;

import com.score.applicationmetods.ApplicationMethod;
import com.score.applicationmetods.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FootballMatchesTest777 {

    String query = "https://777score.com";


    @Test(dataProvider = "matchesLink", dataProviderClass = TestDataProviders.class)
    //check tests with links from data providers

    public void checkMatches(String api){
        String url = api;
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        //ApplicationMethod.log.info(ApplicationMethod.requestConnection(url));

    }
}
