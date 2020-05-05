package gui.Controllers;

import Utils.StageMake;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Gustavo Souza
 * 
 */

public class HomeController implements Initializable {
    
    @FXML
    private Button btnAddUser;

    @FXML
    private void handleAddAuthor(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("CadastroAutor.fxml", "Add Autor", btnAddUser);
    }
    
    @FXML
    private void handleAddObra(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("CadastroObra.fxml", "Add Obra", btnAddUser);
    }
    
    @FXML
    private void handleAddType(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("CadastroTipoObra.fxml", "Tipo", btnAddUser);
    }
    
    @FXML
    private void handleAddExemplar(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("CadastroExemplar.fxml", "Add Exemplar", btnAddUser);
    }
    
    @FXML
    private void handleAddUser(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("CadastroUsuario.fxml", "Add Usuário", btnAddUser);
    }
    
    @FXML
    private void handleAddEmprestimo(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("Emprestimo.fxml", "Emprestimos", btnAddUser);
    }
    
    @FXML
    private void handleAddDevolucao(ActionEvent event) throws IOException {
        StageMake stage = new StageMake();
        stage.NewStage("Devolucao.fxml", "Devolução", btnAddUser);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
