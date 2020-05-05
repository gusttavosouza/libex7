package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gustavo Souza
 * 
 */

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Views/Login.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Libex7");   
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
