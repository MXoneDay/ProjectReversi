package model;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import view.CellPane;

public class Tictactoe implements Game {
	private final int hor = 3, ver = 3;

	@Override
	public void setup(Board board) {
	}

	@Override
	public ImageView getImage(int turn) {
		Image img = null;

		if(turn == 0){
			img = new Image("pictures/x.jpg");
		}else if(turn == 1){
			img = new Image("pictures/o.jpg");
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(User[] users, int turn, int hor, int ver, Board board, boolean justCheck) {
		// check if the move is valid
		CellPane cp = board.getCell(hor, ver);
		//System.out.println("Move: " + cp.loc + cp.filled);
		if(cp.filled == 3) {
			return true;
		}
		return false;
	}
	
	@Override
	public User createAI(GameFW fw) {

		return new TictactoeAI(fw, this);
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

