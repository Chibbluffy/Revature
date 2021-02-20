package dev.wan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection createConnection(){

        String details = System.getenv("DBLINK");
        try {
            Connection conn = DriverManager.getConnection(details); // a factory
            // pass in string details for any type of database anywhere
            // this DriverManager factory will give you back a connection implementation specifically for postgres
            return conn;
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
            return null;
        }
    }
}
