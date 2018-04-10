package main;

public class Main {

	public static void main(String[] args) {
		Connection connection = new Connection();
		CommandDispatcher dispatcher = new CommandDispatcher(connection);

        connection.start("localhost", 7789);
		System.out.println("Started connection with server");

		dispatcher.login("richard");
        dispatcher.subscribe("Reversi");
        dispatcher.move(26);
    }
}