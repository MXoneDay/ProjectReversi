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
			gPage = new GridPage(this);
			gPage.createPage();
			toGrid();
	}
	/*
	public void setGame(char type) {
		gPage.setType(type);
		toGrid();
	}*/
	
	public void toHome() {
		scene.setRoot(hPage.getPane());
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
	
	public Object getImage() {
		return gFW.getImage();
	}
	
	public boolean move(int loc) {
		return gFW.move(loc);
	}
}
