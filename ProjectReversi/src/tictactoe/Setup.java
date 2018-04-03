package tictactoe;

import main.Main;
import design.GridFrame;
import javafx.scene.layout.*;

public class Setup {
	public static int hor = 3, ver = 3;
	
	public static GridPane setup() {
		System.out.println("TTT: " + Main.usernm + " : " + Main.mode);
		return new GridFrame().start(hor, ver);
	}
}
