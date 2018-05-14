package model;

import javafx.scene.image.ImageView;

public interface Game {
	void setup(Board board);
	boolean isValid(Player turn, int hor, int ver, Board board, boolean justCheck);
	void createAI();
	ImageView getImage(boolean turn);
	int getHor();
	int getVer();
}
