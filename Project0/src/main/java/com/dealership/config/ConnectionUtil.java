package com.dealership.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static ConnectionUtil instance;

    private ConnectionUtil(){}

    public static ConnectionUtil getInstance(){
        if(instance == null){
            instance = new ConnectionUtil();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
                                            //url -- jdbc:postgresql://[host address]:[port]/[db Name]?currentSchema=[schema Name]
        return DriverManager.getConnection("jdbc:postgresql://database-project-0.cuvhoho6cgmh.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=project_zero",
                "derick",
                "toyota");
    }
}
