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
import model.AppData;
import model.Item;
import service.ReportDBService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DayTableViewController extends ViewController implements Initializable {

    @FXML public Label sumTotalLabel;
    @FXML public Label Eurlabel;

    ReportDBService reportDBService = new ReportDBService();

    @FXML
    public TableView<Item> tableView;

    @FXML public TableColumn<Item, String> productTypeTableColumn;
    @FXML public TableColumn<Item, Double> priceTableColumn;
    @FXML public TableColumn<Item, Integer> countTableColumn;
    @FXML public TableColumn<Item, String>genderTableColumn;
    @FXML public TableColumn<Item, String> produceTypeTableColumn;
    @FXML public TableColumn<Item, String> sizeTableColumn;
    @FXML public TableColumn<Item, String> colourTableColumn;
    @FXML public TableColumn<Item, String> typeNameTableColumn;


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
            tableView.setItems(reportDBService.getSoldItemsByDate(AppData.getInstance().getSoldDate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showTable(ActionEvent actionEvent) {
        PrintOrderedReportController printOrderedReportController = new PrintOrderedReportController();
        try {
            printOrderedReportController.printDocument();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void showTotal(ActionEvent actionEvent) {
        int total = 0 ;
        for (Item item : tableView.getItems()) {
            total = (int) (total + (item.getCount()* item.getPrice()));
        }
        sumTotalLabel.setText(String.valueOf(total));
        Eurlabel.setText("Eur");
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600,600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
