package repository;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.*;

public class DBHandler {

        private static String pass;
        private static String user;
        private static String connectionUrl;
        private static Connection connection;


        DBHandler(){
            getSetDatabaseInfo();
        }

        private static void getSetDatabaseInfo() {
            PropertiesConfiguration databaseProperties = new PropertiesConfiguration();
            try {
                databaseProperties.load("database.properties");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            String host = databaseProperties.getString("database.host");
            String port = databaseProperties.getString("database.port");
            String dbName = databaseProperties.getString("database.name");


            pass = databaseProperties.getString("database.password");
            user = databaseProperties.getString("database.user");
            connectionUrl = host + ":" + port + "/" + dbName + "?serverTimezone=GMT%2B3";
        }

        public static Connection getConnection() {
            try {

                if(connection == null || connection.isClosed()) {
                    getSetDatabaseInfo();
                    connection = DriverManager.getConnection(connectionUrl, user, pass);
                }
            } catch (SQLException ex) {
                System.out.println("Unable to connect to database");
                ex.printStackTrace();
            }
            return connection;


        }


        public static void close(ResultSet result, PreparedStatement preparedStatement, Connection connection) {
            try {
                result.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}
