
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

    public class ViewController {

        public void changeScene(ActionEvent event, String sceneName, int width, int height) throws IOException {
            String scenePath = "../view/" + sceneName + ".fxml";
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scenePath)));
            stage.setScene(new Scene(root, width, height));
            stage.getIcons().add(new Image("./img/icon.png"));
            stage.show();


        }

        public void showAlert(String title, String message, Alert.AlertType alertType){
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setContentText(message);
            alert.setHeaderText(null);
            alert.show();
        }
}
