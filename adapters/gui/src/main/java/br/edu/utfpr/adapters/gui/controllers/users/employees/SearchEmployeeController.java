package br.edu.utfpr.adapters.gui.controllers.users.employees;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SearchEmployeeController {

	private final SearchUserUseCase useCase;
    private final SearchEmployeeView view;
    
    
	public SearchEmployeeController(SearchUserUseCase useCase, SearchEmployeeView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			 TextField txtName = view.getTxtName();
			 String name = txtName.getText();
			 
			 if(name != null && !name.isEmpty()) {
				 List<Employee> authors = null;
				 ListView<Employee> listView = view.getListView();
				 ObservableList<Employee> observableList = (ObservableList<Employee>) FXCollections.observableArrayList(authors);
				 listView.setItems(observableList);
			 }
			
		}
	});
		
	}
    
    


}
