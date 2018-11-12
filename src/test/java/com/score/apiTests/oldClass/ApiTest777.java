package com.score.apiTests.oldClass;

import com.score.applicationmetods.ApplicationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import java.lang.reflect.Method;


/**
 * Created by Gennadii on 12-Jul-17.
 */
public class ApiTest777 {
    Logger logger = LoggerFactory.getLogger(ApiTest777.class);
    ApplicationMethod app = new ApplicationMethod();
    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Test Start "  + m.getName());

    }

    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());

    }


    /*
    Football
     */

    //Tests for football services Main page

    @Test
    /*
    Get list of statuses
     */
    public void statusListTest(){

        String url = app.getQuery() + "/api/v1/matches/statuses";

        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }






    @Test
    /*
    Get list of category
     */
    public void footballCategoriesList(){

        String url = app.getQuery() + "/api/v1/football/categories/list";

        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get matches by date
     */
    public void footballMatchesByDate(){
        String url = app.getQuery() + "/api/v1/football/matches-by-date?"+ app.getDate();
        logger.info(ApplicationMethod.getDate() +" " + ApplicationMethod.requestConnection(url));
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");

    }


    @Test
    /*
    get top tournament List, football
     */

    public void footballGetTopTournamentList(){

        String url = app.getQuery() + "/api/v1/football/championships";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));
    }


    //football services tournament page
    @Test
    /*
    get information about current tournament
     */

    public void footballGetCurrentUniqueTournament(){

        String url = app.getQuery() + "/api/v1/football/unique_tournament/england/premier-league-2";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get Calendar current tournament
     */

    public void footbalGetCurrentUniqueTournamentCalendar(){
        String url = app.getQuery() + "/api/v1/tournaments/2/season/3644/calendar";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get Results of current tournament
     */

    public void footballGetCurrentUniqueTournamentResults(){
        String url = app.getQuery() + "/api/v1/tournaments/2/season/3644/results?offset=1";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get leaguetable of current tournament
     */

    public void footballGetCurrentUniqueTournamentLeagueTable(){
        String url = app.getQuery() + "/api/v1/football/tournaments/2/season/3644/leaguetable";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get Formtable of current tournament
     */

    public void footballGetCurrentUniqueTournamentFormTable(){
        String url = app.getQuery()+ "/api/v1/football/tournaments/2/season/3644/formtable";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }
    @Test
    /*
    get over under statistics of current tournament
     */

    public void footballGetOverUnderStat(){
        String url = app.getQuery()+ "/api/v1/football/tournaments/330/season/3660/overunderstats";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get Halftime Full Time statistics of current tournament
     */

    public void footballGetHalfTimeFulTimeStat(){
        String url = app.getQuery()+ "/api/v1/football/tournaments/330/season/3660/halftimefulltimetable";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get CupTree of current tournament
    /api/v1/football/cups/{tournament}/season/{season}/tree
     */

    public void footballGetCurrentUniqueTournamentCapTree(){
        String url = app.getQuery()+ "/api/v1/football/cups/1732/season/3693/tree";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get goalscorers of tournaments
    /api/v1/football/tournaments/{tournament}/season/{season}/goalscorers
     */

    public void footballGetCurrentUniqueTournamentGoalscorers(){
        String url = app.getQuery()+ "/api/v1/football/tournaments/2/season/3644/goalscorers";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    /*@Test -  метод устарел
    *//*
    get matches by date for tournament
    /api/v1/football/matches-by-date/{tournament}/{season}
     *//*

    public void footballGetTournamentMatchesByDate(){
        String url = app.getQuery()+ "/api/v1/football/matches-by-date/2/3644";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        ApplicationMethod.log.info(ApplicationMethod.requestConnection(url));

    }*/




    //football team page services
    @Test
    /*
    get information about team(Arsenal)
     */

    public void footballGetTeamInfo(){
        String url = app.getQuery()+ "/api/v1/football/teams/885";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }
    @Test
    /*
    get page information about team(Arsenal) for mobile
     */

    public void footballGetTeamInfoMobile(){
        String url = app.getQuery()+ "/api/v1/football/teams/885/info";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get  team results(Arsenal)
     */

    public void footballGetTeamResults(){
        String url = app.getQuery()+ "/api/v1/football/teams/885/results";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get  team Players(Arsenal)
     */

    public void footballGetTeamPlayers(){
        String url = app.getQuery()+ "/api/v1/football/teams/885/players";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get  team Schedules (Arsenal)
     */

    public void footballGetTeamSchedules(){
        String url = app.getQuery()+ "/api/v1/football/teams/885/schedules";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


  //football player page
  @Test
    /*
    get  information about player
     */

  public void footballGetPlayerInfo(){
      String url = app.getQuery()+ "/api/v1/football/players/1351";
      Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
      logger.info(ApplicationMethod.requestConnection(url));

  }


    @Test
    /*
    get  information about player last matches
     */

    public void footballGetPlayerLastMatches(){
        String url = app.getQuery()+ "/api/v1/football/players/1351/last-matches?page=1";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get  information about player career
     */

    public void footballGetPlayerCareer(){
        String url = app.getQuery()+ "/api/v1/football/players/career/1351";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    @Test
    /*
    get  information about player transitions
     */

    public void footballGetPlayerTransitions(){
        String url = app.getQuery()+ "/api/v1/football/players/transitions/1351";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    //football Match Details  page

    @Test
    /*
    get  information about match by slug
     */

    public void footballGetMatchPageInfoBySlug(){
        String url = app.getQuery()+ "/api/v1/football/matches/watford-manchester-city-21-05-2017-30698";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get  information about match by match id
     */

    public void footballGetMatchPageInfoById(){
        String url = app.getQuery()+ "/api/v1/football/matches/30698";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get  information about Head to Head matches
     */

    public  void footballGetHeadToHeadMatches(){
        String url = app.getQuery()+ "/api/v1/football/matches/30698/headtohead";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }





}
