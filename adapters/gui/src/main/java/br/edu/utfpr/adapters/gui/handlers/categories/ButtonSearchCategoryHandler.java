package br.edu.utfpr.adapters.gui.handlers.categories;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.categories.SearchCategoryView;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ButtonSearchCategoryHandler implements EventHandler<ActionEvent> {

	private final SearchCategoryUseCase useCase;
	private final SearchCategoryView view;

	public ButtonSearchCategoryHandler(SearchCategoryUseCase useCase, SearchCategoryView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		try {

			TextField txtID = view.getTxtID();
			TextField txtDescription = view.getTxtDescription();

			String id = txtID.getText();
			String description = txtDescription.getText();

			if (!StringUtils.isEmpty(id)) {
				Optional<Category> optional = useCase.findById(NumberUtils.toLong(id));
				if (optional.isPresent()) {
					Category category = optional.get();
					TableView<Category> tableView = view.getTableView();
					ObservableList<Category> observableList = FXCollections.observableArrayList(Arrays.asList(category));
					tableView.setItems(observableList);
				}

			} else if (!StringUtils.isEmpty(description)) {
				List<Category> categorys = useCase.findByDescription(description.toUpperCase());
				TableView<Category> tableView = view.getTableView();
				ObservableList<Category> observableList = FXCollections.observableArrayList(categorys);
				tableView.setItems(observableList);
			} else {
				List<Category> categorys = useCase.findAll();
				TableView<Category> tableView = view.getTableView();
				ObservableList<Category> observableList = FXCollections.observableArrayList(categorys);
				tableView.setItems(observableList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao consultar categoria");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
}