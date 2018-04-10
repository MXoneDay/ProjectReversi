package model;


import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Reversi implements Game {
	private final static int hor = 8, ver = 8;
	
	@Override
	public ImageView getImage(boolean turn) {
		Image img;
		if(turn){
			img = new Image("pictures/blackpiece.png",60, 60, false, false);
		}else{
			img = new Image("pictures/whitepiece.png",60, 60, false, false);
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(boolean turn, int loc, HashMap<Integer, CellPane> board) {
		//System.out.println("Move: " + loc + board.get(loc).filled);
		System.out.println(board.get(loc));
		System.out.println("Base: " + board.get(loc).hor + board.get(loc).ver + loc);
		System.out.println("Above: " + board.get(loc-hor).hor + board.get(loc-ver).ver + (loc-hor));
		
		
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

