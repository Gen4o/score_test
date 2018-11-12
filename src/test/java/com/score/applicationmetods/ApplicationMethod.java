package com.score.applicationmetods;

import com.score.apiTests.ApiTest777Football;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApplicationMethod {
    private String LOGIN = "mobileuser";
    private static String PASSWORD = "12345";
    //public static Logger log = LoggerFactory.getLogger(ApiTest777.class.getName());

    //private String query = "https://beta.777score.com";
    private String query = "https://777score.com";
    //ring query = "https://beta.skorexpress.com";
    //String query = "http://qa.777score.com";
    //Prod
    String domen;
    String prodEn = "https://777score.com";
    String prodRu = "https://777score.ru";
    String prodTr = "https://scorexpress.com";
    String prodUa = "https://777score.ua";

    //Beta
    String betaEn = "https://777score.com";
    String betaRu = "https://777score.ru";
    String betaTr = "https://scorexpress.com";
    String betaUa = "https://777score.ua";

    //qa
    String qaEn = "qa777score.dev";




    Logger logger = LoggerFactory.getLogger(getClass());
    public ApplicationMethod(){
    }

    public  String getPASSWORD() {
        return PASSWORD;
    }



    public String getLOGIN() {
        return LOGIN;
    }


    public String getQuery(){
        return query;

    }

    public void pageResponseChecking(String pageRout){
        given().auth().basic(getLOGIN(), getPASSWORD())
                .when()
                .get(pageRout)
                .then().statusCode(200);
    }


    public String getDomen(String domen1){
        domen = domen1;
        System.out.println(domen);
        return domen;
    }




    /*
        get current date
         */
    public static String getDate(){
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(Calendar.getInstance().getTime());
        System.out.println(dateString);

        return dateString;
    }

    /*
        send query to host and get request with response code
         */
    public static String requestConnection(String url){

        HttpURLConnection connection = null;

        String result = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36");
            connection.setConnectTimeout(2000);

            //connection.setReadTimeout(1000);

            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                result = "200_Ok";


            } else {
                result = ("fail" + connection.getResponseCode() + ", " + connection.getResponseMessage());

            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }


        }

        return result;


    }
}
