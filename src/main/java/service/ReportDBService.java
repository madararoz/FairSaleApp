package service;
import controller.StartController;
import controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import model.Item;
import model.Order;
import repository.DBHandler;
import repository.Queries;


import javax.swing.text.View;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class ReportDBService extends StartController {

    public Connection connection = DBHandler.getConnection();


    public ObservableList<Item> getSoldItems() throws SQLException {

        ObservableList<Item> soldItems = FXCollections.observableArrayList();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ITEMS);
        ResultSet result = statement.executeQuery();

            while (result.next()) {
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

                soldItems.add(item);
            }
        return soldItems;
    }

    public ObservableList<Order> getOrderedItems() throws SQLException {

        ObservableList<Order> orderedItems = FXCollections.observableArrayList();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ORDERS);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
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

            orderedItems.add(order);
        }
        return orderedItems;
    }

    public ObservableList<Order> getOrderedItemsByDate() throws SQLException {

        ObservableList<Order> orderedItemsByDate = FXCollections.observableArrayList();
        PreparedStatement statement = connection.prepareStatement(Queries.SEARCH_ORDERS_BY_DATE);
        statement.setObject(1, orderDate);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            Order orderDay = new Order(
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

            orderedItemsByDate.add(orderDay);
        }
        return orderedItemsByDate;
    }

    public DatePicker getDate() throws Exception {
        String query = "SELECT created_at FROM orders WHERE date(created_at) = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, java.sql.Date.valueOf(orderDate.getValue()));
        ResultSet result = statement.executeQuery();

        DatePicker orderDate = null;
        if (result.next()) orderDate = (DatePicker) result.getObject("created_at");

        DBHandler.close(result, statement, connection);

        if (orderDate == null) throw new Exception("No orders on " + orderDate + " date!");

        return orderDate;
    }


    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600, 600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

}