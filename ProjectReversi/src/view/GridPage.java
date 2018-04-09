package view;

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
	private final Game game;
	private final char type;
	private final ViewController vc;
	private final int hor, ver;
	public Text text = new Text("test");
	
	public GridPage(ViewController vc, char type){
		this.vc = vc;
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
						if(game.move(cellPane.hor, cellPane.ver)) {
							cellPane.getChildren().add(game.getImage());
						}
					}
				});
				gridPane.add(cellPane, i, j);
			}
		}
		
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				vc.toHome();
			}
		});
		Button reset = new Button("Reset");
		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				vc.toGame(type);
			}
		});
		
		menu.add(back, 0, 0);
		menu.add(reset, 1, 0);
		/*
		int test = hor;
		if(hor > 3) {
			test = hor/3;
		}
		System.out.println(test);
		gridPane.add(menu, hor-1, ver, test, 1);*/
		gridPane.add(menu, hor-1, ver);
		gridPane.add(text, 0, ver);
		
		return gridPane;
	}
}
