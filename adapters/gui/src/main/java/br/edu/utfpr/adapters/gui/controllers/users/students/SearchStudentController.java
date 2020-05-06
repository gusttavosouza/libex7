package br.edu.utfpr.adapters.gui.controllers.users.students;

import br.edu.utfpr.adapters.gui.handlers.users.students.ButtonSearchStudentHandler;
import br.edu.utfpr.adapters.gui.views.users.students.SearchStudentView;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SearchStudentController {


	private final SearchUserUseCase useCase;
    private final SearchStudentView view;
    
    
	public SearchStudentController(SearchUserUseCase useCase, SearchStudentView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new ButtonSearchStudentHandler(useCase, view));
		
	}
    
    


}
