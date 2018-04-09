package model;

import javafx.scene.image.ImageView;

public interface Game {
	public int getHor();
	public int getVer();
	public boolean move(int hor, int ver);
	public void createAI();
	public ImageView getImage();
	public String getTurntext();
	public String getScore();
}
