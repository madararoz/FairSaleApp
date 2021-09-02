package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import javax.swing.text.View;
import java.io.IOException;

public class ReportController extends ViewController {
    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start");
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
