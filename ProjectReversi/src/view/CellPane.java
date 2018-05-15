package view;

import javafx.scene.layout.Pane;

public class CellPane extends Pane {
	public final int loc, hor, ver;
	public String filled = null;

	public CellPane(int loc, int hor, int ver){
		this.loc = loc;
		this.hor = hor;
		this.ver = ver;
	}
	/*
	public int getFilled() {
		return filled;
	}
	
	public void setFilled(int player) {
		filled = player;
	}*/
}
