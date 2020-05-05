
package Utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Gustavo Souza
 * 
 */

public class StageMake {
    public void NewStage(String path, String title, Node selectStageModal) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Views/"+path));       
        Scene scene = new Scene(root);      
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title); 
        stage.initOwner(selectStageModal.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);  
        stage.show();
    }
}
