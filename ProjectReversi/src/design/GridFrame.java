package design;

import javafx.scene.Scene;
import javafx.scene.layout.*;

public class GridFrame {
	private GridPane gridPane = new GridPane();
	
	public Scene start(int hor, int ver) {
		
		ColumnConstraints cHor = new ColumnConstraints(hor);
		cHor.setPercentWidth(100.0/hor);
		RowConstraints rVer = new RowConstraints(ver);
		rVer.setPercentHeight(100.0/ver);
		
		for(int i = 0; i < hor; i++) {
			gridPane.getColumnConstraints().add(cHor);
		}
		for(int i = 0; i < hor; i++) {
			gridPane.getRowConstraints().add(rVer);
		}
		
		gridPane.setGridLinesVisible(true);
		
		Scene scene = new Scene(gridPane, 400, 400);
		
		return scene;
	}
}
