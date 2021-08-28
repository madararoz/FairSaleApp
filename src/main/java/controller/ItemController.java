package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ItemController extends ViewController {

    public TextField soldItemField;
    public TextField productTypeField;
    public TextField priceField;
    public TextField countField;
    public TextField genderField;
    public TextField produceField;
    public TextField sizeField;
    public TextField colourField;
    public TextField typeNameField;
    public TextField sellerField;

    public void handleExit(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "exit");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "back");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleAdd(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "add");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}

