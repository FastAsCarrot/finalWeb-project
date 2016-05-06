package connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * Created by Filipp Pisarev.
 */
public class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/Payments";
    private static final String USER = "Admin";
    private static final String PASSWORD = "gi2Raffew";
    private static final int POOLSIZE = 5;

    private ConnectionPool() {
    }

    private  Connection createConnection() {
        Connection connection = null;
        try {
            PoolProperties p = new PoolProperties();
            p.setUrl(URL);
            p.setDriverClassName(DRIVER);
            p.setUsername(USER);
            p.setPassword(PASSWORD);
            p.setMaxActive(POOLSIZE);
            DataSource dataSource = new DataSource();
            dataSource.setPoolProperties(p);

            connection = dataSource.getConnection();
        } catch(SQLException e) {
            System.out.println("Error: unable to Connect to Database");
        }

        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

}
