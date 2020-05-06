package br.edu.utfpr.adapters.gui.views.copies;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CopyView extends BorderPane {
	
	private final SaveCopyView saveCopyView;
	private final SearchCopyView searchCopyView;
	
	public CopyView(SaveCopyView saveCopyView, SearchCopyView searchCopyView) {
		this.saveCopyView = saveCopyView;
		this.searchCopyView = searchCopyView;
		init();
	}
	
	private void init() {	
		GridPane gridPane = new GridPane();
		gridPane.add(saveCopyView, 1, 1);
		gridPane.add(searchCopyView, 1, 2);
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.setMaxHeight(Double.MAX_VALUE);
		this.setCenter(gridPane);
	}
	
	

}
