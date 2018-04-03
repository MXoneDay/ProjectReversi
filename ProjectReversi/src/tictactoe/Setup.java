package tictactoe;

import main.Main;
import design.GridFrame;
import javafx.scene.*;

public class Setup {
	public static int hor = 3, ver = 3;
	
	public static Scene setup() {
		System.out.println("TTT: " + Main.usernm + " : " + Main.mode);
		Scene scene = new GridFrame().start(hor, ver);
		return scene;
	}
}
