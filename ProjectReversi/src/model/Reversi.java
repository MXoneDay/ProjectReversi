package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Reversi implements Game {
	private final static int hor = 8, ver = 8;

	@Override
	public String getTurntext(int turn) {
		String t = null;
		if(turn == 1){
			t =  "Turn : Player White"; }
		else if(turn == 2){
			t = "Turn : Player Black";
		}
		return t;
	}

	@Override
	public ImageView getImage(int turn) {
		Image img = null;
		if(turn == 1){
			img = new Image("pictures/blackpiece.png",60, 60, false, true);
		}else if(turn == 2){
			img = new Image("pictures/whitepiece.png",60, 60, false, true);
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(int turn, int hor, int ver, Board board) {
		System.out.println("Move: " + hor + "-" + ver);
		return true;
	}

	@Override
	public void createAI() {
	}
	
	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}

}

