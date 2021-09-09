package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import service.ItemDBService;

import java.io.IOException;

public class OrderController extends ViewController {

    public TextField CustomerNameField;
    public TextField PriceField;
    public TextField CountField;
    public TextField SizeField;
    public TextField ColorField;
    public TextField TypeNameField;
    public TextField CustomerEmailField;
    public TextField CustomerPhoneField;

    @FXML
    public ComboBox productTypeComboBox;
    public ComboBox genderComboBox;
    public ComboBox produceTypeComboBox;
    public ComboBox deliveryMethodComboBox;


 ItemDBService itemDBService = new ItemDBService();

    public void handleAddOrder(ActionEvent actionEvent) {
        try {
            Order order = new Order(
                    productTypeComboBox.getValue().toString(),
                    Double.parseDouble(PriceField.getText()),
                    Integer.parseInt(CountField.getText()),
                    genderComboBox.getValue().toString(),
                    produceTypeComboBox.getValue().toString(),
                    SizeField.getText(),
                    ColorField.getText(),
                    TypeNameField.getText(),
                    CustomerNameField.getText(),
                    CustomerEmailField.getText(),
                    CustomerPhoneField.getText(),
                    deliveryMethodComboBox.getValue().toString());

            itemDBService.addOrderedItemToDBService(order);
            showAlert("Success", "Adding successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "start",600,600);
        } catch (Exception e) {
            showAlert("Adding Ordered Items Failed", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }


    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start", 600, 600);
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();

    }


}





