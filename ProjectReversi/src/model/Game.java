package model;

import java.util.HashMap;

import javafx.scene.image.ImageView;
import view.CellPane;

public interface Game {
	public boolean isValid(boolean turn, int loc, HashMap<Integer, CellPane> board);
	public void createAI();
	public ImageView getImage(boolean turn);
	public int getHor();
	public int getVer();
}
