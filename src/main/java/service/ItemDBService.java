package service;

import model.Gender;
import model.Item;
import model.Order;
import model.ProductType;
import repository.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ItemDBService {
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
        statement.setString(7, item.getSize());
        statement.setString(8, item.getColour());
        statement.setString(9, item.getTypeName());


        statement.executeUpdate();
        DBHandler.close(statement, connection);


    }


    public void addOrderedItemToDBService(Order order) throws Exception{

        String query = "INSERT INTO orders(product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, " +
                "customer_email, customer_phone, delivery_method) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, order.getProductType());
        statement.setDouble(2, order.getPrice());
        statement.setInt(3, order.getCount());
        statement.setString(4, order.getGender());
        statement.setString(5, order.getProduceType());
        statement.setString(6, order.getSize());
        statement.setString(7, order.getColour());
        statement.setString(8, order.getTypeName());
        statement.setString(9, order.getCustomerName());
        statement.setString(10, order.getCustomerEmail());
        statement.setString(11, order.getCustomerPhone());
        statement.setString(12, order.getDeliveryMethod());


        statement.executeUpdate();
        DBHandler.close(statement, connection);




    }
}



