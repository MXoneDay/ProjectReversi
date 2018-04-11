package model;

import java.util.HashMap;
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
	public boolean isValid(boolean turn, int loc, HashMap<Integer, CellPane> board) {
		// check if the move is valid
		System.out.println("Move: "+ loc + " Filled: " + board.get(loc).filled);
		if(board.get(loc).filled == 0) {// controleren of de plek leeg is
			if(turn) {
				board.get(loc).filled = 1;
			}else {
				board.get(loc).filled = 2;
			}
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

