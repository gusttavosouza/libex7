package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.categories.CategoryController;
import br.edu.utfpr.adapters.gui.controllers.categories.SearchCategoryController;
import br.edu.utfpr.adapters.gui.views.categories.SearchCategoryView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemSearchCategoryHandler implements EventHandler<ActionEvent> {
	private final CategoryController categoryController;

	public MenuItemSearchCategoryHandler(CategoryController categoryController) {
		this.categoryController = categoryController;
	}

	@Override
	public void handle(ActionEvent event) {
		SearchCategoryController searchCategoryController = categoryController.getSearchCategoryController();
		 SearchCategoryView searchCategoryView = searchCategoryController.getView();
		 searchCategoryView.show();
	}
}