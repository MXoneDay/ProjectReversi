package main;

import controller.PageController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CommandDispatcher;
import model.Connection;
import model.DotEnv;

import java.io.IOException;

public class Main extends Application {
    Connection connection;
    CommandDispatcher dispatcher;
    PageController pc = new PageController();
    DotEnv env;

    {
        try {
            env = new DotEnv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
	public void start(Stage stage) throws Exception {
	    this.connection = new Connection();
	    this.connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
	    this.dispatcher = connection.getDispatcher();

		stage.setTitle("Game");
		stage.setScene(pc.getScene());
		stage.show();
	}
}
