package com.score.database;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;
import java.util.Properties;

class DbSource {

    private int lport = 5656;
    private String rhost = "your ip";
    private String host = "your host";
    private int rport = 3306;
    private String user = "user";
    private String password = "passsword";
    private String dbuserName = "dbUser";
    private String dbpassword = "dbPassword";
    private String url = "jdbc:mysql://localhost:" + lport + "/score";
    private String driverName = "com.mysql.jdbc.Driver";

    public String getUser() {
        return user;
    }

    public String getHost() {
        return host;
    }

    public int getLport() {
        return lport;
    }

    public int getRport() {
        return rport;
    }

    public String getRhost() {
        return rhost;
    }

    public String getUrl() {
        return url;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public String getDbuserName() {
        return dbuserName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getPassword() {
        return password;
    }

}
