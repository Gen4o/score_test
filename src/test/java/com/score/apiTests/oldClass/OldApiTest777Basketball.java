package com.score.apiTests.oldClass;

import com.score.applicationmetods.ApplicationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OldApiTest777Basketball {

    ApplicationMethod app = new ApplicationMethod();
    Logger logger = LoggerFactory.getLogger(OldApiTest777Basketball.class);

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Test Start "  + m.getName());

    }

    @AfterMethod(alwaysRun = true)
    public void logTestFinish(Method m){
        logger.info("Test Finished " + m.getName());

    }

    //main page
    @Test
    /*
    Get H2H statistics
    /api/v1/basketball/leaguematches/{tournament}/season/{season}
     */

    public void basketballGetH2HStatistics(){
        String url = app.getQuery() + "/api/v1/basketball/leaguematches/582/season/110";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get top tournament List, basketball
     */

    public void basketballGetTopTournamentList(){

        String url = app.getQuery() + "/api/v1/basketball/championships";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));
    }

    @Test
    /*
    Get categories list basketball
     */
    public void basketballCategoriesList(){
        String url = app.getQuery() + "/api/v1/basketball/categories/list";

        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get Basket matches by date
    /api/v1/basketball/matches-by-date/
     */
    public void basketballMatchesByDate(){
        String url = app.getQuery() + "/api/v1/basketball/matches-by-date?date=" + ApplicationMethod.getDate();

        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }


    //category page
    @Test
    /*
    Get matches results fo category
    /api/v1/basketball/categories/results/matches/{category}
     */
    public void basketballCategoriesMatchesResults(){
        String url = app.getQuery() + "/api/v1/basketball/categories/list";

        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    GET /api/v1/basketball/season/champions/{id}
    Get basketball season champions info by uniqueTournament ID
     */
    public void basketballGetSeasonChampions(){
        String url = app.getQuery() + "/api/v1/basketball/season/champions/2";

        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    basketball
    get information about current tournament
    https://777score.com/api/v1/basketball/unique_tournament/usa/wnba-12
     */

    public void basketballGetCurrentUniqueTournament(){

        String url = app.getQuery() + "/api/v1/basketball/unique_tournament/usa/wnba-12";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    basketball
    get Calendar current tournament
    GET /api/v1/basketball/tournaments/{id}/season/{season}/calendar
     */

    public void basketballGetCurrentTournamentCalendar(){
        String url = app.getQuery() + "/api/v1/basketball/tournaments/27/season/158/calendar";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    basketball
    get Results of current tournament
     */

    public void basketballGetCurrentTournamentResults(){
        String url = app.getQuery() + "/api/v1/basketball/tournaments/27/season/158/results?offset=1";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    basketball
    get leaguetable of current tournament
     */

    public void basketballGetCurrentTournamentLeagueTable(){
        String url = app.getQuery()+ "/api/v1/basketball/tournaments/27/season/158/leaguetable";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    basketball
    get Formtable of current tournament
     */

    public void basketballGetCurrentTournamentFormTable(){
        String url = app.getQuery()+ "/api/v1/basketball/tournaments/27/season/158/formtable";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    basketball
    get Teams of current tournament
     */

    public void basketballGetCurrentTournamentTeams(){
        String url = app.getQuery()+ "/api/v1/basketball/tournaments/27/season/158/teams";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get CupTree of current tournament
    /api/v1/basketball/cups/{tournament}/season/{season}/tree
     */

    public void basketballGetCurrentTournamentCapTree(){
        String url = app.getQuery()+ "/api/v1/football/cups/576/season/101/tree";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    get H2H matches by match id
    /api/v1/basketball/matches/{id}/headtohead
     */

    public void basketballGetH2HMatches(){
        String url = app.getQuery()+ "/api/v1/basketball/matches/1/headtohead";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    // Category page Basketball
    @Test
    /*
    Get result matches for category by category Id
    GET /api/v1/basketball/categories/results/matches/{category}
     */

    public void basketballGetMatchResultsForCategory(){
        String url = app.getQuery()+ "/api/v1/basketball/categories/results/matches/2";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get schedules matches for category
    /api/v1/basketball/categories/schedule/matches/{category}
     */

    public void basketballGetMatchesScheduleForCategory(){
        String url = app.getQuery()+ "/api/v1/basketball/categories/schedule/matches/2";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get today matches for category
    GET /api/v1/basketball/categories/today/matches/{category}
     */

    public void basketballGetTodayMatchesForCategory(){
        String url = app.getQuery()+ "/api/v1/basketball/categories/today/matches/2";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get all tournaments by category id
    GET /api/v1/basketball/category/tournaments?id=2
     */

    public void basketballGetTournamentsForCategory(){
        String url = app.getQuery()+ "/api/v1/basketball/category/tournaments?id=2";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    //Basketball Team Page
    @Test
    /*
    Get Team results
    GET /api/v1/basketball/teams/{id}/results
     */

    public void basketballGetTeamResults(){
        String url = app.getQuery()+ "/api/v1/basketball/teams/2/results";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get Team results
    GET /api/v1/basketball/teams/{id}/schedules
     */

    public  void basketballGetTeamSchedule(){
        String url = app.getQuery() + "/api/v1/basketball/teams/101/schedules";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get Team results
    GET /api/v1/basketball/teams/{team slug}
     */

    public  void basketballGetTeamOverview(){
        String url = app.getQuery()+ "/api/v1/basketball/teams/manchester-giants-3";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }

    @Test
    /*
    Get single  match by slug
    GET /api/v1/basketball/matches/{slug}
     */

    public void basketballGetSingleMatchBySlug(){
        String url = app.getQuery()+ "/api/v1/basketball/matches/globalport-batang-pier-rain-or-shine-elasto-21-07-2017-25743";
        Assert.assertEquals(ApplicationMethod.requestConnection(url), "200_Ok");
        logger.info(ApplicationMethod.requestConnection(url));

    }
}
