package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.AppData;
import service.ReportDBService;

import java.io.IOException;
import java.util.Date;

public class StartController extends ViewController {

    @FXML
    public DatePicker orderDate;
    public Label notificationLabel;
    public DatePicker soldDate;

    public void registerSoldItem(ActionEvent actionEvent) {
            try {
                changeScene(actionEvent, "soldItems", 800, 700);
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }
    }

    public void registerOrderedItem(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "order", 800, 700);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewSoldItemAllReport(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "allSoldReport", 1000, 500);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewOrderItemAllReport(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "allOrderReport", 1000, 500);
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void viewSoldItemDayReport(ActionEvent actionEvent) {
        if (soldDate.getValue() == null) {
            showAlert("Problem loading report", "Please enter the date", Alert.AlertType.ERROR);
        } else {
            AppData.getInstance().setSoldDate(soldDate.getValue().toString());
            try {
                changeScene(actionEvent, "daySoldReport", 1000, 500);
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }

        }
    }

    public void viewOrderItemDayReport(ActionEvent actionEvent) {
        if (orderDate.getValue() == null) {
            showAlert("Problem loading report", "Please enter the date", Alert.AlertType.ERROR);
        } else {
            AppData.getInstance().setOrderDate(orderDate.getValue().toString());
            try {
                changeScene(actionEvent, "dayOrderReport", 1000, 500);
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }

        }
    }


    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();

    }
}
