package model;

import java.io.IOException;
import javafx.application.Platform;
import view.CellPane;

public class GameFW {
	private Board board;
	private int turn = 0; // default -> 0! TODO
	private Game game;
	private char type;
	public boolean waitForMove;
	private Connection connection;
	private CommandDispatcher dispatcher;
    private DotEnv env;
    private String[] players;
    private Player player1, player2;
    
    public GameFW(){
    	try {
            env = new DotEnv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void connectToServer() throws Exception {
		connection = new Connection(this);
		connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
		dispatcher = connection.getDispatcher();
		//dispatcher.login(name);
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
		
		if(type == 'r') {
			game = new Reversi();
			dispatcher.subscribe("Reversi");
		}else if(type == 't') {
			game = new Tictactoe();
			dispatcher.subscribe("Tic-tac-toe");
		}
		else {
			throw new Exception("Not currently supported");
		}
		board = new Board(getVer(), getHor());
	}
	
	public void setup() {
		game.setup(board);
	}
	
	public void reset() {
		try {
			board.reset();
			disconnect();
			connectToServer();
			if(type == 'r') {
				dispatcher.subscribe("Reversi");
			}else if(type == 't') {
				dispatcher.subscribe("Tic-tac-toe");
			}
			game.setup(board);
			turn = 1;
		}
		catch(Exception ex) {
		}
	}
	
	// Set the text for the current player
	public String getTurntext() {
		return game.getTurntext(turn);
	}

	// Function for setting a move this checks if the moves is valid before sending it
	public String move(int hor, int ver) {
        if(turn != 1){
            return "Player: " + turn;
        }

        if(game.isValid(turn, hor, ver, board, false)) {
            CellPane cp = board.getCell(hor, ver);
            cp.filled = turn;
            cp.getChildren().add(game.getImage(turn));
            dispatcher.move(cp.loc);
            setTurn(2);
        }
        return "Player: " + turn;
	}

	public void drawMove(int loc){
 		int newhor = loc % getHor();
        int newver = loc / getVer();

		System.out.println(newhor);
		System.out.println(newver);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				CellPane cp = board.getCell(newhor, newver);
				System.out.println("Cellpane hor, ver: "+newhor+", "+newver);
				System.out.println("CellPane to draw on: " + cp.toString());
				cp.filled = turn;
				cp.getChildren().add(game.getImage(turn));
			}
		});
    }

	public void disconnect() {
		dispatcher.disconnect();
	}
	
    public void setPlayers(String[] players) {
        this.players = players;
    }
    
	public String[] getPlayers() {
		try {
			dispatcher.getPlayers();
			Thread.sleep(1000);
		}
		catch(Exception ex) {
			
		}
		return players;
	}

    public Connection getConnection() {
        return connection;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
