package model;

import javafx.scene.image.ImageView;

public interface Game {
	public boolean isValid(int loc, int[] board);
	public void createAI();
	public ImageView getImage(boolean turn);
	public int getHor();
	public int getVer();
}
