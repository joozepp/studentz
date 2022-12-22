package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {


    public static Connection DbConn() {
        // Declare the connection outside the try/catch block to allow you
        // return it after the commands have been executed.

        Connection connection = null;

        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://babar.db.elephantsql.com/eisislcy",
                            "eisislcy","9BHsQ5CTzW6T9S1cLtIW4OCmCaRqQF5o");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}