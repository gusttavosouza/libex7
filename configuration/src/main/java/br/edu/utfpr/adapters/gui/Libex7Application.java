package br.edu.utfpr.adapters.gui;

import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.adapters.gui.views.common.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Libex7Application extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		 SaveAuthorView saveAuthorView = new SaveAuthorView();
		 MainView mainView = new MainView(saveAuthorView);
		 Scene scene = new Scene(mainView);
		 primaryStage.setTitle("Biblioteca Libex7");
	     primaryStage.setScene(scene);
	     primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
