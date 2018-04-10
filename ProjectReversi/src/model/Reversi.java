package model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	public boolean isValid(int loc, int[] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createAI() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getHor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVer() {
		// TODO Auto-generated method stub
		return 0;
	}

}

