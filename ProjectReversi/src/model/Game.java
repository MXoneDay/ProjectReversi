package model;

import javafx.scene.image.ImageView;

public interface Game {
	void setup(Board board);
	boolean isValid(int turn, int hor, int ver, Board board, boolean justCheck);
	void createAI();
	ImageView getImage(int turn);
	String getTurntext(int turn);
	int getHor();
	int getVer();
}
