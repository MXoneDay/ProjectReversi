package controller;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import view.*;

public class ViewController {
	private static Scene scene;
	private static GridPane homePage = null;
	
	public static Scene toHome() {
		if(homePage == null) {
			homePage = new HomePage().createPage();
			scene = new Scene(homePage, 600, 600);
			System.out.println("Home created");
		}else {
			scene.setRoot(homePage);
		}
		return scene;
	}
	
	public static Scene toGame(char type) {
		scene.setRoot(new GridPage(type).createPage());
		System.out.println("Game created");
		return scene;
	}
}
