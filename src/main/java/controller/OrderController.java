package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Gender;
import model.Item;
import model.ProduceType;
import model.ProductType;
import service.OrderedItemDBService;

import java.io.IOException;

public class OrderController extends ViewController {

    public TextField CustomerNameField;
    public TextField DeliveryMethodField;
    public TextField ProductTypeField;
    public TextField PriceField;
    public TextField CountField;
    public TextField GenderField;
    public TextField ProduceTypeField;
    public TextField SizeField;
    public TextField ColorField;
    public TextField TypeNameField;
    public TextField CustomerEmailField;
    public TextField CustomerPhoneField;

    @FXML
    public ComboBox productTypeComboBox;
    public ComboBox genderComboBox;
    public ComboBox produceTypeComboBox;


    OrderedItemDBService orderedItemDBService = new OrderedItemDBService();

    public void handleAddOrder(ActionEvent actionEvent) {
        try {
            Item item = new Item(
                    ProductType.valueOf(productTypeComboBox.getValue().toString().toUpperCase()),
                    Double.parseDouble(PriceField.getText()),
                    Integer.parseInt(CountField.getText()),
                    Gender.valueOf(genderComboBox.getValue().toString().toUpperCase()),
                    ProduceType.valueOf(produceTypeComboBox.getValue().toString().toUpperCase()),
                    SizeField.getText(),
                    ColorField.getText(),
                    TypeNameField.getText(),
                    CustomerNameField.getText(),
                    CustomerEmailField.getText(),
                    Integer.parseInt(CustomerPhoneField.getText()),
                    DeliveryMethodField.getText());

            orderedItemDBService.addOrderedItemToDBService(item);
            showAlert("Success", "Adding successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "start");
        } catch (Exception e) {
            showAlert("Adding Ordered Items Failed", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }


    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start");
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();

    }


}





