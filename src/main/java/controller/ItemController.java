package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Item;
import model.ProduceType;
import model.ProductType;

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
    public TextField sellerField;
    public ListView<ProductType> ProductTypeListView;


    private ObservableList<ProductType> productTypeObservableList;

    public void initialize() {
        ObservableList<ProductType> productTypeObservableList = FXCollections.observableArrayList();
        for (ProductType productType : productTypeObservableList) {
            productTypeObservableList.addAll(productType);
        }

        ProductTypeListView.setItems(productTypeObservableList);
    }


//    public void handleSoldItems (ActionEvent actionEvent){
//            try {
//                //Sarkans jo nav tāds Constructor, kas varētu uztaisīt jaunu Item. Šim jāsakrīt ar SoldItemsDBService metodes Itemu
//                Item item = new Item(
//                        productTypeField.getText(),
//                        priceField.getText(),
//                        countField.getText(),
//                        genderField.getText(),
//                        produceTypeField.getText(),
//                        sizeField.getText(),
//                        colourField.getText(),
//                        typeNameField.getText(),
//                        sellerField.getText());
//
//                showAlert("Success", "Adding successful", Alert.AlertType.CONFIRMATION);
//                changeScene(actionEvent, "");
//            } catch (Exception e) {
//                showAlert("Register Failed", e.getMessage(), Alert.AlertType.ERROR);
//                e.printStackTrace();
//            }
//        }


        public void handleExit (ActionEvent actionEvent){
            try {
                changeScene(actionEvent, "exit");
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }
        }

        public void handleBack (ActionEvent actionEvent){
            try {
                changeScene(actionEvent, "back");
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }
        }

    public void handleAdd (ActionEvent actionEvent){
           try {
                changeScene(actionEvent, "add");
            } catch (IOException e) {
                showAlert("Problem loading scene", e.getMessage(), Alert.AlertType.ERROR);
            }
        }

    public void handleProductTypeClick(MouseEvent mouseEvent) {
        //method to show list

    }
}
