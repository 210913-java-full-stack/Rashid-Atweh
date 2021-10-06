package utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 *
 */
public class ConnectionManager {
    public static Connection conn;
    public static String currentUserName; //I would suggest replacing this with a user model
    //remember a model is a POJO, a plain old java object, that is just the necessary fields
    //with getters and setters. A model should represent the same data as a database row here in java memory

    private ConnectionManager() {

    }

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public static void setCurrentUserName(String currentUserName) {
        ConnectionManager.currentUserName = currentUserName;
    }

    /*
        This is a static method for returning a connection in the factory singleton design pattern
         */
    public static Connection getConnection() {
        if(conn == null) {
            try {
                Properties props = new Properties();
                FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
                props.load(connectionProperties);

                //"jdbc:mariadb://hostname:port/databaseName?user=username&password=password"
                String connString = "jdbc:mariadb://" +
                        props.getProperty("hostname") + ":" +
                        props.getProperty("port") + "/" +
                        props.getProperty("databaseName") + "?user=" +
                        props.getProperty("user") + "&password=" +
                        props.getProperty("password");


                conn = DriverManager.getConnection(connString);
            } catch(SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

}
