package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class StartController extends ViewController {
    
    public void registerSoldItem(ActionEvent actionEvent) {
            try {
                changeScene(actionEvent, "soldItems", 800, 700);
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }
    }

    public void registerOrderedItem(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "order", 800, 500);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewSoldItemDayReport(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "daySoldReport", 1000, 500);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewOrderItemDayReport(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "dayOrderReport", 1000, 600);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
