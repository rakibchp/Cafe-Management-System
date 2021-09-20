package cafe.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {

    private final static String USER = "root";
    private final static String PWD = "123456";
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String DATABASE_NAME = "cms";
    private static Connection conn = null;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        if ((conn == null)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL + DATABASE_NAME, USER, PWD);
            return conn;
        }
        return conn;
    }
}
