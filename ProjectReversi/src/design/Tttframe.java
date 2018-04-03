package design;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tttframe {

    private Tile[][] board = new Tile[3][3];
    private Pane root = new Pane();

    private Parent createContent() {
        root.setPrefSize(600, 600);

        // A loop that creates a 3 by 3 field with tiles
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }
        return root;
    }

    public Scene start() throws Exception {
    	Scene scene = new Scene(createContent());
    	return scene;
    }

    // Tile is a block of a ... size that is used to build a play board
    private class Tile extends StackPane {
        public Tile() {
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            setAlignment(Pos.CENTER);
            getChildren().addAll(border );
        }
    }
}

