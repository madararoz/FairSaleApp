package controller;

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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TableViewController extends ViewController implements Initializable{

    ReportDBService reportDBService = new ReportDBService();
    @FXML
    public TableView<Item> tableView;

    @FXML private TableColumn<Item, ProductType> productTypeTableColumn;
    @FXML private TableColumn<Item, Double> priceTableColumn;
    @FXML private TableColumn<Item, Integer> countTableColumn;
    @FXML private TableColumn<Item, Gender> genderTableColumn;
    @FXML private TableColumn<Item, ProduceType> produceTypeTableColumn;
    @FXML private TableColumn<Item, String> sizeTableColumn;
    @FXML private TableColumn<Item, String> colourTableColumn;
    @FXML private TableColumn<Item, String> typeNameTableColumn;
    @FXML private TableColumn<Item, LocalDate> dateTableColumn;
    public Item item;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
// setup columns in the table
        productTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        produceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("produceType"));
        sizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        colourTableColumn.setCellValueFactory(new PropertyValueFactory<>("colour"));
        typeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));
      //  dateTableColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("date"));

//load data
           tableView.setItems(getSoldItems()); //šajā klasē zemāk metode
//        try {
//            tableView.setItems(reportDBService.getSoldItems());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start");
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }


//just to try if method works add new item, but it doesn't
    public ObservableList<Item> getSoldItems() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item(ProductType.JACKETS,15,1,Gender.FEMALE,ProduceType.HANDMADE,"38","blue", "non"));
        items.add(new Item(ProductType.GLOVES,15,1,Gender.FEMALE,ProduceType.HANDMADE,"38","blue", "non"));
//        for(Item item: items ) {
//            items.add(new Item(item.getProductType(), item.getPrice(), item.getCount(), item.getGender(), item.getProduceType(),
//                    item.getSize(), item.getColour(), item.getTypeName()));
//        }
        return items;
    }


}

