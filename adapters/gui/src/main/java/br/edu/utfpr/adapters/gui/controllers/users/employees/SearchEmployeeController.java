package br.edu.utfpr.adapters.gui.controllers.users.employees;

import br.edu.utfpr.adapters.gui.handlers.users.employees.ButtonSearchEmployeeHandler;
import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.scene.control.Button;
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
	   button.setOnAction(new ButtonSearchEmployeeHandler(useCase, view));
		
	}
    
    


}
