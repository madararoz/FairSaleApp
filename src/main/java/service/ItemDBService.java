package service;

import controller.TableViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Gender;
import model.Item;
import model.Order;
import model.ProductType;
import repository.DBHandler;
import repository.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ItemDBService {
    private Connection connection = DBHandler.getConnection();


    public void addSoldItemToDB(Item item) throws Exception {


        PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ITEMS);
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

        PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ORDERS);
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

    public ObservableList<Item> getByProductType(String productType) throws SQLException {
        ObservableList<Item> productTypeItems = FXCollections.observableArrayList();
        PreparedStatement statement = connection.prepareStatement(Queries.SEARCH_BY_PRODUCT_TYPE);
        statement.setString(1, productType);
        ResultSet result = statement.executeQuery();

        while (result.next()){
            Item item = new Item(
                    result.getString("product_type"),
                    result.getDouble("price"),
                    result.getInt("count"),
                    result.getString("gender"),
                    result.getString("produce_type"),
                    result.getString("size"),
                    result.getString("colour"),
                    result.getString("type_name"));

            productTypeItems.add(item);
        }

        return productTypeItems;

    }

}



