package controller;

import com.itextpdf.text.DocumentException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import model.AppData;
import model.Item;
import model.Order;
import service.ItemDBService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderPrTyController extends ViewController implements Initializable {

    ItemDBService itemDBService = new ItemDBService();


    @FXML public TableView<Order> tableView;
    @FXML private TableColumn<Item, Integer> idTableColumn;
    @FXML public TableColumn<Item, String> productTypeTableColumn;
    @FXML public TableColumn<Item, Double> priceTableColumn;
    @FXML public TableColumn<Item, Integer> countTableColumn;
    @FXML public TableColumn<Item, String> genderTableColumn;
    @FXML public TableColumn<Item, String> produceTypeTableColumn;
    @FXML public TableColumn<Item, String> sizeTableColumn;
    @FXML public TableColumn<Item, String> colourTableColumn;
    @FXML public TableColumn<Item, String> typeNameTableColumn;
    @FXML public TableColumn<Item, String> customerNameTableColumn;
    @FXML public TableColumn<Item, String> customerEmailTableColumn;
    @FXML public TableColumn<Item, String> customerPhoneTableColumn;
    @FXML public TableColumn<Item, String> deliveryMethodTableColumn;


    public Item item;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            productTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
            priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
            genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            produceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("produceType"));
            sizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
            colourTableColumn.setCellValueFactory(new PropertyValueFactory<>("colour"));
            typeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));
            customerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            customerEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
            customerPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
            deliveryMethodTableColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryMethod"));
            try {
                tableView.setItems(itemDBService.getOrderByProductType(AppData.getInstance().getProductTypeComboBox()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "allOrderReport", 1100, 600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }


    public void showTable(ActionEvent actionEvent) {
        OrderPrTypeReportController orderPrTypeReportController = new OrderPrTypeReportController();
        try {
            orderPrTypeReportController.printDocument();
        } catch (DocumentException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
