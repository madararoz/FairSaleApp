package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class StartController extends ViewController {
    
    public void registerSoldItem(ActionEvent actionEvent) {
            try {
                changeScene(actionEvent, "soldItems");
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }
    }

    public void registerOrderedItem(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "order");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewSoldItemDayReport(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "daySoldReport");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewOrderItemDayReport(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "dayOrderReport");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start");
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
