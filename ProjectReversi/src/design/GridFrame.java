package design;

import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import framework.Move;

public class GridFrame {
	private GridPane gridPane = new GridPane();
	
	public GridPane start(int hor, int ver) {
		
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
						Move.move(cellPane.hor, cellPane.ver);
					}
				});
				gridPane.add(cellPane, i, j);
			}
		};
		
		Text text = new Text("test");
		gridPane.add(text, 0, ver);
		
		//gridPane.setGridLinesVisible(true);
		
		return gridPane;
	}
}
