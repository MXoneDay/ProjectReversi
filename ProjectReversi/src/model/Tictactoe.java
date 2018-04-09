package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Tictactoe implements Game {
	private final int hor = 3, ver = 3;
	private int board[][] = new int[hor][ver];
	private boolean turn = true;

	private Pane pane = new Pane();

	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}
	
	public void createAI() {
		new TictactoeAI(this);
	}

	public Pane getPane(){
		return pane;
	}
	
	@Override
	public boolean move(int hor, int ver) {
		System.out.println("TTT: " + hor + "-" + ver);
		// check if the move is valid
		if(hor <= this.hor && ver <= this.ver) {// check if move is within board
			if(board[hor][ver] == 0) {// controleren of de plek leeg is
				if(turn){
					turn = false;
				}
				else{
					turn = true;
				}
				System.out.println("Move: " + board[hor][ver] + " " + turn);
				board[hor][ver] = 1;
				return true;
			}
		}
		return false;
		//versturen
	}

	@Override
	public ImageView getImage() {
		Image img;
		if(turn){
			img = new Image("pictures/x.png");
		}else{
			img = new Image("pictures/o.png");
		}
		return new ImageView(img);
	}
}

