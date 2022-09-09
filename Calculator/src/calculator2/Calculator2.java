package calculator2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/*
 * @author kamilia
 */
public class Calculator2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(520);
        stage.setMinHeight(710);
        stage.setResizable(true);
        Image icon = new Image("icons.png");
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
