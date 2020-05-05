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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gustavo Souza
 * 
 */

public class DevolucaoController implements Initializable {

    @FXML
    private ComboBox cbxUsuario;
    @FXML
    private ComboBox cbxExemplar;
    
    
    @FXML
    private void handleRegister(ActionEvent event) {
        String usuario = (String) cbxUsuario.getSelectionModel().getSelectedItem();
        String exemplar = (String) cbxExemplar.getSelectionModel().getSelectedItem();
        System.out.println(usuario + " - " + exemplar);
        
        JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       //preenche o primeiro combobox
       ArrayList<String> listaUsuario = new ArrayList<>();
       listaUsuario.add("User A");
       listaUsuario.add("User B");
       listaUsuario.add("User C");
       ObservableList<String> optionsUser = FXCollections.observableArrayList(listaUsuario);
       cbxUsuario.setItems(optionsUser);
        
       //preenche o Segundo combobox
       ArrayList<String> listaExemplar = new ArrayList<>();
       listaExemplar.add("Exemplar A");
       listaExemplar.add("Exemplar B");
       listaExemplar.add("Exemplar C");
       ObservableList<String> optionsExemplar = FXCollections.observableArrayList(listaExemplar);
       cbxExemplar.setItems(optionsExemplar);
       
      
    }    
    
}
