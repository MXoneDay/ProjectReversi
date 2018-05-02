package model;

public class TictactoeAI implements AI {
	Tictactoe ttt;
	
	TictactoeAI(Tictactoe ttt){
		this.ttt = ttt;
		System.out.println(ttt.getVer());
	}
	
	public void tryMove() {
		//TODO move at random till success
	}

	@Override
	public void doMove() {
		// TODO Auto-generated method stub
		
	}
}
