package main;

import controller.PageController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CommandDispatcher;
import model.Connection;

public class Main extends Application {
    PageController pc = new PageController();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Game");
		stage.setScene(pc.getScene());
		stage.show();
	}
}
