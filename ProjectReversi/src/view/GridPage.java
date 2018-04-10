package view;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import controller.PageController;
import javafx.event.ActionEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

public class GridPage implements Page{
	private final PageController pc;
	private int hor, ver;
	private GridPane gPane = new GridPane();
	
	public GridPage(PageController pc){
		this.pc = pc;
	}
	
	public void createPage() {
		hor = pc.getHor();
		ver = pc.getVer();
		
		Text turn = new Text(" ");
		Text scoreboard = new Text(" ");
		//Text text = new Text("test");
		GridPane menu = new GridPane();
		Button back = new Button("Back");
		Button reset = new Button("Reset");
		
		ColumnConstraints cHor = new ColumnConstraints(hor);
		cHor.setPercentWidth(100.0/hor);
		RowConstraints rVer = new RowConstraints(ver);
		rVer.setPercentHeight(90.0/ver);
		
		for(int i = 0; i < hor; i++) {
			gPane.getColumnConstraints().add(cHor);
		}
		for(int i = 0; i < ver; i++) {
			gPane.getRowConstraints().add(rVer);
		}
		
		int loc = 0;
		for(int i = 0; i < hor; i++) {
			for(int j = 0; j < ver; j++) {
				CellPane cellPane = new CellPane(loc);
				loc++;
				// from https://stackoverflow.com/questions/27712213/how-do-i-make-a-simple-solid-border-around-a-flowpane-in-javafx/27712713
				cellPane.setStyle("-fx-border-color: black");
				cellPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent me) {
						//pc.getImage();
						if(pc.move(cellPane.loc)) {
							cellPane.getChildren().add((ImageView)pc.getImage());
						}
						/*
						if(game.move(cellPane.hor, cellPane.ver)) {
							cellPane.getChildren().add(game.getImage());
						}

						turn.setText(game.getTurntext());
						scoreboard.setText(game.getScore());*/
					}
				});
				gPane.add(cellPane, i, j);
			}
		}
		
		
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				pc.toHome();
			}
		});
		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				//pc.setGame(type);
			}
		});

		turn.setStyle("-fx-font: 22 arial;");
		scoreboard.setStyle("-fx-font: 22 arial;");
		
		menu.add(back, 0, 0);
		menu.add(reset, 1, 0);
		/*
		int test = hor;
		if(hor > 3) {
			test = hor/3;
		}
		System.out.println(test);
		gridPane.add(menu, hor-1, ver, test, 1);*/
		gPane.add(menu, hor-1, ver);
		gPane.add(turn, 0, ver);
		gPane.add(scoreboard, 1, ver);
	}

	@Override
	public GridPane getPane() {
		return gPane;
	}
}
