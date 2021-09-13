package controller;

import com.itextpdf.text.DocumentException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AppData;
import model.Item;
import service.ItemDBService;
import service.ReportDBService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableViewController extends ViewController implements Initializable{

    public TextField idField;
    public ComboBox editDataType;
    public TextField idFieldUpdate;
    public TextField newValue;
    public ComboBox searchProductTypeComboBox;

    ItemDBService itemDBService = new ItemDBService();

   public Label sumTotalLabel;
    public Label Eurlabel;
    ReportDBService reportDBService = new ReportDBService();
    @FXML public TableView<Item> tableView;

    @FXML private TableColumn<Item, Integer> idTableColumn;
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
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
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
            changeScene(actionEvent, "start", 600,700);
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
            AppData.getInstance().setProductTypeComboBox(searchProductTypeComboBox.getValue().toString());
            changeScene(actionEvent, "productTypeReport", 1000, 500);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }



    public void deleteItem(ActionEvent actionEvent) {
        try {
            itemDBService.deleteItem(Integer.parseInt(idField.getText()));
            showAlert("Success", "Removing successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "allSoldReport", 1000,500);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void updateItem(ActionEvent actionEvent) throws SQLException, IOException {
        String userChoice = editDataType.getValue().toString();
        switch(userChoice){
            case"Product type":
                itemDBService.updateProductType(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Price":
                itemDBService.updatePrice(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Count":
                itemDBService.updateCount(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Gender":
                itemDBService.updateGender(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Produce type":
                itemDBService.updateProduceType(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Size":
                itemDBService.updateSize(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Colour":
                itemDBService.updateColour(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            case "Type name":
                itemDBService.updateTypeName(newValue.getText(), Integer.parseInt(idFieldUpdate.getText()));
                break;
            default:
                showAlert("Back failed", "Updating failed", Alert.AlertType.ERROR);
        }
            showAlert("Success", "Updating successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "allSoldReport", 1000, 500);
    }


}

