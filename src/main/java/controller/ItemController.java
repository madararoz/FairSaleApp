package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Item;
import service.ItemDBService;

import java.io.IOException;

public class ItemController extends ViewController {


    public TextField productTypeField;
    public TextField priceField;
    public TextField countField;
    public TextField genderField;
    public TextField produceTypeField;
    public TextField sizeField;
    public TextField colourField;
    public TextField typeNameField;

    @FXML
   public ComboBox productTypeComboBox;
    public ComboBox genderComboBox;
    public ComboBox produceTypeComboBox;


    ItemDBService soldItemDBService = new ItemDBService();


    public void handleSoldItems(ActionEvent actionEvent) {
        try {

            Item item = new Item(
                    productTypeComboBox.getValue().toString(),
                    Double.parseDouble(priceField.getText()),
                    Integer.parseInt(countField.getText()),
                    genderComboBox.getValue().toString(),
                    produceTypeComboBox.getValue().toString(),
                    sizeField.getText(),
                    colourField.getText(),
                    typeNameField.getText());

            soldItemDBService.addSoldItemToDB(item);

            showAlert("Success", "Adding successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "start", 600,700);
        } catch (Exception e) {
            showAlert("Adding Sold Items Failed", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600,700);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }


}

