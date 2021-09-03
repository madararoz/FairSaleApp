package service;
import controller.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
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
    public TableColumn actionCol;
    private Connection connection = DBHandler.getConnection();

    public ArrayList<Item> getSoldItems(ActionEvent actionEvent) throws SQLException {

        ArrayList<Item> soldItems = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ITEMS);
        ResultSet result = statement.executeQuery();

//            while (result.next()) {
//                Item item = new Item(
//                        result.getInt("id"),
//                        new Item(result.getInt("product_type"), result.getString("owner_name")),
//
//                );
//                soldItems.add(item);
//            }
        return soldItems;
    }

    public void getOrderedItems(ActionEvent actionEvent) {
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start");
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}