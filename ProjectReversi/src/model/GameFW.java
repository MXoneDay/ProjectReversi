package model;

import java.io.IOException;


public class GameFW {
	private Board board;
	private int turn = 1; // default -> 0! TODO
	private Game game;
	public String user1;
	public String user2;
	Connection connection;
	CommandDispatcher dispatcher;
    DotEnv env;

    {
        try {
            env = new DotEnv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void connectToServer() throws Exception {
		connection = new Connection();
		connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
		dispatcher = connection.getDispatcher();
		dispatcher.login(user1);
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
	public void setInBoard(Object ocp) {
		board.setInBoard(ocp);
	}

	// If the game is not supported by the client it will throw an execption
	public void setGame(char type) throws Exception{
		if(type == 'r') {
			game = new Reversi();
			//dispatcher.subscribe("Tic-tac-toe");
		}else if(type == 't') {
			game = new Tictactoe();
			//dispatcher.subscribe("Reversi");
		}
		else {
			throw new Exception("Not currently supported");
		}
		board = new Board(game.getVer(), game.getHor());
	}
	
	public void reset() {
		board.reset();
		//dispatcher.disconnect();
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
	public boolean move(int hor, int ver) {
		if(game.isValid(turn, hor, ver, board)) {
			board.getCell(hor, ver).filled = (turn == 1) ? 1 : 2;
			turn = (turn == 1) ? 2 : 1;
			//dispatcher.move(board.getCell(hor, ver).loc);
			return true;
		}else {
			return false;
		}
	}
}
