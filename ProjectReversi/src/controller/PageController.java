package controller;

import model.GameFW;
import view.*;
import javafx.scene.Scene;

public class PageController {
	private Scene scene;
	private Page hPage = new HomePage(this);
	private Page playerPage = new PlayerPage(this);
	private Page gPage = new GridPage(this);
	private GameFW gFW = new GameFW();
	
	public PageController() {
		hPage.createPage();
		scene = new Scene(hPage.getPane(), 600, 600);
		try {
			gFW.connectToServer();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setGameFW(char type, Object wait) throws Exception {//TODO remove
		//gFW.connectToServer();
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
  
	public void toPlayerPage(String name, boolean p1Ai, boolean p2Ai) {//TODO remove, outdated
		//gFW.connectToServer();
        playerPage.createPage(name, p1Ai, p2Ai);
        scene.setRoot(playerPage.getPane());
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
	
	public void setInBoard(Object cp) {
		gFW.setInBoard(cp);
	}
	
	public String[] getPlayers() {
		return gFW.getPlayers();
	}
	
	public void disconnect() {
		gFW.disconnect();
	}
}
