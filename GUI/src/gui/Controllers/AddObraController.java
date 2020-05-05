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

public class AddObraController implements Initializable {
    
    @FXML
    private TextField tfdName;
    @FXML
    private TextField tfdYear;
    @FXML
    private ComboBox cbxType;
    
    @FXML
    private void handleRegister(ActionEvent event) {
        String tipo = (String) cbxType.getSelectionModel().getSelectedItem();
        String nome = tfdName.getText();
        String ano = tfdYear.getText();
        
        System.out.println(nome + " - "+ tipo +" - " +ano);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //preenche o primeiro combobox
       ArrayList<String> listaTipoObra = new ArrayList<>();
       listaTipoObra.add("Tipo A");
       listaTipoObra.add("Tipo B");
       listaTipoObra.add("Tipo C");
       ObservableList<String> optionsObras = FXCollections.observableArrayList(listaTipoObra);
       cbxType.setItems(optionsObras);
    }    
    
}
