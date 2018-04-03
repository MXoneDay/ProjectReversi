package reversi;

import design.GridFrame;
import main.Main;
import javafx.scene.layout.*;

public class Setup {
	public static int hor = 8, ver = 8;
	
	public static GridPane setup() {
		System.out.println("Rev: " + Main.usernm + " : " + Main.mode);
		// midden wit zwart, daaronder zwart wit
		return new GridFrame().start(hor, ver);
	}
}
