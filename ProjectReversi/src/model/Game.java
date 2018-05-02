package model;

import javafx.scene.image.ImageView;

public interface Game {
	public void setup(Board board);
	public boolean isValid(int turn, int hor, int ver, Board board, boolean justCheck);
	public void createAI();
	public ImageView getImage(int turn);
	public String getTurntext(int turn);
	public int getHor();
	public int getVer();
}
