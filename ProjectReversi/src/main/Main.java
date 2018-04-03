package main;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;

public class Main extends Application {
	public static char mode;
	public static String usernm;
	
	final TextField text = new TextField();
	Label label = new Label("Username: ");
	Button b1 = new Button("TicTacToe");
	Button b2 = new Button("Reversi");
	
	@Override
	public void start(Stage stage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.add(label, 0, 0);
			root.add(text, 1, 0);
			root.add(b1, 0, 1);
			root.add(b2, 1, 1);
			
			b1.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent ae) {
					usernm = text.getText();
				}
			});
			b2.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent ae) {
					usernm = text.getText();
				}
			});
			
			Scene scene = new Scene(root, 400, 400);
			
			stage.setTitle("Test");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
