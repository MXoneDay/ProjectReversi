package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.HomePage;

public class Main extends Application {
	//public char mode;
	private HomePage home = new HomePage();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Game");
		stage.setScene(home.createHome());
		stage.show();
	}
}
