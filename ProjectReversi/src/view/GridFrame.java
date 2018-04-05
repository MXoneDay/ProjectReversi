package view;

import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import model.Game;
import model.Reversi;
import model.Tictactoe;
import games.*;

public class GridFrame {
	private GridPane gridPane = new GridPane();
	public Text text = new Text("test");
	private final Game game;
	private int hor, ver;
	
	GridFrame(char game){
		if(game == 'r') {
			this.game = new Reversi();
		}
		else if(game == 't') {
			this.game = new Tictactoe();
		}
		else {
			this.game = null;
		}
		hor = this.game.getHor();
		ver = this.game.getVer();
	}
	
	public GridPane createGrid() {
		
		ColumnConstraints cHor = new ColumnConstraints(hor);
		cHor.setPercentWidth(100.0/hor);
		RowConstraints rVer = new RowConstraints(ver);
		rVer.setPercentHeight(90.0/ver);
		
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
						game.check(cellPane.hor, cellPane.ver);
					}
				});
				gridPane.add(cellPane, i, j);
			}
		};
		
		gridPane.add(text, 0, ver);
		
		return gridPane;
	}
}
