package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Item;
import service.SoldItemDBService;

import java.io.IOException;

public class ItemController extends ViewController {

    public TextField soldItemField;
    public TextField productTypeField;
    public TextField priceField;
    public TextField countField;
    public TextField genderField;
    public TextField produceTypeField;
    public TextField sizeField;
    public TextField colourField;
    public TextField typeNameField;
    //public TextField sellerField;

    SoldItemDBService soldItemDBService = new SoldItemDBService();


    public void handleSoldItems(ActionEvent actionEvent) {
        try {
            //Sarkans jo nav tāds Constructor, kas varētu uztaisīt jaunu Item. Šim jāsakrīt ar SoldItemsDBService metodes Itemu
            Item item = new Item(
                    productTypeField.getText(),
                    Integer.parseInt(priceField.getText()),
                    Integer.parseInt(countField.getText()),
                    genderField.getText(),
                    produceTypeField.getText(),
                    Integer.parseInt(sizeField.getText()),
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

