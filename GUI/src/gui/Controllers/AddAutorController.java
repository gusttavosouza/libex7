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

public class AddAutorController implements Initializable {
    
    @FXML
    private TextField tfdNameAuthor;
    
    
    @FXML
    private void handleAddAuthor(ActionEvent event) {
        System.out.println("Autor: " + tfdNameAuthor.getText());
        System.out.println("CADASTRO DO AUTOR FEITO COM SUCESSO!");
        
        tfdNameAuthor.setText("");
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
