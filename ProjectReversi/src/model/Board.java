package model;

import view.CellPane;

public class Board {
	private CellPane[][] board;
	
	Board(int hor, int ver){
		board = new CellPane[ver][hor];
	}
	
	public void setInBoard(Object ocp) {
		CellPane cp = (CellPane) ocp;
		board[cp.ver][cp.hor] = cp;
	}
	
	public CellPane getCell(int hor, int ver) {
		return board[ver][hor];
	}
}