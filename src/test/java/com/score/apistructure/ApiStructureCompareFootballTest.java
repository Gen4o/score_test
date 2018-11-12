package com.score.apistructure;


import org.testng.annotations.*;


public class ApiStructureCompareFootballTest {


   ApiStructureBase apiBase = new ApiStructureBase();

   @BeforeMethod(description = "init base url")
   public void setup()
   {
       apiBase.getSetup(apiBase.BASE_PATH_FOOTBALL);
   }

    @Test(groups = {"1"}, description = "проверка  списка турниров")
    public void checkTournamentListTest(){

       apiBase.checkScheme("/categories/list","schema/categorylist_chema.json");
    }

    @Test(groups = {"1"}, description = "проверка списка топ турниров")
    public void checkTopTournamentList() {
        apiBase.checkScheme("/championships","schema/championships_schema.json");

    }

     @Test(groups = {"1"}, description = "сервис  страница турнира")
    public void  checkUniqueTournament(){
         apiBase.checkScheme("/unique_tournament/england/premier-league-2","schema/uniquetournament_schema.json");

    }



    @Test(groups = {"1"}, description = "страница турнира leaguetable\n" +
            "    в схеме валидируется и максимальное количество объектов для lastMatches & FutureMatches - 5 & 2 соответственно")
    public void  checkUniqueTournamentLeaguetable(){
                apiBase.checkScheme("/tournaments/2/season/3644/leaguetable","schema/tournamentleaguetable_schema.json");
    }

    @Test(groups = {"1"}, description = "Страница турнира - Formtable")
    /**
     * Страница турнира - Formtable -  содержит в себе 2 объекта и 1 массив объектов
     * 1. formTable - массив  со списком команд в разрезе по коэфициентам от 0.5 - 5, и вразрезе home/total/away
     * 2. lastMatches-   последние матчи команд турнира, разбиты по объектам home/total/away в которых массив из 5
     * последних матчей для каждой команды.
     * 3. futureMatches будущие матчи команд турнира разбиты по объектам home/total/away в которых массив из 2х
     * последних матчей для каждой команды.
     *
     *схема полностью не реализована так как непонятно как указать пустой ключь для массива матчей команды
     * у которого ключ это ид коамады
     */
    public void  checkUniqueTournamentFormtable(){
        apiBase.checkScheme("/tournaments/2/season/3644/formtable","schema/tournamentformtable_schema.json");

    }


    @Test(groups = {"1"},description = "в схеме валидируется структура ответа сервиса /api/v1/football/cups/1732/season/3693/tree\n" +
            "     предоставляющего сетку турнира")
    /*
    * Сетка турнира
     *в схеме валидируется структура ответа сервиса /api/v1/football/cups/1732/season/3693/tree
     *предоставляющего сетку турнира
     */

    public void  checkCuptree(){
        apiBase.checkScheme("/cups/1281/season/4688/tree","schema/tournamentcuptree_schema.json");

}

    @Test(groups = {"1"},description = "бомбардиры турнира")
    /*
    * бомбардиры турнира
     *в схеме валидируется структура ответа сервиса /api/v1/football/tournaments/2/season/3644/goalscorers
     *выводится информация об игроке, количество забитых  за команду и количечтво асистов
     */

    public void  checkTournamentGoalscorers(){
        apiBase.checkScheme("/tournaments/2/season/3644/goalscorers","schema/tournaments_goalscorers.json");

    }

    @Test(groups = {"1"}, description = "Информация о команде")
    /*
    * Информация о команде
     *в схеме валидируется структура ответа сервиса /api/v1/football/teams/885
     *выводится информация об команде, название, слаг, лого
     */

    public void  checkTeamInfo(){
        apiBase.checkScheme("/teams/885","schema/team.json");

    }

    @Test(groups = {"1"},description = "Информация о результатах команды по турнирам в которых она принимала участие")
    /*
    * Информация о результатах команды по турнирам в которых она принимала участие
     *в схеме валидируется структура ответа сервиса /api/v1/football/teams/885/results
     */

