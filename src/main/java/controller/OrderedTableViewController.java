package controller;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;
import model.Order;
import service.OrderedReportDBService;
import service.ReportDBService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderedTableViewController extends ViewController implements Initializable {

    OrderedReportDBService OrderedReportDBService = new OrderedReportDBService();
    @FXML public TableView<Order> tableView;

    @FXML public TableColumn<Item, String> productTypeTableColumn;
    @FXML public TableColumn<Item, Double> priceTableColumn;
    @FXML public TableColumn<Item, Integer> countTableColumn;
    @FXML public TableColumn<Item, String> genderTableColumn;
    @FXML public TableColumn<Item, String> produceTypeTableColumn;
    @FXML public TableColumn<Item, String> sizeTableColumn;
    @FXML public TableColumn<Item, String> colourTableColumn;
    @FXML public TableColumn<Item, String> typeNameTableColumn;
    @FXML public TableColumn<Item, Double> totalPriceTableColumn;
    @FXML public TableColumn<Item, String> customerNameTableColumn;
    @FXML public TableColumn<Item, String> customerEmailTableColumn;
    @FXML public TableColumn<Item, String> customerPhoneTableColumn;
    @FXML public TableColumn<Item, String> deliveryMethodTableColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        produceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("produceType"));
        sizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        colourTableColumn.setCellValueFactory(new PropertyValueFactory<>("colour"));
        typeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        totalPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        customerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
        customerPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        deliveryMethodTableColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryMethod"));


        try {
            tableView.setItems(OrderedReportDBService.getOrderedItems());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600,600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void showTable(ActionEvent actionEvent) {
        PrintOrderedReportController printOrderedReportController = new PrintOrderedReportController();
        try {
            printOrderedReportController.printDocument();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
