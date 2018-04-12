package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Reversi implements Game {
	private final static int hor = 8, ver = 8;

	@Override
	public String getTurntext(boolean turn) {
		String t;
		if(turn){
			t =  "Turn : Player White"; }
		else{
			t = "Turn : Player Black";
		}
		return t;
	}

	@Override
	public ImageView getImage(boolean turn) {
		Image img;
		if(turn){
			img = new Image("pictures/blackpiece.png",60, 60, false, true);
		}else{
			img = new Image("pictures/whitepiece.png",60, 60, false, true);
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(boolean turn, CellPane cp, CellPane[][] board) {
		System.out.println("Move: " + cp.hor + "-" + cp.ver + " " + cp.filled);
		/*System.out.println(board.get(loc));
		//System.out.println("Base: " + board.get(loc).hor + board.get(loc).ver + loc);
		//System.out.println("Above: " + board.get(loc-hor).hor + board.get(loc-ver).ver + (loc-hor));
		//checkUp(loc, board);
		//board.get(loc).filled = 1;
		//System.out.println(board[cp.ver][cp.hor-8].filled);*/
		int player = turn ? 1 : 2;
		//toConvert = new ArrayList<int[]>();
		if(board[cp.ver][cp.hor].filled == 0) {
			try {
				//checkUp(turn, cp, board);
			}
			catch(Exception ex) {}
			board[cp.ver][cp.hor].filled = turn ? 1 : 2;
			return true;
		}
		return false;
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

