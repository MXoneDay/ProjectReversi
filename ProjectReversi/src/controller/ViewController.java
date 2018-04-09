package controller;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import view.*;

public class ViewController {
	private Scene scene;
	private GridPane homePage = null;
	
	public Scene toHome() {
		if(homePage == null) {
			homePage = new HomePage(this).createPage();
			scene = new Scene(homePage, 600, 600);
			System.out.println("Home created");
		}else {
			scene.setRoot(homePage);
		}
		return scene;
	}
	
	public Scene toGame(char type) {
		scene.setRoot(new GridPage(this, type).createPage());
		System.out.println("Game created");
		return scene;
	}
}
