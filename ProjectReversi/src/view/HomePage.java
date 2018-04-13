package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import controller.PageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HomePage implements Page{
	public String usernm = "";
	private final PageController pc;
	private GridPane gp = new GridPane();
	
	public HomePage(PageController pc){
		this.pc = pc;
	}
	
	public void createPage() {
		try {
			ToggleGroup tg = new ToggleGroup();
			TextField text = new TextField(usernm);
			Label label = new Label("Username: ");
			
			RadioButton rb1 = new RadioButton("Player vs Player");
			rb1.setToggleGroup(tg);
			rb1.setSelected(true);
			RadioButton rb2 = new RadioButton("Player vs AI");
			rb2.setToggleGroup(tg);
			RadioButton rb3 = new RadioButton("AI vs AI");
			rb3.setToggleGroup(tg);
			
			Button b1 = new Button("TicTacToe");
			Button b2 = new Button("Reversi");
			Button b3 = new Button("Players");


			gp.setAlignment(Pos.CENTER);
			gp.add(label, 0, 0);
			gp.add(text, 1, 0);
			gp.add(b1, 0, 1);
			gp.add(b2, 1, 1);
			gp.add(b3, 2, 1);
			gp.add(rb1, 0, 2);
			gp.add(rb2, 0, 3);
			gp.add(rb3, 0, 4);
			
			b1.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent ae) {
					usernm = text.getText();
					try {
						pc.setUser1(usernm);
						pc.setGameFW('t');
						
						//pc.getgFW().getDispatcher().login(usernm);
						//pc.getgFW().getDispatcher().subscribe("Tic-tac-toe");
					}
					catch(Exception ex) {
						text.setText(ex.getMessage());
					}
				}
			});
			b2.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent ae) {
					usernm = text.getText();
					try {
						pc.setUser1(usernm);
						pc.setGameFW('r');
					}
					catch(Exception ex) {
						text.setText(ex.getMessage());
					}
				}
			});
			b3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					usernm = text.getText();
					try {
						pc.setUser1(usernm);
						pc.toPlayerPage();
					}
					catch(Exception ex) {
						text.setText(ex.getMessage());
					}
				}
			});
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public GridPane getPane() {
		return gp;
	}
}
