package br.edu.utfpr.adapters.gui.controllers.copies;

import br.edu.utfpr.adapters.gui.views.copies.CopyView;
import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import lombok.Getter;


public class CopyController {
	
	private final SaveCopyController saveCopyController;
	private final SearchCopyController searchCopyController;
	
	@Getter
	private CopyView bookView;
	
	
	public CopyController(SaveCopyController saveCopyController, SearchCopyController searchCopyController) {
		this.saveCopyController = saveCopyController;
		this.searchCopyController = searchCopyController;
		SaveCopyView saveCopyView = this.saveCopyController.getView();
		SearchCopyView searchCopyView = this.searchCopyController.getView();
		this.bookView = new CopyView(saveCopyView, searchCopyView);
	}


	
	

}
