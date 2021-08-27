package DbHelper;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection() {
        Connection connection = null;

        try {
//            connection = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11432888", DbInfo.USERNAME.getValue(),
//                    DbInfo.PASSWORD.getValue());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/cowsandbulls", "root", "Mikus2909");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
