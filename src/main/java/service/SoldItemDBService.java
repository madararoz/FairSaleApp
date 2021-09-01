package service;

import model.Item;
import repository.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class SoldItemDBService {
    private Connection connection = DBHandler.getConnection();


    public void addSoldItemToDB(Item item) throws Exception {

        String query = "INSERT INTO items (id, product_type, price, count, gender, produce_type, size, colour, type_name) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, item.getId());
        statement.setString(2, item.getProductType());
        statement.setDouble(3, item.getPrice());
        statement.setInt(4, item.getCount());
        statement.setString(5, item.getGender());
        statement.setString(6, item.getProduceType());
        statement.setInt(7, item.getSize());
        statement.setString(8, item.getColour());
        statement.setString(9, item.getTypeName());


        statement.executeUpdate();
        DBHandler.close(statement, connection);


    }
}



