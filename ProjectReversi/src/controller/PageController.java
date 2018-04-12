package controller;

import model.GameFW;
import view.*;
import javafx.scene.Scene;

public class PageController {
	private Scene scene;
	private Page hPage = new HomePage(this);
	private Page gPage;
	private GameFW gFW;
	
	public PageController() {
		hPage.createPage();
		scene = new Scene(hPage.getPane(), 600, 600);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setGameFW(char type) throws Exception {
		gFW = new GameFW(type);
		toGrid();
	}
	
	public void toHome() {
		scene.setRoot(hPage.getPane());
	}

	public GameFW getgFW() {
		return gFW;
	}

	public void toGrid() throws Exception{
		gFW.setGame();
		gPage = new GridPage(this);
		gPage.createPage();
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
	
	public boolean move(Object cp) {
		return gFW.move(cp);
	}
	
	public void setBoard(int loc, Object cp) {
		gFW.setBoard(loc, cp);
	}
}
