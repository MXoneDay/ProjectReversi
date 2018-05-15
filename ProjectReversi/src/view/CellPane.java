package view;

import javafx.scene.layout.Pane;

public class CellPane extends Pane {
	public final int loc, hor, ver;
	public int filled = 3;

	public CellPane(int loc, int hor, int ver){
		this.loc = loc;
		this.hor = hor;
		this.ver = ver;
	}
	
	@Override
	public String toString() {
		return hor + "-" + ver + " " + filled;
		
	}
	/*
	public int getFilled() {
		return filled;
	}
	
	public void setFilled(int player) {
		filled = player;
	}*/
}
