package model;

import java.io.IOException;
import controller.PageController;
import javafx.application.Platform;
import view.CellPane;

public class GameFW {
	private Board board;
	private int turn;
	private Game game;
	private Connection connection;
	private CommandDispatcher dispatcher;
    private DotEnv env;
    private String[] playerlist;
    private Player[] players = new Player[2];
    private PageController pageController;
    String username;
    
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
		players[0] = new Player(name);
		dispatcher.login(name);
		this.username = name;
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
		players[1] = new Player(oppenent);
		board = new Board(getVer(), getHor());
		
		if(pToMove.equals(oppenent)) {
			turn = 1;
			players[1].setTurn(0);
			players[0].setTurn(1);
			//players[1].setImageView(this.game.getImage(true));
			//players[0].setImageView(this.game.getImage(false));
		}
		else if(pToMove.equals(players[0].getName())){
			turn = 0;
			players[1].setTurn(1);
			players[0].setTurn(0);
			/*
			players[1].setImageView(this.game.getImage(false));
			players[0].setImageView(this.game.getImage(true));*/
		}
		System.out.println("1: " + players[0] + " 2: " + players[1] + " m: " + pToMove);
	}
	
	public void setup() {
		game.setup(board, players);
	}
	
	// Set the text for the current player
	public String getTurntext() {
		return "Turn: " + players[turn].getName();
	}

	// Function for setting a move this checks if the moves is valid before sending it
	public String move(int hor, int ver, Player player) {
		if(player == null) {
			player = players[0];
		}
		for(int i = 0; i < players.length; i++) {
			if(player == players[i]) {
				if(turn != i) {
					return "Turn: " + players[turn].getName();
				}
			}
		}
        if(game.isValid(players, turn, hor, ver, board, true)) {
        	System.out.println("Move: " + hor + "-" + ver + " " + turn + " " + board.getCell(hor, ver).filled);
        	dispatcher.move(board.getCell(hor, ver).loc);
        	turn = 1;
        }
        return "Player: " + turn;
	}

	public void drawMove(int loc, String player){
 		int newhor = loc % getHor();
        int newver = loc / getVer();
        Player playr = null;
        for(Player p : players) {
        	if(player.equals(p.getName())){
        		playr = p;
        	}
        }/*
        for(int i = 0; i < players.length; i++) {
			if(player.equals(players[i].getName())) {
				tturn = i;
			}
		}*/
        
        final int ftturn = playr.getTurn();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				game.isValid(players, ftturn, newhor, newver, board, false);
				CellPane cp = board.getCell(newhor, newver);
				cp.filled = players[ftturn].getName();
				cp.getChildren().add(game.getImage(ftturn));
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
        turn = 0;
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

	public String getUsername() {
		return username;
	}
}
