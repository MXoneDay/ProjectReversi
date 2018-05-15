package model;

import java.io.IOException;
import controller.PageController;
import javafx.application.Platform;
import view.CellPane;

public class GameFW {
	private Board board;
	private Player turn = null;
	private Game game;
	private Connection connection;
	private CommandDispatcher dispatcher;
    private DotEnv env;
    private String[] playerlist;
    private Player user1, user2;
    private Player[] players = new Player[10]; // TODO implememnt
    private PageController pageController;
    
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
		user1 = new Player(name);
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
		user2 = new Player(oppenent);
		board = new Board(getVer(), getHor());
		
		if(pToMove == oppenent) {
			turn = user2;
			user2.setImageView(this.game.getImage(true));
			user1.setImageView(this.game.getImage(false));
		}
		else if(pToMove == user1.getName()){
			turn = user1;
			user2.setImageView(this.game.getImage(false));
			user1.setImageView(this.game.getImage(true));
		}
		System.out.println("1: " + user1 + " 2: " + user2 + " m: " + pToMove);
	}
	
	public void setup() {
		game.setup(board);
	}
	
	// Set the text for the current player
	public String getTurntext() {
		//return game.getTurntext(turn); TODO
		return "TODO";
	}

	// Function for setting a move this checks if the moves is valid before sending it
	public String move(int hor, int ver) {
		if(turn == user2) {
			return "Player: " + turn;
		}
        if(game.isValid(turn, hor, ver, board, false)) {
        	System.out.println("Move: " + hor + "-" + ver + " " + turn + " " + board.getCell(hor, ver).filled);
            CellPane cp = board.getCell(hor, ver);
            cp.filled = turn.getName();
            cp.getChildren().add(turn.getImageView());
            dispatcher.move(cp.loc);
            turn = user2;
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
				cp.filled = turn.getName();
				//cp.getChildren().add(game.getImage(turn)); TODO
			}
		});
    }

	public void disconnect() {
		dispatcher.disconnect();
	}

    public void setPlayers(String[] players) {
        this.playerlist = players;
    }
    
	public String[] getPlayers() {
		try {
			dispatcher.getPlayers();
			Thread.sleep(1000);
		}
		catch(Exception ex) {
		}
		return playerlist;
	}

    public Connection getConnection() {
        return connection;
    }
    
    public void setTurn() {
        turn = user1;
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
