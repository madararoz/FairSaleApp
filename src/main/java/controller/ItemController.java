package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ItemController extends ViewController {

    public TextField soldItemField;

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
    }

