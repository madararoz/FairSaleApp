package controller;

import com.itextpdf.text.DocumentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Gender;
import model.Item;
import model.ProduceType;
import model.ProductType;
import service.ReportDBService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController extends ViewController implements Initializable{


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
    @FXML public TableColumn<Item, Double> totalPriceTableColumn;
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
        totalPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        //  dateTableColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("date"));


        //    tableView.setItems(getSoldItems());

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


//    public ObservableList<Item> getSoldItems() {
//        ObservableList<Item> items = FXCollections.observableArrayList();
////        items.add(new Item(ProductType.JACKETS,15,1,Gender.FEMALE,ProduceType.HANDMADE,"38","blue", "non"));
////        items.add(new Item(ProductType.GLOVES,15,1,Gender.FEMALE,ProduceType.HANDMADE,"38","blue", "non"));
//        for(Item item: items ) {
//            items.add(new Item(item.getProductType(), item.getPrice(), item.getCount(), item.getGender(), item.getProduceType(),
//                    item.getSize(), item.getColour(), item.getTypeName()));
//        }
//        return items;
//    }


}

