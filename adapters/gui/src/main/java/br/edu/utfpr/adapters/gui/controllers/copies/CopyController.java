package br.edu.utfpr.adapters.gui.controllers.copies;

import lombok.Getter;

@Getter
public class CopyController {
	
	private final SaveCopyController saveCopyController;
	private final SearchCopyController searchCopyController;
	
	
	
	public CopyController(SaveCopyController saveCopyController, SearchCopyController searchCopyController) {
		this.saveCopyController = saveCopyController;
		this.searchCopyController = searchCopyController;
	}


	
	

}
