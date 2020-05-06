package br.edu.utfpr.adapters.gui;

import br.edu.utfpr.adapters.gui.configuration.commons.MainConfiguration;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Libex7Application extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		 MainView mainView = new MainView(new BorderPane()); 
	     MainConfiguration configuration = new MainConfiguration(mainView);
	     configuration.configure();     
	     mainView.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
