package view;

import javafx.scene.layout.Pane;

public class CellPane extends Pane {
	public final int hor, ver;
	
	public CellPane(int hor, int ver){
		this.hor = hor;
		this.ver = ver;
	}
}
