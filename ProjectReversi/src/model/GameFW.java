package model;

import view.CellPane;


public class GameFW {
	private CellPane[][] board;
	private boolean turn;
	private Game game;
	private final char type;
	
	public GameFW(char type){
		this.type = type;
	}
	
	public int getHor() {
		return game.getHor();
	}
	
	public void setBoard(int loc, Object ocp) {
		CellPane cp = (CellPane) ocp;
		board[cp.ver][cp.hor] = cp;
	}
	
	public void setGame() throws Exception{
		if(type == 'r') {
			game = new Reversi();
		}else if(type == 't') {
			game = new Tictactoe();
		}
		else {
			throw new Exception("Not currently supported");
		}
		board = new CellPane[game.getVer()][game.getHor()];
		turn = true;
	}
	
	public int getVer() {
		return game.getVer();
	}
	
	public Object getImage() {
		return game.getImage(turn);
	}
	
	public boolean move(Object cp) {
		if(turn) {
			turn = !game.isValid(turn, (CellPane) cp, board);
			return !turn;
		}else {
			turn = game.isValid(turn, (CellPane) cp, board);
			return turn;
		}
	}
}
