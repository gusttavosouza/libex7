package br.edu.utfpr.adapters.gui.controllers.checkouts;

import lombok.Getter;

@Getter
public class CheckOutController {
	
	private final SaveCheckOutController saveCheckOutController;
	private final SearchCheckOutController searchCheckOutController;
	

	public CheckOutController(SaveCheckOutController saveCheckOutController, SearchCheckOutController searchCheckOutController) {
		this.saveCheckOutController = saveCheckOutController;
		this.searchCheckOutController = searchCheckOutController;
	}

}
