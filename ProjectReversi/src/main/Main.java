package main;

import controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CommandDispatcher;
import model.Connection;

public class Main extends Application {
	ViewController viewController = new ViewController();
    Connection connection;
    CommandDispatcher dispatcher;

	@Override
	public void start(Stage stage) throws Exception {
	    this.connection = new Connection();
	    this.connection.start("localhost", 7789);
	    this.dispatcher = connection.getDispatcher();

		stage.setTitle("Game");
		stage.setScene(viewController.toHome());
		stage.show();
	}
}
