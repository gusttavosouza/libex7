package br.edu.utfpr.adapters.gui.controllers.categories;

import lombok.Getter;

@Getter
public class CategoryController {
	
	private final SaveCategoryController saveCategoryController;
	private final SearchCategoryController searchCategoryController;
	
	
	
	public CategoryController(SaveCategoryController saveCategoryController,
							SearchCategoryController searchCategoryController) {
		this.saveCategoryController = saveCategoryController;
		this.searchCategoryController = searchCategoryController;
	}


	
	

}
