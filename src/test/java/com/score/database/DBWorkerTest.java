package com.score.database;

import com.jcraft.jsch.Session;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;

import static org.testng.Assert.*;

public class DBWorkerTest {

    DBWorker instance = null;
    final DbSource dbSource = new DbSource();

    @BeforeMethod
    public void setUp() throws Exception {
        instance = new DBWorker();
    }

    @Test
    public void shouldCheckConnection() throws Exception {
        Session session = null;
        Connection connection = null;
        try{
            session = instance.openSshSession(dbSource);
            connection = instance.openMySqlConnection(session, dbSource);
        }finally {
            instance.closeMysqlConnection(session, connection);
        }
    }

    @After
    public void teardown(){

    }
}