package main;

import controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	ViewController viewController = new ViewController();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Game");
		stage.setScene(viewController.toHome());
		stage.show();
	}
}
