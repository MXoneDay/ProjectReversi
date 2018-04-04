package main;

import design.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static char mode;
	public static String usernm;
	private Home home = new Home();
	
	@Override
	public void start(Stage stage) throws Exception {
		home.start(stage);
	}
}
