package main;

import controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Game");
		stage.setScene(ViewController.toHome());
		stage.show();
	}
}
