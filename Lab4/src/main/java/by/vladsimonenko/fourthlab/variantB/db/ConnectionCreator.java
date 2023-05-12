package by.vladsimonenko.fourthlab.variantB.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    static Logger logger = LogManager.getLogger();
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;

    static {
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
            String driverName = (String) properties.get("db.driver");
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        DATABASE_URL = (String) properties.get("db.url");
    }

    private ConnectionCreator(){}

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL,properties);
    }
}
