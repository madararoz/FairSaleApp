package controller;

import com.itextpdf.text.DocumentException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    public Label sumTotalLabel;
    public Label Eurlabel;
    ItemDBService itemDBService = new ItemDBService();


    @FXML public TableView<Order> tableView;
    @FXML private TableColumn<Order, Integer> idTableColumn;
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
            changeScene(actionEvent, "allOrderReport", 1000, 500);
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

    public void showTotal(ActionEvent actionEvent) {
        double total = 0 ;
        for (Order order : tableView.getItems()) {
            total = total + (order.getCount()* order.getPrice());

        }
        sumTotalLabel.setText(String.valueOf(total));
        Eurlabel.setText("Eur");
    }
}
