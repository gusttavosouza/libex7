package gui.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


/**
 *
 * @author Gustavo Souza
 * 
 */

public class AddUsuarioController implements Initializable {
    
    @FXML
    private TextField tfdName;
    @FXML
    private TextField tfdDate;
    @FXML
    private ComboBox cbxType;
    
    @FXML
    private void handleRegister(ActionEvent event) {
      String nomeUsuario = tfdName.getText();
      String dataNascimento = tfdDate.getText();
      String tipo = (String) cbxType.getSelectionModel().getSelectedItem();
      
      System.out.println(nomeUsuario + " - " + dataNascimento + " - " + tipo);
      tfdName.setText("");
      tfdDate.setText("");
      JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //preenche o primeiro combobox
       ArrayList<String> listaTipoUsuario = new ArrayList<>();
       listaTipoUsuario.add("Aluno");
       listaTipoUsuario.add("Bibliotecário");
       ObservableList<String> optionUsers = FXCollections.observableArrayList(listaTipoUsuario);
       cbxType.setItems(optionUsers);
    }    
    
}
