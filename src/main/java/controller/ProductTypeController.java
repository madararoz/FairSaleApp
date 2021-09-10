package controller;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;
import service.ItemDBService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductTypeController extends ViewController implements Initializable {

    public TableView<Item> tableView;
    public ComboBox searchProductTypeComboBox;
    ItemDBService itemDBService = new ItemDBService();
    TableViewController tableViewController = new TableViewController();


        public Label sumTotalLabel;
        public Label Eurlabel;


        @FXML private TableColumn<Item, String> productTypeTableColumn;
        @FXML private TableColumn<Item, Double> priceTableColumn;
        @FXML private TableColumn<Item, Integer> countTableColumn;
        @FXML private TableColumn<Item, String> genderTableColumn;
        @FXML private TableColumn<Item, String> produceTypeTableColumn;
        @FXML private TableColumn<Item, String> sizeTableColumn;
        @FXML private TableColumn<Item, String> colourTableColumn;
        @FXML private TableColumn<Item, String> typeNameTableColumn;

        public Item item;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

   }

   public void showProductTable(){
       productTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
       priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
       countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
       genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
       produceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("produceType"));
       sizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
       colourTableColumn.setCellValueFactory(new PropertyValueFactory<>("colour"));
       typeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));


       try {
           tableView.setItems(itemDBService.getByProductType(searchProductTypeComboBox.getValue().toString()));
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   public String getSearchProductTypeComboBox(){
       return searchProductTypeComboBox.getValue().toString();

   }

        public void handleBack(ActionEvent actionEvent) {
            try {
                changeScene(actionEvent, "start", 600,600);
            } catch (IOException ex) {
                showAlert("Back failed", ex.getMessage(), Alert.AlertType.ERROR);
            }
        }

        public void showTable(ActionEvent actionEvent) {
            ProductTypeReportController productTypeReportController = new ProductTypeReportController();
            try {
                productTypeReportController.printDocument();
            } catch (DocumentException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }

    public void handleSearchByProductType(ActionEvent actionEvent) {

    }

//        public void showTotal(){
//            double total = 0 ;
//            try {
//                for (Item item : itemDBService.getByProductType(searchProductTypeComboBox.getValue().toString())) {
//                    total = total + (item.getCount()* item.getPrice());
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            sumTotalLabel.setText(String.valueOf(total));
//            Eurlabel.setText("Eur");
//        }






}
