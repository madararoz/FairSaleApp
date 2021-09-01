package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Gender;
import model.Item;
import model.ProduceType;
import model.ProductType;
import service.SoldItemDBService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController extends ViewController {


    public TextField productTypeField;
    public TextField priceField;
    public TextField countField;
    public TextField genderField;
    public TextField produceTypeField;
    public TextField sizeField;
    public TextField colourField;
    public TextField typeNameField;

    @FXML
   public ComboBox productTypeComboBox;
    public ComboBox genderComboBox;
    public ComboBox ProduceTypeComboBox;


    SoldItemDBService soldItemDBService = new SoldItemDBService();


    public void handleSoldItems(ActionEvent actionEvent) {
        try {

            Item item = new Item(
             //       ProductType.valueOf(productTypeComboBox.getItems().toString().toUpperCase());
                    ProductType.valueOf(productTypeField.getText().toUpperCase()),
                    Double.parseDouble(priceField.getText()),
                    Integer.parseInt(countField.getText()),
                    Gender.valueOf(genderField.getText().toUpperCase()),
                 //   Gender.valueOf(genderComboBox.getAccessibleText()),
                    ProduceType.valueOf(produceTypeField.getText().toUpperCase()),
             //       ProduceType.valueOf(productTypeComboBox.getItems().toString().toUpperCase()),
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

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        ObservableList<ProductType> options =
//        FXCollections.observableArrayList(ProductType.GLOVES);
//        final ComboBox comboBox = new ComboBox(options);
//    }

//    public void handleAdd(ActionEvent actionEvent) {
//       try {
//            changeScene(actionEvent, "start");
//       } catch (IOException e) {
//           showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
//       }
// }
}

