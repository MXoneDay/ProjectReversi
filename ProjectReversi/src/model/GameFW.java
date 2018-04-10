package model;

public class GameFW {
	private int board[];
	private boolean turn;
	private Game game;
	private final char type;
	
	public GameFW(char type){
		this.type = type;
	}
	
	public int getHor() {
		return game.getHor();
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
		board = new int[game.getHor()*game.getVer()];
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
			turn = !game.isValid(loc, board);
			return !turn;
		}else {
			turn = game.isValid(loc, board);
			return turn;
		}
	}
}
