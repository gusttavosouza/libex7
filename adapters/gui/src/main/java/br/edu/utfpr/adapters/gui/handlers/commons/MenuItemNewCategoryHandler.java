package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.categories.CategoryController;
import br.edu.utfpr.adapters.gui.controllers.categories.SaveCategoryController;
import br.edu.utfpr.adapters.gui.views.categories.SaveCategoryView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public final class MenuItemNewCategoryHandler implements EventHandler<ActionEvent> {
	private final CategoryController categoryController;

	public MenuItemNewCategoryHandler(CategoryController categoryController) {
		this.categoryController = categoryController;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveCategoryController saveCategoryController = categoryController.getSaveCategoryController();
		SaveCategoryView saveCategoryView = saveCategoryController.getView();
		saveCategoryView.show();
	}
}
