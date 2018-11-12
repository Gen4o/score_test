package com.score.database;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBWorker {

    public Session openSshSession(DbSource dbSource) {
        Session session = null;
        try {
            //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
            Properties config = getProperties();
            JSch jsch = new JSch();
            String password = dbSource.getPassword();
            session = jsch.getSession(dbSource.getUser(), dbSource.getHost(), 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
            String rhost = dbSource.getRhost();
            int rport = dbSource.getRport();
            int assinged_port = session.setPortForwardingL(dbSource.getLport(),
                    rhost, rport);
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
            System.out.println("Port Forwarded");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return session;
    }

    //mysql database connectivity
    public Connection openMySqlConnection(Session session, DbSource dbSource) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbSource.getUrl()
                    + "?useSSL=false", dbSource.getDbuserName(),
                    dbSource.getDbpassword());
            System.out.println("Database connection established");
            System.out.println("DONE");
            Statement stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    private Properties getProperties() {
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        return config;
    }

    public void closeMysqlConnection(Session session, Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            System.out.println("Closing Database Connection");
            conn.close();
        }
        if (session != null && session.isConnected()) {
            System.out.println("Closing session");
            session.disconnect();
        }
    }

}
