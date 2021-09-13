package controller;

import com.itextpdf.text.DocumentException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;
import model.Order;
import service.ItemDBService;
import service.ReportDBService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderedTableViewController extends ViewController implements Initializable {

    public Label sumTotalLabel;
    public TextField newValue;
    public ComboBox editDataType;
    public TextField idFieldUpdate;
    public TextField idField;
    public Label Eurlabel;

    ItemDBService itemDBService = new ItemDBService();
    ReportDBService reportDBService = new ReportDBService();

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
            tableView.setItems(reportDBService.getOrderedItems());
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
        } catch (SQLException | IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public void showTotal(){
        double total = 0 ;
        for (Item item : tableView.getItems()) {
            total = total + (item.getCount()* item.getPrice());
        }
        sumTotalLabel.setText(String.valueOf(total));
        Eurlabel.setText("Eur");
    }

    public void handleSearchByProductType(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "orderPrTypeReport", 1100, 600);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void deleteOrder(ActionEvent actionEvent) {
        try {
            itemDBService.deleteOrder(Integer.parseInt(idField.getText()));
            showAlert("Success", "Removing successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "allOrderReport", 1100,600);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void updateOrder(ActionEvent actionEvent) throws SQLException, IOException {
        String userChoice = editDataType.getValue().toString();
        switch(userChoice){
            case"Product type":
                itemDBService.updateOrderProductType(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Price":
                itemDBService.updateOrderPrice(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Count":
                itemDBService.updateOrderCount(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Gender":
                itemDBService.updateOrderGender(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Produce type":
                itemDBService.updateOrderProduceType(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Size":
                itemDBService.updateOrderSize(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Customer name":
                itemDBService.updateOrderCustomerName(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Customer email":
                itemDBService.updateOrderCustomerEmail(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Customer phone":
                itemDBService.updateOrderCustomerPhone(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Delivery method":
                itemDBService.updateOrderDeliveryMethod(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;

            default:
                showAlert("Back failed", "Updating failed", Alert.AlertType.ERROR);
        }
        showAlert("Success", "Updating successful", Alert.AlertType.CONFIRMATION);
        changeScene(actionEvent, "allOrderReport", 1100, 600);
    }
}

