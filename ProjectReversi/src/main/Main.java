package main;

public class Main {

	public static void main(String[] args) {
		Connection connection = new Connection();
        System.out.println(connection.start("localhost", 7789));
		System.out.println("Started connection with server");
		connection.send("login sampleusername");
	}
}
