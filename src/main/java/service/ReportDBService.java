package service;
import controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import model.Item;
import model.Order;
import repository.DBHandler;
import repository.Queries;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ReportDBService extends ViewController {

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
//        PreparedStatement statement = connection.prepareStatement(Queries.SEARCH_BY_PRODUCT_TYPE);
//        statement.setString(1, String.valueOf(productTypeController.getSearchProductTypeComboBox()));
//        ResultSet result = statement.executeQuery();

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

        ObservableList<Order> orderedItems = FXCollections.observableArrayList();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ORDERS);
        ResultSet result = statement.executeQuery();
//        PreparedStatement statement = connection.prepareStatement(Queries.SEARCH_BY_PRODUCT_TYPE);
//        statement.setString(1, String.valueOf(productTypeController.getSearchProductTypeComboBox()));
//        ResultSet result = statement.executeQuery();

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



    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600, 600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

}