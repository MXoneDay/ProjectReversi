package model;

import view.CellPane;

public class TictactoeAI implements AI {
	private Tictactoe ttt;
	private Board board;
	private CellPane[] validMoves = new CellPane[ttt.getHor()*ttt.getVer()];
	private int arrLoc = 0;
	private int turn;
	
	TictactoeAI(Tictactoe ttt){
		this.ttt = ttt;
		System.out.println(ttt.getVer());
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void getValidMoves() {
		for (int i = 0; i < ttt.getVer(); i++) {
			for (int j = 0; j < ttt.getHor(); j++) {
				/*if (ttt.isValid(turn, j, i, board, false)) {
					validMoves[arrLoc] = board.getCell(j, i);
					arrLoc++;
				}*/
			}
		}
	}
	
	public void doMove() {
	}
}
