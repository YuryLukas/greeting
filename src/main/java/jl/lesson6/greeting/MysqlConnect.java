package jl.lesson6.greeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Exception;

public class MysqlConnect {
    Connection connection;
    private String url;
    private String user;
    private String password;
    private final String driverName = "com.mysql.jdbc.Driver";

    public MysqlConnect(String url, String user, String password) throws Exception{
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName(this.driverName);
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
