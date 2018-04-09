package model;

import javafx.scene.image.ImageView;

public class Reversi implements Game {
	private int hor = 8, ver = 8;

	private int board[][] = new int[hor][ver];
	private boolean turn = true;
	/*
	public void move(int hor, int ver) {
		System.out.println("reversi: " + hor + ver);
		// check if the move is valid
		// check if move is within board
		if(hor > this.hor) {
			
		}
		if(ver > this.ver) {
			
		}
		
		return false;
		// controleren of de plek leeg is 
		// controleren of de ander ernaast zit
		// controleren of diagonaal of horizontaal of verticaal iets van jou zit
	}
	*/

	// tijdelijke move functie om te kijken of de reversi pieces werken
	public void move(int hor, int ver) {
		System.out.println("tictactoe: " + hor + ver);
		// check if the move is valid
		//if(turn) {
		if(hor <= this.hor) {// check if move is within board
			if(ver <= this.ver) {// check if move is within board
				if(board[hor][ver] == 0) {// controleren of de plek leeg is
					if(turn){
						turn = false;
					}
					else{
						turn = true;
					}
					System.out.println(board[hor][ver] + " " + turn);
					// zet in board
					board[hor][ver] = 1;
					//turn = false;
					//
				}
			}
		}
		//}
		//versturen

	}
	@Override
	public ImageView getImage() {
		Image img;
		if(turn){
			img = new Image("pictures/blackpiece.png",60, 60, false, false);
		}else{
			img = new Image("pictures/whitepiece.png",60, 60, false, false);
		}
		return new ImageView(img);
	}

	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}

	/*
	true = x
	false = o
	depending on the outcome it will return a text that can be displayed in the class GridPage
 	*/
	@Override
	public String getTurntext() {
		if(turn){
			return new String("Turn : Player White");
		}
		else{
			return new String("Turn : Player Black");
		}
	}

	@Override
	public String getScore() {
		return null;
	}

	@Override
	public void createAI() {
		new ReversiAI(this);
	}
}

