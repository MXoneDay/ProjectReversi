package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Reversi implements Game {
	private final int hor = 8, ver = 8;
	
	@Override
	public void setup(Board board) {
		CellPane cp;
		cp = board.getCell(3, 3);
		cp.filled = 2;
		cp.getChildren().add(getImage(2));
		cp = board.getCell(3, 4);
		cp.filled = 1;
		cp.getChildren().add(getImage(1));
		cp = board.getCell(4, 3);
		cp.filled = 1;
		cp.getChildren().add(getImage(1));
		cp = board.getCell(4, 4);
		cp.filled = 2;
		cp.getChildren().add(getImage(2));
	}

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
	
	@Override
	public boolean isValid(int turn, int hor, int ver, Board board) {
		System.out.println("Move: " + hor + "-" + ver + " " + turn + " " + board.getCell(hor, ver).filled);
		if(board.getCell(hor, ver).filled != 0) {
			return false;
		}
		
		boolean ret = false, go = false;
		int i = hor, j = ver, done = 0, cpFill;
		int enemy = (turn == 1) ? 2 : 1;
		CellPane cp;
		
		while(done < 8) {
			switch(done) {
			case 0:
				i++;
				break;
			case 1:
				i--;
				break;
			case 2:
				j++;
				break;
			case 3:
				j--;
				break;
			case 4:
				i++;
				j++;
				break;
			case 5:
				i--;
				j--;
				break;
			case 6:
				i--;
				j++;
				break;
			case 7:
				i++;
				j--;
				break;
			}
			try {
				cpFill = board.getCell(i, j).filled;
				
				if(cpFill == enemy) {
					go = true;
					continue;
				}else if(cpFill == 0) {
					throw new Exception();
				}else if(cpFill == turn) {
					while(go) {
						cp = board.getCell(i, j);
						cp.getChildren().clear();
						cp.filled = turn;
						cp.getChildren().add(getImage(turn));
						ret = true;
						if(i == hor && j == ver) {
							throw new Exception();
						}else {
							if(i != hor) {
								i = (i < hor) ? ++i : --i;
							}
							if(j != ver) {
								j = (j < ver) ? ++j : --j;
							}
						}
					}
				}
				throw new Exception();
			}
			catch(Exception ex) {
				i = hor;
				j = ver;
				done++;
				go = false;
			}
		}
		return ret;
	}
}