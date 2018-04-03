package main;

import design.Home;
import javafx.application.*;
import javafx.stage.*;

public class Main extends Application {
	public static char mode;
	public static String usernm;
	private Home home = new Home();
	
	@Override
	public void start(Stage stage) throws Exception {
		home.start(stage);
	}
}