    public void  checkTeamResults(){
        apiBase.checkScheme("/teams/885/results","schema/team_results.json");

    }

    @Test(groups = {"1"}, description ="Список игроков команды на текущий сезон" )
    /*
    * Список игроков команды на текущий сезон
     *в схеме валидируется структура ответа сервиса /api/v1/football/teams/885/players
     */

    public void  checkTeamPlayers(){
        apiBase.checkScheme("/teams/885/players","schema/team_players.json");

    }

    @Test(groups = {"1"},description = "Расписание игр команды, по турнирам")
    /*
    * Расписание игр команды, по турнирам
     *в схеме валидируется структура ответа сервиса /api/v1/football/teams/1911/schedules
     */

    public void  checkTeamSchedules(){
        apiBase.checkScheme("/teams/1911/schedules","schema/teams_schedules.json");

    }

    @Test(groups = {"1"},description = "Информация о игроке")
    /*
    * Информация о игроке
     *в схеме валидируется структура ответа сервиса /api/v1/football/players/1351
     */
    public void  checkPlayerInfo(){
        apiBase.checkScheme("/players/1351","schema/player_info.json");

    }



    @Test(groups = {"1"},description = "Информация о  последних матчах игрока")
    /*
    * Информация о  последних матчах игрока
     *в схеме валидируется структура ответа сервиса /api/v1/football/players/1351/last-matches?page=1
     */

    public void  checkPlayLastMatches(){
        apiBase.checkScheme("/players/1351/last-matches?page=1","schema/player_last_matches.json");

    }


    @Test(groups = {"1"},description = "Информация о  карьере игрока")
    /*
    * Информация о  карьере игрока
     *в схеме валидируется структура ответа сервиса /api/v1/football/players/career/1351
     */

    public void  checkPlayCareer(){
        apiBase.checkScheme("/players/career/1351","schema/player_career.json");

    }

    @Test(groups = {"1"},description = "Информация о  трансферах игрока")
    /*
    * Информация о  трансферах игрока
     *в схеме валидируется структура ответа сервиса /api/v1/football/players/transitions/13511351
     */

    public void  checkPlayTransfer(){
        apiBase.checkScheme("/players/transitions/1351","schema/player_transfer.json");

    }


    @Test(groups = {"1"}, description = "Информация о  Встречах команд учавствовавшихв матче")
    /*
    * Информация о  Встречах команд учавствовавшихв матче
     *в схеме валидируется структура ответа сервиса /api/v1/football/matches/366671/headtohead
     */

    public void  checkMatchesH2H(){
        apiBase.checkScheme("/matches/366671/headtohead","schema/matchesH2H.json");

    }

    @Test(groups = {"1"}, description = "Информация о  всех турнирах, по категориям")
    /*
    * Информация о  всех турнирах, по категориям
     *в схеме валидируется структура ответа сервиса /api/v1/football/categories/all-with-tournaments
     */

    public void  checkAllWithTournaments(){
        apiBase.checkScheme("/categories/all-with-tournaments","schema/all_with_tournaments.json");

    }

    @Test(groups = {"1"},description = " Архив турниров для уникального турнира - турниры по сезонам.")
    /*
    * Архив турниров для уникального турнира - турниры по сезонам.
     *в схеме валидируется структура ответа сервиса /api/v1/football/unique_tournaments/577/archive
     */

    public void  checkArchive(){
        apiBase.checkScheme("/unique_tournaments/577/archive","schema/archive.json");

    }


    @Test(groups = {"2"}, description = "страница турнира расписание" )
    //страница турнира расписание
    public void  checkUniqueTournamentCalendar(){
        apiBase.getSetup("/api/v1");
        apiBase.checkScheme("/tournaments/2/season/3644/calendar","schema/tournamentcalendar_schema.json");

    }


    @Test(groups = {"2"}, description = "страница турнира результаты")
    //страница турнира результаты
    public void  checkUniqueTournamentResults(){
        apiBase.getSetup("/api/v1");
        apiBase.checkScheme("/tournaments/2/season/3644/results","schema/tournamentresults_schema.json");

    }














}
