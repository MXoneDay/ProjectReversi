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
		gFW.setPageController(this);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public String move(int hor, int ver) {
		return gFW.move(hor, ver, null);
	}
	
	public void setGame(Object game) {//TODO remove
		//gFW.connectToServer();
		gFW.setGame(game);
		gPage.createPage();
		gFW.setup();
		toGrid();
	}

	
	/*
	public void reset() {
		gFW.reset();
	}*/
	
	public void toHome() {
		gFW.disconnect();
		scene.setRoot(hPage.getPane());
	}
  
	public void toPlayerPage(String name, boolean p1Ai, boolean p2Ai) throws Exception {
		gFW.connectToServer(name);
		gFW.setPlayers(p1Ai, p2Ai);

        playerPage.createPage();
        scene.setRoot(playerPage.getPane());
    }
	
	public void toChallengePage() {
		challengePage.createPage();
		scene.setRoot(challengePage.getPane());
	}
	
	public void toPlayerPage() {
		//playerPage.createPage();
		scene.setRoot(playerPage.getPane());
	}

	public void toGrid() {
		scene.setRoot(gPage.getPane());
	}
	
	public int getHor() {
		return gFW.getHor();
	}
	
	public int getVer() {
		return gFW.getHor();
	}
	
	public void setInBoard(Object cp) {
		gFW.setInBoard(cp);
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
