package service;

import model.Item;
import repository.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SoldItemDBService {
    private Connection connection = DBHandler.getConnection();


    public void addSoldItemToDB(Item item) throws Exception {
        String query = "INSERT INTO items (id, price, gender, size, colour, type_name, mark_as_sold, produceId, productId) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, item.getId());
        statement.setDouble(2, item.getPrice());
        statement.setString(3, item.getGender());
        statement.setInt(4, item.getSize());
        statement.setString(5, item.getColour());
        statement.setString(6, item.getTypeName());
        statement.setString(7, item.getMarkAsSold());
        statement.setInt(8, item.getProductId());
        statement.setString(9, item.getProductId());

        int result = statement.executeUpdate();
        DBHandler.close(result, statement, connection);


    }

}


