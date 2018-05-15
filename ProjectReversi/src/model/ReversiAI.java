package model;

public class ReversiAI implements User, AI {
	Reversi rev;
	
	ReversiAI(Reversi rev){
		this.rev = rev;
		System.out.println("made it");
	}

	@Override
	public void setTurn(int turn) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getTurn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
