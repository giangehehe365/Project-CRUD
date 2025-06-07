package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost;instanceName=MSSQLSERVER01;databaseName=Sp25_DemoPRJ;encrypt=true;trustServerCertificate=true";
    private static final String USER_DB = "sa";
    private static final String PASS_DB = "123456";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("JDBC Driver loaded.");
            con = DriverManager.getConnection(DB_URL, USER_DB, PASS_DB);
            System.out.println("Connected to database successfully.");

        } catch (ClassNotFoundException e) {
            System.err.println("Cannot find JDBC driver: " + DRIVER_NAME);
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return con;
    }

    // Test kết nối
    public static void main(String[] args) {
        System.out.println("Starting DBConnection test...");

        Connection conn = getConnection();

        if (conn != null) {
            System.out.println("Connection test succeeded!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection test failed!");
        }
    }
}
