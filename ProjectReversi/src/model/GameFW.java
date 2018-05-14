package model;

import java.io.IOException;
import controller.PageController;
import javafx.application.Platform;
import view.CellPane;

public class GameFW {
	private Board board;
	private int turn = 0;
	private Game game;
	private Connection connection;
	private CommandDispatcher dispatcher;
    private DotEnv env;
    private String[] players;
    private String user1, user2;
    PageController pageController;
    
    public GameFW(){
    	try {
            env = new DotEnv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void connectToServer(String name) throws Exception {
		connection = new Connection(this);
		connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
		dispatcher = connection.getDispatcher();
		user1 = name;
		dispatcher.login(name);
	}

	public void login(String username){
        dispatcher.login(username);
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
	public void setGame(Object game, String pToMove, String oppenent) {
		this.game = (Game) game;
		user2 = oppenent;
		board = new Board(getVer(), getHor());
		if(pToMove == oppenent) {
			turn = 2;
		}
		else if(pToMove == user1){
			turn = 1;
		}
		System.out.println("1: " + user1 + " 2: " + user2 + " m: " + pToMove);
	}
	
	public void setup() {
		game.setup(board);
	}
	
	// Set the text for the current player
	public String getTurntext() {
		return game.getTurntext(turn);
	}

	// Function for setting a move this checks if the moves is valid before sending it
	public String move(int hor, int ver) {
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

    public void startChallenge(String username, String game){
        dispatcher.challenge(username, game);
    }

	public void setPageController(PageController pageController) {
		this.pageController = pageController;
	}

	public PageController pageController(){
    	return this.pageController;
	}

	public void acceptChallenge(String challengeNumber){
		dispatcher.acceptChallenge(challengeNumber);
	}
}
