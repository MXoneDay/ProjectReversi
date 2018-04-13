package controller;

import model.GameFW;
import view.*;
import javafx.scene.Scene;

public class PageController {
	private Scene scene;
	private Page hPage = new HomePage(this);
	private Page gPage = new GridPage(this);
	private GameFW gFW = new GameFW();
	
	public PageController() {
		hPage.createPage();
		scene = new Scene(hPage.getPane(), 600, 600);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setGameFW(char type) throws Exception {
		gFW.connectToServer();
		gFW.setGame(type);
		gPage.createPage();
		toGrid();
	}
	
	public void reset() {
		gFW.reset();
	}
	
	public void toHome() {
		scene.setRoot(hPage.getPane());
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
	
	public Object getImage() {
		return gFW.getImage();
	}

	public String getTurntext() {
		return gFW.getTurntext();
	}
	
	public boolean move(int hor, int ver) {
		return gFW.move(hor, ver);
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
}
