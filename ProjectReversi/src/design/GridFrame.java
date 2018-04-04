package design;

import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import framework.Move;

public class GridFrame {
	private GridPane gridPane = new GridPane();
	
	public GridPane start(int hor, int ver) {
		
		ColumnConstraints cHor = new ColumnConstraints(hor);
		cHor.setPercentWidth(100.0/hor);
		RowConstraints rVer = new RowConstraints(ver);
		rVer.setPercentHeight(100.0/ver);
		
		for(int i = 0; i < hor; i++) {
			gridPane.getColumnConstraints().add(cHor);
		}
		for(int i = 0; i < ver; i++) {
			gridPane.getRowConstraints().add(rVer);
		}
		
		for(int i = 0; i < hor; i++) {
			for(int j = 0; j < ver; j++) {
				CellPane cellpane = new CellPane(i, j);
				cellpane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent me) {
						Move.move(cellpane.hor, cellpane.ver);
						//System.out.println("test " + cellpane.hor + cellpane.ver);
					}
				});
				gridPane.add(cellpane, i, j);
			}
		}
		
		gridPane.setGridLinesVisible(true);
		
		return gridPane;
	}
}
