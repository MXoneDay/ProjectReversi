package reversi;

import design.GridFrame;
import javafx.scene.Scene;
import main.Main;

public class Setup {
	public static int hor = 8, ver = 8;
	
	public static Scene setup() {
		System.out.println("Rev: " + Main.usernm + " : " + Main.mode);
		// midden wit zwart, daaronder zwart wit
		Scene scene = new GridFrame().start(hor, ver);
		return scene;
	}
}
