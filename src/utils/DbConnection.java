package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/pao2021";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "root";
    private final Connection connection;

    private DbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor();
            this.connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USER_NAME,DATABASE_PASSWORD);
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException exception) {
            throw  new RuntimeException("Something went wrong during connection/driver invocation.");
        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DATABASE_URL,DATABASE_USER_NAME,DATABASE_PASSWORD);
    }

    private static final class SINGLETON_HOLDER{
        private static final DbConnection INSTANCE = new DbConnection();
    }
    public static DbConnection getInstance(){
        return SINGLETON_HOLDER.INSTANCE;
    }
    public Connection getDBConnection() {
        return this.connection;
    }
}
