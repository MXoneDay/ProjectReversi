package model;

import javafx.scene.image.ImageView;

public interface Game {
	void setup(Board board);
	boolean isValid(User[] users, int turn, int hor, int ver, Board board, boolean justCheck);
	User createAI();
	ImageView getImage(int turn);
	int getHor();
	int getVer();
}
