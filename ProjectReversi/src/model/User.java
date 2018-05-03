package model;

public class User implements Player {
	private String username;
	
	@Override
    public String getName() {
        return username;
    }
}
