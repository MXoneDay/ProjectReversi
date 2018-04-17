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
		
		boolean ret = false;;
		boolean go = false;
		int i = hor, j = ver, done = 0;
		int enemy = (turn == 1) ? 2 : 1;
		CellPane cp;
		
		if(!checkProx(turn, hor, ver, board)) {
			return ret;
		}

		while(done < 8) {
			try {
				if(board.getCell(i, j).filled == enemy) {
					System.out.println(done);
					go = true;
				}
				if(go) {
					if(board.getCell(i, j).filled == turn) {
						while(go) {
							if(i == hor && j == ver) {
								done++;
								go = false;
							}else {
								if(i != hor) {
									i = (i < hor) ? ++i : --i;
								}
								if(j != ver) {
									j = (j < ver) ? ++j : --j;
								}
							}
							/*
							if(i == hor) {
								
							}else if(i < hor) {
								i++;
								
							}else if(i > hor) {
								i--;
							}
							if(j == ver) {
								
							}else if(j < ver) {
								j++;
								
							}else if(j > ver) {
								j--;
							}*/
							cp = board.getCell(i, j);
							cp.getChildren().clear();
							cp.filled = turn;
							cp.getChildren().add(getImage(turn));
							ret = true;
						}
					}
				}
			}
			catch(Exception ex) {
				i = hor;
				j = ver;
				done++;
				go = false;
			}
			
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
			/*
			if(done == 0) {
				i++;
			}else if(done == 1) {
				i--;
			}else if(done == 2) {
				j++;	
			}else if(done == 3) {
				j--;
			}else if(done == 4) {
				i++;
				j++;
			}else if(done == 5) {
				i--;
				j--;
			}else if(done == 6) {
				i--;
				j++;
			}else if(done == 7) {
				++i;
				--j;
			}*/
		}
		return ret;
	}
	
	private boolean checkProx(int turn, int hor, int ver, Board board) {
		if(board.getCell(hor+1, ver).filled == turn) {
			return true;
		}
		if(board.getCell(hor-1, ver).filled == turn) {
			return true;
		}
		if(board.getCell(hor, ver+1).filled == turn) {
			return true;
		}
		if(board.getCell(hor, ver-1).filled == turn) {
			return true;
		}
		if(board.getCell(hor+1, ver+1).filled == turn) {
			return true;
		}
		if(board.getCell(hor+1, ver-1).filled == turn) {
			return true;
		}
		if(board.getCell(hor-1, ver-1).filled == turn) {
			return true;
		}
		if(board.getCell(hor-1, ver+1).filled == turn) {
			return true;
		}
		return false;
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