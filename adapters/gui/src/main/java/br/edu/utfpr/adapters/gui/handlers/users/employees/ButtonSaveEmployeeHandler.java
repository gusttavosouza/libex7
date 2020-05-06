package br.edu.utfpr.adapters.gui.handlers.users.employees;

import java.time.LocalDate;

import br.edu.utfpr.adapters.gui.views.users.employees.SaveEmployeeView;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public final class ButtonSaveEmployeeHandler implements EventHandler<ActionEvent> {
	private final SaveEmployeeView view;
	private final SaveUserUseCase useCase;

	public ButtonSaveEmployeeHandler(SaveEmployeeView view, SaveUserUseCase useCase) {
		this.view = view;
		this.useCase = useCase;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			TextField txtName = view.getTxtName();
			TextField txtDob = view.getTxtDob();
			TextField txtEmployeeNumber = view.getTxtEmployeeNumber();
			String name = txtName.getText().toUpperCase().trim();
			LocalDate dob = LocalDate.parse(txtDob.getText());
			Long studentNumber = Long.parseLong(txtEmployeeNumber.getText());
			Employee user = new Employee();
			user.setName(name);
			user.setDob(dob);
			user.setEmployeeNumber(studentNumber);
			useCase.save(user);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Servidor cadastrado com sucesso");
			alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar servidor");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
}