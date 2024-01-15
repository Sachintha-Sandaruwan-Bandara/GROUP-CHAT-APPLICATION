package lk.ijse.GROUP_CHAT_APPLICATION.db;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 8:44 PM 
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

        private static DbConnection dbConnection;
        private Connection connection;

        private DbConnection() throws SQLException {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/GROUP_CHAT",
                    "root",
                    "2002"
            );
        }

        public static DbConnection getInstance() throws SQLException {
            return (null == dbConnection) ? dbConnection = new DbConnection() : dbConnection;
        }

        public Connection getConnection() {
            return connection;
        }

}


