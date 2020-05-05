package br.edu.utfpr.adapters.gui.views.checkouts;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class SearchCheckOutView extends BorderPane{
	
	private ListView<CheckOut> listView = new ListView<>();
	
	public SearchCheckOutView() {
		setCenter(listView);
	}
	
	
	public ListView<CheckOut> getListView() {
		return listView;
	}
	


}
