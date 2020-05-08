package br.edu.utfpr.adapters.gui.handlers.copies;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ButtonSearchCopyHandler implements EventHandler<ActionEvent> {

	private final SearchCopyUseCase useCase;
	private final SearchCopyView view;

	public ButtonSearchCopyHandler(SearchCopyUseCase useCase, SearchCopyView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			
			TextField txtID = view.getTxtID();
			String id = txtID.getText();
			
			if(!StringUtils.isEmpty(id)) {
				Optional<Copy> optional = useCase.findById(NumberUtils.toLong(id));
				if(optional.isPresent()) {
					Copy copy = optional.get();
					TableView<Copy> tableView = view.getTableView();
					ObservableList<Copy> observableList = FXCollections.observableArrayList(Arrays.asList(copy));
					tableView.setItems(observableList);
				}
			}else {
				List<Copy> books = useCase.findAll();
				TableView<Copy> tableView = view.getTableView();
				ObservableList<Copy> observableList = FXCollections.observableArrayList(books);
				tableView.setItems(observableList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao consultar exemplar");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
}