package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Tictactoe implements Game {
	private final int hor = 3, ver = 3;

	@Override
	public void setup(Board board) {
	}

	@Override
	public ImageView getImage(boolean turn) {
		Image img = null;

		if(turn){
			img = new Image("pictures/x.png");
		}else {
			img = new Image("pictures/o.png");
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(Player[] players, int turn, int hor, int ver, Board board, boolean justCheck) {
		// check if the move is valid
		CellPane cp = board.getCell(hor, ver);
		System.out.println("Move: " + cp.loc + cp.filled);
		if(cp.filled == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void createAI() {
		TictactoeAI ai = new TictactoeAI(this);
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

