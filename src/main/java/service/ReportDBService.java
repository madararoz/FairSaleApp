package service;
import controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import model.Gender;
import model.Item;
import model.ProduceType;
import model.ProductType;
import repository.DBHandler;
import repository.Queries;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ReportDBService {
    public TableColumn actionCol;
    public Connection connection = DBHandler.getConnection();

    public ObservableList<Item> getSoldItems() throws SQLException {

        ObservableList<Item> soldItems = FXCollections.observableArrayList();
      //  ArrayList<Item> soldItems = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ITEMS);
        ResultSet result = statement.executeQuery();

            while (result.next()) {
                Item item = new Item(
                        ProductType.valueOf(result.getString("product_type")),
                        result.getDouble("price"),
                        result.getInt("count"),
                        Gender.valueOf(result.getString("gender")),
                        ProduceType.valueOf(result.getString("produce_type")),
                        result.getString("size"),
                        result.getString("colour"),
                        result.getString("type_name"));

                soldItems.add(item);
            }
        return soldItems;
    }

    public void getOrderedItems(ActionEvent actionEvent) {
    }


}