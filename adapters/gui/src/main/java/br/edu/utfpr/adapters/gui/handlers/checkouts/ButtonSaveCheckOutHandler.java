package br.edu.utfpr.adapters.gui.handlers.checkouts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.utfpr.adapters.gui.views.checkouts.SaveCheckOutView;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.in.checkout.SaveCheckOutUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ButtonSaveCheckOutHandler implements EventHandler<ActionEvent> {

	private final SaveCheckOutUseCase useCase;
	private final SaveCheckOutView view;

	public ButtonSaveCheckOutHandler(SaveCheckOutUseCase useCase, SaveCheckOutView view) {
		this.useCase = useCase;
		this.view = view;
		
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			ComboBox<User> cmbUser = view.getCmbUser();
			ComboBox<Copy> cmbCopy = view.getCmbCopy();
			
			TextField txtExpectedCheckInDate = view.getTxtExpectedCheckInDate();
			TextField txtCheckInDate = view.getTxtCheckInDate();
			
			Copy copy = cmbCopy.getSelectionModel().getSelectedItem();
			
			User user = cmbUser.getSelectionModel().getSelectedItem();
			
			LocalDate expectedCheckInDate = LocalDate.parse(txtExpectedCheckInDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			CheckOut checkout = new CheckOut(user, LocalDate.now());
			checkout.setExpectedCheckInDate(expectedCheckInDate);
			checkout.addCopy(copy);
			
			if(!txtCheckInDate.getText().isEmpty()) {
				LocalDate checkInDate = LocalDate.parse(txtCheckInDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				checkout.checkIn(checkInDate);
			}
			
			useCase.save(checkout);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Empréstimo salvo com sucesso");
			alert.showAndWait();
		}catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao realizar empr�stimo");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}

}
