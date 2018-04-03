package design;

import javafx.scene.*;
import javafx.scene.layout.*;
import main.Main;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.stage.*;

public class Home {
	
	public void start(Stage stage) {
		try {
			TextField text = new TextField();
			Label label = new Label("Username: ");
			Button b1 = new Button("TicTacToe");
			Button b2 = new Button("Reversi");
			
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.add(label, 0, 0);
			root.add(text, 1, 0);
			root.add(b1, 0, 1);
			root.add(b2, 1, 1);
			
			b1.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent ae) {
					Main.usernm = text.getText();
					Main.mode = 't';
					System.out.println("b1: " + Main.usernm);
						Scene scene = tictactoe.Setup.setup();
						stage.setScene(scene);
				}
			});
			b2.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent ae) {
					Main.usernm = text.getText();
					Main.mode = 'r';
					System.out.println("b2: " + Main.usernm);
					Scene scene = reversi.Setup.setup();
					stage.setScene(scene);
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
