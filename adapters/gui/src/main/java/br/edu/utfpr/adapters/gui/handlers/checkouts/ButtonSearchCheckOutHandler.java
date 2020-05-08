package br.edu.utfpr.adapters.gui.handlers.checkouts;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.checkouts.SearchCheckOutView;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.ports.in.checkout.SearchCheckOutUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ButtonSearchCheckOutHandler implements EventHandler<ActionEvent> {

	private SearchCheckOutUseCase useCase;
	private SearchCheckOutView view;

	public ButtonSearchCheckOutHandler(SearchCheckOutUseCase useCase, SearchCheckOutView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		try {

			TextField txtID = view.getTxtID();
			String id = txtID.getText();
	

			if (!StringUtils.isEmpty(id)) {
				Optional<CheckOut> optional = useCase.findById(NumberUtils.toLong(id));
				if (optional.isPresent()) {
					CheckOut checkout = optional.get();
					TableView<CheckOut> tableView = view.getTableView();
					ObservableList<CheckOut> observableList = FXCollections.observableArrayList(Arrays.asList(checkout));
					tableView.setItems(observableList);
				}
			} else {
				List<CheckOut> checkouts = useCase.findAll();
				TableView<CheckOut> tableView = view.getTableView();
				ObservableList<CheckOut> observableList = FXCollections.observableArrayList(checkouts);
				tableView.setItems(observableList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao consultar empréstimos");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}

}
