package controller;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;
import service.ReportDBService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableViewController extends ViewController implements Initializable{



    public Label sumTotalLabel;
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

    public void showTotal(){
        int total = 0 ;
        for (Item item : tableView.getItems()) {
            total = (int) (total + (item.getCount()* item.getPrice()));
        }
        sumTotalLabel.setText(String.valueOf(total));
    }



}

