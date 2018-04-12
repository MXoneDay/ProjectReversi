package model;

import java.io.IOException;
import view.CellPane;


public class GameFW {
	//private HashMap<Integer, CellPane> board = new HashMap<Integer, CellPane>();
	private CellPane[][] board;
	private boolean turn;
	private Game game;
	private final char type;
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
	
	public GameFW(char type){
		this.type = type;
		this.connection = new Connection();
		this.connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
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
	public void setBoard(int loc, Object ocp) {
		CellPane cp = (CellPane) ocp;
		board[cp.ver][cp.hor] = cp;
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
		board = new CellPane[game.getVer()][game.getHor()];
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
	public boolean move(Object ocp) {
		if(turn) {
			turn = !game.isValid(turn, (CellPane) ocp, board);
			return !turn;
		}else {
			turn = game.isValid(turn, (CellPane) ocp, board);
			return turn;
		}
	}
}
