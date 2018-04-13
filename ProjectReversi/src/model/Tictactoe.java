package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Tictactoe implements Game {
	private final static int hor = 3, ver = 3;

	@Override
	public String getTurntext(int turn) {
		String t = null;
		if(turn == 1){
			t =  "Turn : Player O"; }
		else if(turn == 2){
			t = "Turn : Player X";
		}
		return t;
	}

	@Override
	public ImageView getImage(int turn) {
		Image img = null;
		if(turn == 1){
			img = new Image("pictures/x.png");
		}else if(turn == 2){
			img = new Image("pictures/o.png");
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(int turn, int hor, int ver, Board board) {
		// check if the move is valid
		CellPane cp = board.getCell(hor, ver);
		System.out.println("Move: " + cp.loc + cp.filled);
		if(cp.filled == 0) {// controleren of de plek leeg is
			//cp.filled = 1;
			//cp.filled = 2;
			//cp.filled = turn ? 1 : 2;
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

