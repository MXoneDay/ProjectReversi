package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tictactoe implements Game {
	private final static int hor = 3, ver = 3;

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
	public boolean isValid(int loc, int[] board) {
		// check if the move is valid
		System.out.println("Move: " + board[loc]);
		if(board[loc] == 0) {// controleren of de plek leeg is
			board[loc] = 1;
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

