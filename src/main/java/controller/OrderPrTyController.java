package controller;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AppData;
import model.Item;
import service.ItemDBService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderPrTyController extends ProductTypeController implements Initializable {


    public TableView<Item> tableView;
    public ComboBox searchProductTypeComboBox;
    ItemDBService itemDBService = new ItemDBService();
    TableViewController tableViewController = new TableViewController();


    @FXML private TableColumn<Item, String> productTypeTableColumn;
    @FXML private TableColumn<Item, Double> priceTableColumn;
    @FXML private TableColumn<Item, Integer> countTableColumn;
    @FXML private TableColumn<Item, String> genderTableColumn;
    @FXML private TableColumn<Item, String> produceTypeTableColumn;
    @FXML private TableColumn<Item, String> sizeTableColumn;
    @FXML private TableColumn<Item, String> colourTableColumn;
    @FXML private TableColumn<Item, String> typeNameTableColumn;

    public Item item;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showProductTable() {
        productTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        produceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("produceType"));
        sizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        colourTableColumn.setCellValueFactory(new PropertyValueFactory<>("colour"));
        typeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));


        try {
            tableView.setItems(itemDBService.getByProductType(searchProductTypeComboBox.getValue().toString()));
            AppData.getInstance().setComboBoxValue(searchProductTypeComboBox.getValue().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "allSoldReport", 1000, 500);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
//
//    public void showTable(ActionEvent actionEvent) {
//        OrderPrTypeReportController OrderPrTypeReportController = new OrderPrTypeReportController();
//        try {
//            productTypeReportController.printDocument();
//        } catch (DocumentException | SQLException | IOException e) {
//            e.printStackTrace();
//        }
//    }

}
