package controller;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AppData;
import model.Item;
import model.Order;
import service.ReportDBService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DayOrderedTableViewController extends ViewController implements Initializable {


    @FXML public Label sumTotalLabel;
    @FXML public Label Eurlabel;


    ReportDBService reportDBService = new ReportDBService();

    @FXML
    public TableView<Order> tableView;

    @FXML public TableColumn<Order, String> productTypeTableColumn;
    @FXML public TableColumn<Order, Double> priceTableColumn;
    @FXML public TableColumn<Order, Integer> countTableColumn;
    @FXML public TableColumn<Order, String> genderTableColumn;
    @FXML public TableColumn<Order, String> produceTypeTableColumn;
    @FXML public TableColumn<Order, String> sizeTableColumn;
    @FXML public TableColumn<Order, String> colourTableColumn;
    @FXML public TableColumn<Order, String> typeNameTableColumn;
    @FXML public TableColumn<Order, String> customerNameTableColumn;
    @FXML public TableColumn<Order, String> customerEmailTableColumn;
    @FXML public TableColumn<Order, String> customerPhoneTableColumn;
    @FXML public TableColumn<Order, String> deliveryMethodTableColumn;


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
        customerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
        customerPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        deliveryMethodTableColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryMethod"));


        try {
            tableView.setItems(reportDBService.getOrderedItemsByDate(AppData.getInstance().getOrderDate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600,700);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void showTable(ActionEvent actionEvent) {
        PrintDayOrderedReportController printDayOrderedReportController = new PrintDayOrderedReportController();
        try {
            printDayOrderedReportController.printDocument();
        } catch (SQLException | IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public void showTotal(){
        int total = 0 ;
        for (Order order : tableView.getItems()) {
            total = (int) (total + (order.getCount()* order.getPrice()));
        }
        sumTotalLabel.setText(String.valueOf(total));
        Eurlabel.setText("Eur");
    }
}
