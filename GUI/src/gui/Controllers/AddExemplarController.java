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

public class AddExemplarController implements Initializable {
    
    @FXML
    private ComboBox cbxName;
    @FXML
    private ComboBox cbxSituation;
    @FXML
    private TextField tfdDate;
    
    @FXML
    private void handleRegister(ActionEvent event) {
        String obra = (String) cbxName.getSelectionModel().getSelectedItem();
        String situacao = (String) cbxName.getSelectionModel().getSelectedItem();
        String data = tfdDate.getText();
        
        System.out.println(obra + " - "+ situacao +" - " +data);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //preenche o primeiro combobox
       ArrayList<String> listaObras = new ArrayList<>();
       listaObras.add("Livro A");
       listaObras.add("Livro B");
       listaObras.add("Livro C");
       ObservableList<String> optionsObras = FXCollections.observableArrayList(listaObras);
       cbxName.setItems(optionsObras);
       
       //preenche o segundo combobox
       ArrayList<String> listaSituacoes = new ArrayList<>();
       listaSituacoes.add("Situação A");
       listaSituacoes.add("Situação B");
       listaSituacoes.add("Situação C");
       ObservableList<String> optionsSituacoes = FXCollections.observableArrayList(listaSituacoes);
       cbxSituation.setItems(optionsSituacoes);
    }    
    
}
