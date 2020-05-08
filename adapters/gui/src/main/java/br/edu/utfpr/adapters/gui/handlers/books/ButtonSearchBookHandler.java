package br.edu.utfpr.adapters.gui.handlers.books;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ButtonSearchBookHandler implements EventHandler<ActionEvent> {

	private final SearchBookUseCase useCase;
	private final SearchBookView view;

	public ButtonSearchBookHandler(SearchBookUseCase useCase, SearchBookView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {

		try {

			TextField txtID = view.getTxtID();
			TextField txtTitle = view.getTxtTitle();
			TextField txtAuthorName = view.getTxtAuthorName();

			String id = txtID.getText();
			String title = txtTitle.getText();
			String authorName = txtAuthorName.getText();

			if (!StringUtils.isEmpty(id)) {
				Optional<Book> optional = useCase.findById(NumberUtils.toLong(id));
				if (optional.isPresent()) {
					Book book = optional.get();
					TableView<Book> tableView = view.getTableView();
					ObservableList<Book> observableList = FXCollections.observableArrayList(Arrays.asList(book));
					tableView.setItems(observableList);
				}
			} else if (!StringUtils.isEmpty(title)) {
				List<Book> books = useCase.findByTitle(title);
				TableView<Book> tableView = view.getTableView();
				ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				tableView.setItems(observableList);
			} else if (!StringUtils.isEmpty(authorName)) {
				List<Book> books = useCase.findByAuthorName(authorName);
				TableView<Book> tableView = view.getTableView();
				ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				tableView.setItems(observableList);
			} else {
				List<Book> books = useCase.findAll();
				TableView<Book> tableView = view.getTableView();
				ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				tableView.setItems(observableList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao consultar livro");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
}