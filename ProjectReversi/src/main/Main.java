package main;

import controller.PageController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CommandDispatcher;
import model.Connection;

public class Main extends Application {
    Connection connection;
    CommandDispatcher dispatcher;
    PageController pc = new PageController();

	@Override
	public void start(Stage stage) throws Exception {
	    this.connection = new Connection();
	    this.connection.start("145.33.225.170", 7789);
	    this.dispatcher = connection.getDispatcher();

		stage.setTitle("Game");
		stage.setScene(pc.getScene());
		stage.show();
	}
}
