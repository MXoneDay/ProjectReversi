package model;

import javafx.scene.image.ImageView;

public class Reversi implements Game {
	private int hor = 8, ver = 8;
	//private int turn = 0;
	
	public boolean move(int hor, int ver) {
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

	@Override
	public ImageView getImage() {
		return null;
	}

	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}

	@Override
	public void createAI() {
		new ReversiAI(this);
	}
}

