package kz.epam.happylab.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static kz.epam.happylab.util.Constant.PASSWORD;
import static kz.epam.happylab.util.Constant.USER;

public class ConnectionPool {
    private final static Logger logger = Logger.getLogger(ConnectionPool.class);
    private static final String DB_PARAMS = "config";
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String POOLSIZE = "poolsize";
    private static final int DEFAULT_POOL_SIZE = 10;
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connectionQueue;

    private ConnectionPool (String driver, String url, String user, String password, int poolSize) throws ClassNotFoundException, SQLException {
        Class.forName (driver);
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            connectionQueue.offer (connection);
        }
    }

    public static void init () {
        if (instance == null) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_PARAMS);
            String driver = resourceBundle.getString(DRIVER);
            String url = resourceBundle.getString(URL);
            String user = resourceBundle.getString(USER);
            String password = resourceBundle.getString(PASSWORD);
            String poolSizeStr = resourceBundle.getString(POOLSIZE);

            int poolSize = (poolSizeStr != null) ? Integer.parseInt(poolSizeStr) : DEFAULT_POOL_SIZE;
            try {
                instance = new ConnectionPool(driver, url, user, password, poolSize);
            } catch (SQLException | ClassNotFoundException e) {
                logger.error(e);
            }
        }
    }

    public static ConnectionPool getInstance () {
        return instance;
    }

    public static void dispose ()  {
        if (instance != null) {
            try {
                instance.clearConnectionQueue ();
            } catch (SQLException e) {
                logger.error(e);
            }
            instance = null;
        }
    }

    public Connection takeConnection () {
        Connection connection = null;

        try {
            connection = connectionQueue.take ();
        } catch (InterruptedException e) {
            logger.error(e);
        }

        return connection;
    }

    public void releaseConnection (Connection connection) {

        try {
            if (!connection.isClosed ()) {
                connectionQueue.offer(connection);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    private void clearConnectionQueue () throws SQLException {
        Connection connection;
        while ((connection = connectionQueue.poll ()) != null) {
            if (!connection.getAutoCommit ()) {
                connection.commit ();
            }
            connection.close ();
        }
    }
}
