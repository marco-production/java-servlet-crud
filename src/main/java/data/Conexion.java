package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String CN_STR = "jdbc:mysql://localhost:3306/java_client_crud?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static BasicDataSource dataSource = null;

    // Pool de conexiones
    public static BasicDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(CN_STR);
            dataSource.setUsername(DB_USER);
            dataSource.setPassword(DB_PASS);
            dataSource.setInitialSize(50);
        }

        return dataSource;
    }

    // Get connection
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    // Close ResultSet
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    // Close Statement
    public static void close(Statement stmt) throws SQLException {
        stmt.close();
    }

    // Close Connection
    public static void close(Connection cn) throws SQLException {
        cn.close();
    }
}
