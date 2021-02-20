package dev.wan.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static Logger logger = Logger.getLogger(ConnectionUtil.class.getName());
    public static Connection createConnection(){

        String details = System.getenv("DBLINK");
        try{
            Connection conn = DriverManager.getConnection(details);
            logger.info("Connected to database");
            return conn;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.info("Failed to connect to database"+sqlException.getSQLState());
            return null;
        }
    }
}
