package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Game {
	public int getHor();
	public int getVer();
	public void move(int hor, int ver);
	public void createAI();
	public ImageView getImage();
}
