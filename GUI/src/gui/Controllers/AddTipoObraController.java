package gui.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


/**
 *
 * @author Gustavo Souza
 * 
 */

public class AddTipoObraController implements Initializable {
    
    @FXML
    private TextField tfdType;

    @FXML
    private void handleRegister(ActionEvent event) {
        String type = tfdType.getText();
        System.out.println(type);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // vazio
    }    
    
}
