import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sun.awt.im.InputMethodManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./view/start.fxml"));
        primaryStage.getIcons().add(new Image("./img/icon.png"));
        primaryStage.setTitle("SIA Tīnes");
        primaryStage.setScene(new Scene(root, 600, 700));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
