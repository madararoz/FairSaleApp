package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;
import model.Order;
import repository.DBHandler;
import repository.Queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ItemDBService {
    private Connection connection = DBHandler.getConnection();


    public void addSoldItemToDB(Item item) throws Exception {


        PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ITEMS);
        statement.setString(1, item.getProductType());
        statement.setDouble(2, item.getPrice());
        statement.setInt(3, item.getCount());
        statement.setString(4, item.getGender());
        statement.setString(5, item.getProduceType());
        statement.setString(6, item.getSize());
        statement.setString(7, item.getColour());
        statement.setString(8, item.getTypeName());


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
                    result.getInt("id"),
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


    public ObservableList<Order> getOrderByProductType(String productType) throws SQLException {
        ObservableList<Order> productTypeOrders = FXCollections.observableArrayList();
        PreparedStatement statement = connection.prepareStatement(Queries.SEARCH_ORDERS_BY_PRODUCT_TYPE);
        statement.setString(1, productType);
        ResultSet result = statement.executeQuery();

        while (result.next()){
            Order order = new Order(
                    result.getInt("id"),
                    result.getString("product_type"),
                    result.getDouble("price"),
                    result.getInt("count"),
                    result.getString("gender"),
                    result.getString("produce_type"),
                    result.getString("size"),
                    result.getString("colour"),
                    result.getString("type_name"),
                    result.getString("customer_name"),
                    result.getString("customer_email"),
                    result.getString("customer_phone"),
                    result.getString("delivery_method"));


            productTypeOrders.add(order);
        }

        return productTypeOrders;

    }




    public void deleteItem(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.DELETE_ITEM);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }


    public void updateProductType(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_PRODUCT_TYPE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();

    }

    public void updatePrice(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_PRICE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();

    }

    public void updateCount(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_COUNT);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateGender(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_GENDER);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateProduceType(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_PRODUCE_TYPE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateSize(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_SIZE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateColour(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_COLOUR);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateTypeName(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_TYPE_NAME);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void deleteOrder(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.DELETE_ORDER);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }


    public void updateOrderProductType(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_PRODUCT_TYPE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();

    }

    public void updateOrderPrice(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_PRICE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();

    }

    public void updateOrderCount(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_COUNT);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderGender(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_GENDER);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderProduceType(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_PRODUCE_TYPE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderSize(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_SIZE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderColour(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_COLOUR);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderTypeName(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_TYPE_NAME);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }


    public void updateOrderCustomerName(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_CUSTOMER_NAME);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderCustomerEmail(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_CUSTOMER_EMAIL);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderCustomerPhone(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_CUSTOMER_PHONE);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateOrderDeliveryMethod(String newValue, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_DELIVERY_METHOD);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }


}



