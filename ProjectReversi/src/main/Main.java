package main;

public class Main {

	public static void main(String[] args) {
		Connection connection = new Connection();
        System.out.println(connection.startConnection("localhost", 7789));
	}
}
