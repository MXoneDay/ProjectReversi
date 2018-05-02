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

public class GridPage implements Page{
	private final PageController pc;
	private GridPane gPane;
	
	public GridPage(PageController pc){
		this.pc = pc;
	}
	
	public void createPage() {
		gPane = new GridPane();
		int hor = pc.getHor();
		int ver = pc.getVer();

		GridPane menu = new GridPane();
		Text turn = new Text(" ");
		Button back = new Button("Back");
		Button playerList = new Button("PlayerList");
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
		for(int i = 0; i < ver; i++) {
			for(int j = 0; j < hor; j++) {
				CellPane cp = new CellPane(loc, j, i);
				// from https://stackoverflow.com/questions/27712213/how-do-i-make-a-simple-solid-border-around-a-flowpane-in-javafx/27712713
				cp.setStyle("-fx-border-color: black");
				cp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent me) {
						turn.setText(pc.move(cp.hor, cp.ver));
						//cp.getChildren().add((ImageView) pc.getImage());
						//turn.setText(pc.getTurntext());
					}
				});
				
				pc.setInBoard(cp);
				gPane.add(cp, j, i);
				loc++;
			}
		}
		
		
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				pc.toHome();
				pc.disconnect();
				//pc.getgFW().getDispatcher().disconnect();
			}
		});

		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				try {
					pc.reset();
					//pc.getgFW().getDispatcher().disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		turn.setStyle("-fx-font: 22 arial;");
		
		menu.add(back, 0, 0);
		menu.add(reset, 1, 0);
		menu.add(playerList, 2, 0);

		/*
		int test = hor;
		if(hor > 3) {
			test = hor/3;
		}
		System.out.println(test);
		gPane.add(menu, hor-1, ver, test, 1);*/
		gPane.add(menu, hor-1, ver);
		gPane.add(turn, 0, ver);
	}

	@Override
	public GridPane getPane() {
		return gPane;
	}
}
