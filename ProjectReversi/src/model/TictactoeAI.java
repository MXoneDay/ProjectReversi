package model;

public class TictactoeAI implements AI {
	Tictactoe ttt;
	
	TictactoeAI(Tictactoe ttt){
		this.ttt = ttt;
		System.out.println(ttt.getVer());
	}
}
