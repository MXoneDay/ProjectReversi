package model;

import java.util.HashMap;
import view.CellPane;


public class GameFW {
	private HashMap<Integer, CellPane> board = new HashMap<Integer, CellPane>();
	//private CellPane[] board2;
	private boolean turn;
	private Game game;
	private final char type;
	
	public GameFW(char type){
		this.type = type;
	}
	
	public int getHor() {
		return game.getHor();
	}
	
	public void setBoard(int loc, Object cp) {
		board.put(loc, (CellPane) cp);
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
		//board2 = new CellPane[game.getHor()*game.getVer()];
		turn = true;
	}
	
	public int getVer() {
		return game.getVer();
	}
	
	public Object getImage() {
		return game.getImage(turn);
	}
	
	public boolean move(int loc) {
		if(turn) {
			turn = !game.isValid(turn, loc, board);
			return !turn;
		}else {
			turn = game.isValid(turn, loc, board);
			return turn;
		}
	}
}
