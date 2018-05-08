package view;

import controller.PageController;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HomePage implements Page{
	private final PageController pc;
	private GridPane gp = new GridPane();
	
	public HomePage(PageController pc){
		this.pc = pc;
	}
	
	public void createPage() {
		try {
			ToggleGroup tg = new ToggleGroup();
			TextField text = new TextField();
			Label name = new Label("Username: ");
			Label RButtons = new Label("Mode:");
			Button b1 = new Button("Next");
			
			RadioButton rb1 = new RadioButton("Player vs AI");
			RadioButton rb2 = new RadioButton("Player vs Online");
			RadioButton rb3 = new RadioButton("AI vs Online");
			
			rb1.setUserData(2);
			rb1.setToggleGroup(tg);
			rb1.setSelected(true);
			
			rb2.setUserData(3);
			rb2.setToggleGroup(tg);
			
			rb3.setUserData(4);
			rb3.setToggleGroup(tg);
			
			b1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					try {
						pc.toPlayerPage(text.getText(), rb3.isSelected(), rb1.isSelected());
					}
					catch(Exception ex) {
						text.setText(ex.getMessage());
						//TODO popup?
					}
				}
			});
			
			gp.setAlignment(Pos.CENTER);
			gp.add(RButtons, 0, 1);
			gp.add(name, 0, 0);
			gp.add(text, 1, 0);
			gp.add(b1, 2, 5);
			gp.add(rb1, 0, 2);
			gp.add(rb2, 0, 3);
			gp.add(rb3, 0, 4);
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
