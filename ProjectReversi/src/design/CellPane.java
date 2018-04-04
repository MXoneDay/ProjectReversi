package design;

import javafx.scene.layout.*;

public class CellPane extends Pane {
	public final int hor, ver;
	
	CellPane(int hor, int ver){
		this.hor = hor;
		this.ver = ver;
	}
}
