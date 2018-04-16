package model;

import java.io.IOException;

import view.CellPane;

public class GameFW {
	private Board board;
	private int turn = 1; // default -> 0! TODO
	private Game game;
	public String user1;
	public String user2;
	private int mode;
	private char type;
	public boolean waitForMove;
	Connection connection;
	//CommandDispatcher dispatcher;
    DotEnv env;
    String[] players;

    {
        try {
            env = new DotEnv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

	public void connectToServer() throws Exception {
		connection = new Connection(this);
		//connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
		//dispatcher = connection.getDispatcher();
		//dispatcher.login(user1);
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
	public void setGame(char type, Object wait) throws Exception{
		this.type = type;
		mode = (int) wait;
		
		if(type == 'r') {
			game = new Reversi();
			//dispatcher.subscribe("Reversi");
		}else if(type == 't') {
			game = new Tictactoe();
			//dispatcher.subscribe("Tic-tac-toe");
		}
		else {
			throw new Exception("Not currently supported");
		}
		if(mode == 1) {
			waitForMove = false;
		}else if(mode == 2) {
			waitForMove = true;
			game.createAI();
		}else if(mode == 3) {
			waitForMove = true;
		}else if(mode == 4) {
			waitForMove = true;
			game.createAI();
		}
		board = new Board(game.getVer(), game.getHor());
	}
	
	public void reset() {
		try {
			board.reset();
			disconnect();
			connectToServer();
			if(type == 'r') {
				//dispatcher.subscribe("Reversi");
			}else if(type == 't') {
				//dispatcher.subscribe("Tic-tac-toe");
			}
		}
		catch(Exception ex) {
			
		}
	}
	
	// Set the text for the current player
	public String getTurntext() {
		return game.getTurntext(turn);
	}
	
	public String tryMove(int hor, int ver) {
		if(waitForMove && turn == 1) {
			return move(hor, ver);
		}else if(!waitForMove) {
			return move(hor, ver);
		}
		else {
			return "Player: " + turn;
		}
	}

	// Function for setting a move this checks if the moves is valid before sending it
	public String move(int hor, int ver) {
		if(game.isValid(turn, hor, ver, board)) {
			CellPane cp = board.getCell(hor, ver);
			cp.filled = turn;
			cp.getChildren().add(game.getImage(turn));
			//dispatcher.move(cp.loc);
		}
		turn = (turn == 1) ? 2 : 1;
		return "Player: " + turn;
	}
	
	public void disconnect() {
		//dispatcher.disconnect();
	}
	
    public void setPlayers(String[] players) {
        this.players = players;
    }
    
    public void setTurn(int turn) {
    	this.turn = turn;
    }
	
	public String[] getPlayers() {
		try {
			//dispatcher.getPlayers();
			Thread.sleep(1000);
		}
		catch(Exception ex) {
			
		}
		return players;
	}

    public Connection getConnection() {
        return connection;
    }
}
