package gui.Controllers;

import Utils.StageMake;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Gustavo Souza
 * 
 */

public class LoginController implements Initializable {
    
    @FXML
    private TextField tfdUser;
    @FXML
    private PasswordField pfdPassword;
    
    @FXML
    private void handleLogin(ActionEvent event) {
        System.out.println("Usuário: " +tfdUser.getText()+"; Senha: "+pfdPassword.getText());
        System.out.println("Login Feito Com sucesso!");
        
        StageMake stageMake = new StageMake();
        try {
            Stage stage = (Stage) tfdUser.getScene().getWindow();
            stage.close();
            stageMake.NewStage("Home.fxml", "Home - Libex7", tfdUser);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
