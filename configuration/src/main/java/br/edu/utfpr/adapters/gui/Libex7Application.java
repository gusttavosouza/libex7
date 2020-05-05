package br.edu.utfpr.adapters.gui;

import br.edu.utfpr.adapters.gui.configuration.commons.MainConfiguration;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Libex7Application extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		 MainView mainView = new MainView(new BorderPane());
		 Scene scene = new Scene(mainView);
		 primaryStage.setTitle("Biblioteca Libex7");
	     primaryStage.setScene(scene);
	     primaryStage.setMaximized(true); 
	     MainConfiguration configuration = new MainConfiguration(mainView);
	     configuration.configure();     
	     primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
