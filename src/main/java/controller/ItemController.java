package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Gender;
import model.Item;
import model.ProduceType;
import model.ProductType;
import service.SoldItemDBService;

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


    SoldItemDBService soldItemDBService = new SoldItemDBService();


    public void handleSoldItems(ActionEvent actionEvent) {
        try {

            Item item = new Item(
                    ProductType.valueOf(productTypeField.getText().toUpperCase()),
                    Double.parseDouble(priceField.getText()),
                    Integer.parseInt(countField.getText()),
                    Gender.valueOf(genderField.getText().toUpperCase()),
                    ProduceType.valueOf(produceTypeField.getText().toUpperCase()),
                    sizeField.getText(),
                    colourField.getText(),
                    typeNameField.getText());

            soldItemDBService.addSoldItemToDB(item);

            showAlert("Success", "Adding successful", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "start");
        } catch (Exception e) {
            showAlert("Adding Sold Items Failed", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
        /*
        try {
            changeScene(actionEvent, "exit");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }

         */
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "start");
        } catch (IOException e) {
            showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleProductTypeClick(MouseEvent mouseEvent) {
    }

//    public void handleAdd(ActionEvent actionEvent) {
//       try {
//            changeScene(actionEvent, "start");
//       } catch (IOException e) {
//           showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
//       }
// }
}

