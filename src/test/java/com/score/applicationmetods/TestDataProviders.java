package com.score.applicationmetods;


import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataProviders {
    @DataProvider(name = "basketballApiLinks")
    public Iterator<Object[]> basketballApiLinks() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/api_links/basketballApiLinks.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider(name = "footballApiLinks")
    public Iterator<Object[]> footballApiLinks() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/api_links/footballApiLinks.txt")));
        String line = reader.readLine();
        while (line != null) {
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider(name = "hockeyApiLinks")
    public Iterator<Object[]> hockeyApiLinks() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/api_links/hockeyApiLinks.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider(name = "tennisApiLinks")
    public Iterator<Object[]> tennisApiLinks() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/api_links/tennisApiLinks.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider(name = "matchesLink" )
    public Iterator<Object[]> matchesLink() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/matchLinks.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @DataProvider(name = "liveConnection")
    public Iterator<Object[]> liveConnection() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/api_links/liveconnectionsport.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider(name = "pages777scoreLinks")
    public Iterator<Object[]> pages777scoreLinks() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/pages_link/pages777score.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider(name = "links8880")
    public Iterator<Object[]> links8880() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/api_links/links8880.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
