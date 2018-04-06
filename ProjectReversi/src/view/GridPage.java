package view;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import controller.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.*;

public class GridPage implements Page{
	public Text text = new Text("test");
	private final Game game;
	private int hor, ver;
	private final char type;
	
	public GridPage(char type){
		this.type = type;
		if(type == 'r') {
			game = new Reversi();
		}
		else if(type == 't') {
			game = new Tictactoe();
		}
		else {
			throw new java.lang.RuntimeException("Currently unavailable");
		}
		hor = game.getHor();
		ver = game.getVer();
	}
	
	public GridPane createPage() {
		
		ColumnConstraints cHor = new ColumnConstraints(hor);
		cHor.setPercentWidth(100.0/hor);
		RowConstraints rVer = new RowConstraints(ver);
		rVer.setPercentHeight(90.0/ver);
		
		GridPane gridPane = new GridPane();
		GridPane menu = new GridPane();
		
		for(int i = 0; i < hor; i++) {
			gridPane.getColumnConstraints().add(cHor);
		}
		for(int i = 0; i < ver; i++) {
			gridPane.getRowConstraints().add(rVer);
		}
		
		for(int i = 0; i < hor; i++) {
			for(int j = 0; j < ver; j++) {

				CellPane cellPane = new CellPane(i, j);
				cellPane.setStyle("-fx-border-color: black"); // from https://stackoverflow.com/questions/27712213/how-do-i-make-a-simple-solid-border-around-a-flowpane-in-javafx/27712713
				cellPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent me) {
						game.move(cellPane.hor, cellPane.ver);
						cellPane.getChildren().add(game.getImage());
					}
				});
				gridPane.add(cellPane, i, j);


			}
		}
		
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				ViewController.toHome();
			}
		});
		Button reset = new Button("Reset");
		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				ViewController.toGame(type);
			}
		});
		
		menu.add(back, 0, 0);
		menu.add(reset, 1, 0);
		
		gridPane.add(menu, hor-1, ver);
		gridPane.add(text, 0, ver);
		
		return gridPane;
	}
}
