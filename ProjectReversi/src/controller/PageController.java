package controller;

import model.GameFW;
import view.*;
import javafx.scene.Scene;

public class PageController {
	private Scene scene;
	private Page hPage = new HomePage(this);
	private Page playerPage = new PlayerPage(this);
	private Page challengePage = new ChallengePage(this);
	private Page gPage = new GridPage(this);
	private GameFW gFW = new GameFW();

	public PageController() {
		hPage.createPage();
		scene = new Scene(hPage.getPane(), 600, 600);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setGameFW(char type, Object wait) throws Exception {
		gFW.connectToServer();
		gFW.setGame(type, wait);
		gPage.createPage();
		gFW.setup();
		toGrid();
	}

	public void reset() {
		gFW.reset();
	}
	
	public void toHome() {
		scene.setRoot(hPage.getPane());
	}
  
	public void toPlayerPage(String username) throws Exception {
        gFW.connectToServer();
        gFW.login(username);
        playerPage.createPage();
        scene.setRoot(playerPage.getPane());
    }

    public void backToPlayerPage() throws Exception {
        scene.setRoot(playerPage.getPane());
    }

	public void toChallengePage() {
		challengePage.createPage();
		scene.setRoot(challengePage.getPane());
	}

	public void toGrid() throws Exception{
		scene.setRoot(gPage.getPane());
	}
	
	public int getHor() {
		return gFW.getHor();
	}
	
	public int getVer() {
		return gFW.getHor();
	}
	
	public String getTurntext() {
		return gFW.getTurntext();
	}
	
	public String move(int hor, int ver) {
		return gFW.tryMove(hor, ver);
	}
	
	public void setInBoard(Object cp) {
		gFW.setInBoard(cp);
	}
	
	public void setUser1(String user1) {
		gFW.user1 = user1;
	}
	
	public void setUser2(String user2) {
		gFW.user2 = user2;
	}
	
	public String[] getPlayers() {
		return gFW.getPlayers();
	}

	public void disconnect() {
		gFW.disconnect();
	}

	public void startChallenge(String username, String game){
		gFW.startChallenge(username, game);
	}
}
