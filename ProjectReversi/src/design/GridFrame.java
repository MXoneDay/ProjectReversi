package design;

import javafx.scene.layout.*;
import javafx.scene.control.*;

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
		for(int i = 0; i < hor; i++) {
			gridPane.getRowConstraints().add(rVer);
		}
		/*
		rVer.setPercentHeight(50.0);
		gridPane.getRowConstraints().add(rVer);
		
		Button button = new Button("test");
		gridPane.add(button, 2, 3);*/
		
		gridPane.setGridLinesVisible(true);
		
		return gridPane;
	}
}
