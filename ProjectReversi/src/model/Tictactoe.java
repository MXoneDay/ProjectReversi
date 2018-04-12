package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Tictactoe implements Game {
	private final static int hor = 3, ver = 3;

	@Override
	public String getTurntext(boolean turn) {
		String t;
		if(turn){
			t =  "Turn : Player X"; }
		else{
			t = "Turn : Player O";
		}
		return t;
	}

	@Override
	public ImageView getImage(boolean turn) {
		Image img;
		if(turn){
			img = new Image("pictures/x.png");
		}else{
			img = new Image("pictures/o.png");
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(boolean turn, CellPane cp, CellPane[][] board) {
		// check if the move is valid
		System.out.println("Move: " + cp.loc + cp.filled);
		if(cp.filled == 0) {// controleren of de plek leeg is
			if(turn) {
				cp.filled = 1;
			}else {
				cp.filled = 2;
			}
			cp.filled = turn ? 1 : 2;
			return true;
		}
		return false;
	}
	
	@Override
	public void createAI() {
		// TODO Auto-generated method stub
		
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

