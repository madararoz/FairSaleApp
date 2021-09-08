package service;
import controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import model.Item;
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
    public TableView tableView;
    public TableView tableViewOrder;

    public ObservableList<Item> getSoldItems() throws SQLException {

        ObservableList<Item> soldItems = FXCollections.observableArrayList();
      //  ArrayList<Item> soldItems = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ITEMS);
        ResultSet result = statement.executeQuery();

            while (result.next()) {
                Item item = new Item(
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


    public ArrayList<Item> getSoldItemsArray() throws SQLException {
        ArrayList<Item> soldItems = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ITEMS);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            Item item = new Item(
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


    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600, 600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

}