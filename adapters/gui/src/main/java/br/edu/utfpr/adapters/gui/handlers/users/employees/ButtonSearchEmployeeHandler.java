package br.edu.utfpr.adapters.gui.handlers.users.employees;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public final class ButtonSearchEmployeeHandler implements EventHandler<ActionEvent> {
	
	private final SearchUserUseCase useCase;
    private final SearchEmployeeView view;
    
   
    
	public ButtonSearchEmployeeHandler(SearchUserUseCase useCase, SearchEmployeeView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handle(ActionEvent event) {
		try {
			 TextField txtName = view.getTxtName();
			 String name = txtName.getText();
			 
			 if(name != null && !name.isEmpty()) {
				 List<Employee> employees = (List<Employee>)(List<?>) useCase.findByName(name);
				 TableView<Employee> tableView = view.getTableView();
				 ObservableList<Employee> observableList = (ObservableList<Employee>) FXCollections.observableArrayList(employees);
				 tableView.setItems(observableList);
			 }else {
				 List<Employee> employees = (List<Employee>)(List<?>)useCase.findAll();
				 TableView<Employee> tableView = view.getTableView();
				 ObservableList<Employee> observableList = (ObservableList<Employee>) FXCollections.observableArrayList(employees);
				 tableView.setItems(observableList);
			 }
		}catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao consultar servidor");
			alert.setContentText(e.getMessage());
			alert.show();
		}
		
	}
}

