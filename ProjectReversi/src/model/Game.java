package model;

import javafx.scene.image.ImageView;
import view.CellPane;

public interface Game {
	public boolean isValid(boolean turn, CellPane cp, CellPane[][] board);
	public void createAI();
	public ImageView getImage(boolean turn);
	public int getHor();
	public int getVer();
}
