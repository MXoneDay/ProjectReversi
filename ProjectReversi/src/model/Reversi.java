package model;

import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Reversi implements Game {
	private final static int hor = 8, ver = 8;

	@Override
	public String getTurntext(int turn) {
		String t = null;
		if(turn == 1){
			t =  "Turn : Player White"; }
		else if(turn == 2){
			t = "Turn : Player Black";
		}
		return t;
	}

	@Override
	public ImageView getImage(int turn) {
		Image img = null;
		if(turn == 1){
			img = new Image("pictures/blackpiece.png", 60 ,60, false, true);
		}else if(turn == 2){
			img = new Image("pictures/whitepiece.png", 60, 60, false, true);
		}
		ImageView iv = new ImageView(img);
		return iv;
	}

	@Override
	public boolean isValid(int turn, int hor, int ver, Board board) {
		System.out.println("Move: " + hor + "-" + ver + " " + turn);
		int[] horray = board.checkHor(ver);
		int[] verray = board.checkVer(hor);
		
		try {
			boolean go = false;
			for(int i = hor; i < horray.length; ++i) {
				if(horray[i] != turn && horray[i] != 0) {
					go = true;
				}
				if(go) {
					if(horray[i] == turn) {
						System.out.println(board.getCell(i-1, ver).filled);
						board.getCell(i-1, ver).getChildren().clear();
						board.getCell(i-1, ver).getChildren().add(getImage(turn));
					}
				}
			}
			go = false;
			for(int i = hor; i > 0; i--) {
				if(horray[hor] != turn && horray[hor] != 0) {
					go = true;
				}
				if(go) {
					if(horray[hor] == turn) {
						System.out.println(hor);
					}
				}
			}
		}
		catch(Exception ex){
			return false;
		}
		//System.out.println(Arrays.toString(board.checkVer(hor)));
		return true;
	}

	@Override
	public void createAI() {
	}
	
	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}

}

