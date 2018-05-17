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
    private User[] users = new User[2];
    private PageController pageController;
    private boolean p1ai;
    String username;
    
    public GameFW(){
    	try {
            env = new DotEnv();
        } catch (IOException e) {
        }
    }

	public void connectToServer(String name) throws Exception {
		connection = new Connection(this);
		connection.start(env.get("HOST"), Integer.parseInt(env.get("PORT")));
		dispatcher = connection.getDispatcher();
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
	public void setGame(Object game) {
		this.game = (Game) game;
		board = new Board(getVer(), getHor());
	}
	
	
	public void createAi(String pToMove, String opponent) {
		users[1] = new Player(opponent);
		if(p1ai) {
			AI ai = game.createAI(this);
			ai.setName(username);
			users[0] = ai;
		}else {
			users[0] = new Player(username);
		}
		
		if(pToMove.equals(opponent)) {
			turn = 1;
			users[1].setTurn(0);
			users[0].setTurn(1);
			System.out.println("yesy");
		}
		else if(pToMove.equals(users[0].getName())){
			turn = 0;
			users[1].setTurn(1);
			users[0].setTurn(0);
			System.out.println("yes");
		}
	}
	
	public void setup() {
		game.setup(board);
	}
	
	// Set the text for the current player
	public String getTurntext() {
		return "Turn: " + users[turn].getName();
	}

	// Function for setting a move this checks if the moves is valid before sending it
	public String move(int hor, int ver, User user) {
    	System.out.println("Move: " + hor + "-" + ver + " Turn: " + turn + " Fill: " + board.getCell(hor, ver).filled);
    	if(user == null) {
			user = users[0];
		}
		if(user.getTurn() != turn) {
			return "for the gods";
		}
        if(game.isValid(users, turn, hor, ver, board, true)) {
        	dispatcher.move(board.getCell(hor, ver).loc);
			if(turn == users[0].getTurn()) {
				turn = users[1].getTurn();
			}
        }else {
        	System.out.println("not valid");
        }
        return "Player: " + turn;
	}

	public void drawMove(int loc, String player){
 		int newhor = loc % getHor();
        int newver = loc / getVer();
        User playr = null;
        for(User p : users) {
        	if(player.equals(p.getName())){
        		playr = p;
        	}
        }
        
        final int ftturn = playr.getTurn();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				game.isValid(users, ftturn, newhor, newver, board, false);
				CellPane cp = board.getCell(newhor, newver);
				cp.filled = ftturn;
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
	
	public User[] getUsers() {
		return users;
	}

    public Connection getConnection() {
        return connection;
    }

	public void setTurn() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				}catch (Exception ex){
					
				}
				User user = users[0];
				turn = user.getTurn();
				if (users[0] instanceof AI) {
					AI userai = (AI) user;
					userai.doMove();
				}
			}
		});
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
	
	public Board getBoard() {
		return board;
	}
	
	public void setAi(boolean p1) {
		p1ai = p1;
	}
}
