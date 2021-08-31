package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void handleAddOrder(ActionEvent actionEvent) {


    }

    public void handleBack(ActionEvent actionEvent) {
        try{
            changeScene(actionEvent, "start");
        } catch (IOException ex) {
            showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();

    }




    }





