package com.dorm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Interacts with the persistence.txt to get JDBC set up by clients specifications
 */
public class ConnectionUtilTemp {

    private static ConnectionUtilTemp instant;

    private ConnectionUtilTemp(){}

       public static ConnectionUtilTemp getInstance(){
           if(instant == null){
                instant = new ConnectionUtilTemp();
            }
            return instant;
        }

        public Connection getConnection() throws SQLException {
            //url -- jdbc:postgresql://[host address]:[port]/[db Name]?currentSchema=[schema Name]
            return DriverManager.getConnection("jdbc:postgresql://database-project-0.cuvhoho6cgmh.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=project_zero",
                    "derick",
                    "toyota");
        }
}
