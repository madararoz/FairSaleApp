package service;

import model.Item;
import repository.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderedItemDBService {

    private Connection connection = DBHandler.getConnection();

    public void addOrderedItemToDBService(Item item) throws Exception{

        String query = "INSERT INTO orders(product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, " +
                "customer_email, customer_phone, delivery_method) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, item.getProductType().toString());
        statement.setDouble(2, item.getPrice());
        statement.setInt(3, item.getCount());
        statement.setString(4, item.getGender().toString());
        statement.setString(5, item.getProduceType().toString());
        statement.setString(6, item.getSize());
        statement.setString(7, item.getColour());
        statement.setString(8, item.getTypeName());
        statement.setString(9,item.getCustomerName());
        statement.setString(10, item.getCustomerEmail());
        statement.setInt(11,item.getCustomerPhone());
        statement.setString(12, item.getDeliveryMethod());


        statement.executeUpdate();
        DBHandler.close(statement, connection);




    }


    }

