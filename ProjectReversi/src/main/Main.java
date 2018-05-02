package main;

import controller.PageController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    PageController pc = new PageController();

    @Override
	public void start(Stage stage) throws Exception {
		  stage.setTitle("Game");
		  stage.setScene(pc.getScene());
		  stage.show();
		  stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent we) {
				try {
					pc.disconnect();
				}
				catch(Exception ex) {
				}
			}
		  });
	}
}
