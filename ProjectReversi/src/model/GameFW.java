package model;

import java.util.HashMap;

import controller.PageController;
import view.CellPane;


public class GameFW {
	private HashMap<Integer, CellPane> board = new HashMap<Integer, CellPane>();
	//private CellPane[] board2;
	private boolean turn;
	private Game game;
	private final char type;
	Connection connection;
	CommandDispatcher dispatcher;
	
	public GameFW(char type){
		this.type = type;
		this.connection = new Connection();
		this.connection.start("145.37.172.178", 7789);
		this.dispatcher = connection.getDispatcher();
	}

	public CommandDispatcher getDispatcher() {
		return dispatcher;
	}

	// Get method for the value of the Horizontal value / X-value
	public int getHor() {
		return game.getHor();
	}

	// Get method for the value of the Vertical value / Y-value
	public int getVer() {
		return game.getVer();
	}

	// Set the cellpanes on locations with the board so it creates a playable board
	public void setBoard(int loc, Object cp) {
		board.put(loc, (CellPane) cp);
	}

	// If the game is not supported by the client it will throw a execption
	public void setGame() throws Exception{
		if(type == 'r') {
			game = new Reversi();
		}else if(type == 't') {
			game = new Tictactoe();
		}
		else {
			throw new Exception("Not currently supported");
		}
		turn = true;
	}

	// A image from a game piece for the current player
	public Object getImage() {
		return game.getImage(turn);
	}

	// Set the text for the current player
	public String getTurntext() {
		return game.getTurntext(turn);
	}

	// Function for setting a move this checks if the moves is valid before sending it
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
