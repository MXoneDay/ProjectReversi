package model;

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
			for(int i = hor; i < horray.length; i++) {
				if(horray[i] != turn && horray[i] != 0) {
					go = true;
				}
				if(go) {
					if(horray[i] == turn) {
						while(i > hor) {
							--i;
							board.getCell(i, ver).getChildren().clear();
							board.getCell(i, ver).getChildren().add(getImage(turn));
						}
						break;
					}
				}
			}
			go = false;
			for(int i = hor; i >= 0; i--) {
				if(horray[i] != turn && horray[i] != 0) {
					go = true;
				}
				if(go) {
					if(horray[i] == turn) {
						while(i < hor) {
							++i;
							board.getCell(i, ver).getChildren().clear();
							board.getCell(i, ver).getChildren().add(getImage(turn));
						}
						break;
					}
				}
			}
			// ver
			go = false;
			for(int i = ver; i < verray.length; i++) {
				if(verray[i] != turn && verray[i] != 0) {
					go = true;
				}
				if(go) {
					if(verray[i] == turn) {
						while(i > ver) {
							--i;
							board.getCell(hor, i).getChildren().clear();
							board.getCell(hor, i).getChildren().add(getImage(turn));
						}
						break;
					}
				}
			}
			go = false;
			for(int i = ver; i >= 0; i--) {
				if(verray[i] != turn && verray[i] != 0) {
					go = true;
				}
				if(go) {
					if(verray[i] == turn) {
						while(i < ver) {
							++i;
							board.getCell(hor, i).getChildren().clear();
							board.getCell(hor, i).getChildren().add(getImage(turn));
						}
						break;
					}
				}
			}
			
			go = false;
			for(int i = ver; i < verray.length; i++) {
				if(verray[i] != turn && verray[i] != 0) {
					go = true;
				}
				if(go) {
					if(verray[i] == turn) {
						while(i > ver) {
							--i;
							board.getCell(hor, i).getChildren().clear();
							board.getCell(hor, i).getChildren().add(getImage(turn));
						}
						break;
					}
				}
			}
			go = false;
			
			
			/*
			int i = 0, j = 0;
			while(i < horray.length && j < verray.length) {
				if(board.getCell(i, j).filled != 0 && board.getCell(i, j).filled != turn) {
					go = true;
				}
				if(go) {
					if(board.getCell(i, j).filled == turn) {
						while(i > hor && j > ver) {
							--i;
							--j;
							board.getCell(i, j).getChildren().clear();
							board.getCell(i, j).getChildren().add(getImage(turn));
						}
						break;
					}
				}
				i++;
				j++;
			}*/
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return false;
		}
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

