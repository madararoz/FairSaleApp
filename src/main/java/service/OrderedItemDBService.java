package service;

import model.Item;
import model.Order;
import repository.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderedItemDBService {

    private Connection connection = DBHandler.getConnection();

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

