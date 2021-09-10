package controller;

import com.itextpdf.text.DocumentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;
import service.ItemDBService;
import service.ReportDBService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableViewController extends ViewController implements Initializable{

    public TableView productTypeTableView;
    public TextField productTypeSearchField;
    ItemDBService itemDBService = new ItemDBService();

    ObservableList<Item> productTypeSearch = FXCollections.observableArrayList();

    public Label sumTotalLabel;
    public Label Eurlabel;
    public ComboBox<Item> searchProductTypeComboBox;
    ReportDBService reportDBService = new ReportDBService();
    @FXML public TableView<Item> tableView;

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
        productTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        produceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("produceType"));
        sizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        colourTableColumn.setCellValueFactory(new PropertyValueFactory<>("colour"));
        typeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));


        try {
            tableView.setItems(reportDBService.getSoldItems());
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
        PrintReportController printReportController = new PrintReportController();
        try {
            printReportController.printDocument();
        } catch (DocumentException | SQLException | IOException e) {
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
            changeScene(actionEvent, "productTypeReport", 1000, 600);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }


//    @SneakyThrows
//    public void showProductType(ActionEvent actionEvent) {
//            changeScene(actionEvent, "productTypeReport", 1000, 500);
//            itemDBService.getByProductType(searchProductTypeComboBox.getValue().toString(), item);
//
//    }





}

