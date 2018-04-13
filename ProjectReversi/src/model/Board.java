package model;

import java.util.ArrayList;
import view.CellPane;

public class Board {
	private CellPane[][] board;
	
	Board(int hor, int ver){
		board = new CellPane[ver][hor];
	}
	
	public boolean checkFilled(int hor, int ver) {
		return true;
	}
	
	public void setInBoard(Object ocp) {
		CellPane cp = (CellPane) ocp;
		board[cp.ver][cp.hor] = cp;
	}
	
	public void reset() {
		for(int  i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j].getChildren().clear();
				board[i][j].filled = 0;
			}
		}
	}
	
	public CellPane getCell(int hor, int ver) {
		return board[ver][hor];
	}
	
	public ArrayList<Integer> getUp(int hor, int ver) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		System.out.println("Started ");
		for(int i = ver; i > 0; i--) {
			if(board[i][hor].filled != 0) {
				result.add(board[i][hor].filled);
			}
		}
		//System.out.println(Arrays.toString(result));
		return result;
			/*
			for(int i = ver; i > 0; i--) {
				if(board[i][hor].filled == check) {
					enemy = true;
				}
				if(enemy) {
					if(board[i][hor].filled == turn) {
						System.out.println("yay: " + i + hor);
						return;
					}
				}
			}*/
	}
	public void checkDown() {
		
	}
	public void checkRight() {
		
	}
	public void checkLeft() {
		
	}
	public void checkDR() {
		
	}
	public void checkDL() {
		
	}
	public void checkUR() {
		
	}
	public void checkUL() {
		
	}
}