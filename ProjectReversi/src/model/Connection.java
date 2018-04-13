package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class Connection {
    boolean connected = false;
    BufferedReader input;
    PrintWriter output;
    Socket socket;
    Thread listenerThread;
    GameFW gf;
    MessageParser parser;
    CommandDispatcher dispatcher = new CommandDispatcher(this);

     public void start (String host, int port) throws Exception {
         try {
        	 
        	 System.out.println("sofar1");
             socket = new Socket();
             socket.connect(new InetSocketAddress(host,port), 200);
             System.out.println("sofar2");
             input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             System.out.println("sofar3");
             output = new PrintWriter(socket.getOutputStream(), true);
             connected = true;
             listen();
         } catch (IOException exception) {
        	 throw new IOException("No connection to server!");
            //this.connected = false;
         }
     }


     public void listen() {
         Runnable runnable = () -> {
             while (this.connected) {
                 try {
                    String message = this.input.readLine();

                    if (message == null) { // server disconnected
                        this.connected = false;
                        message = "disconnect";
                        close();
                    }

                    this.parser.parse(message);
                 } catch (SocketException exception) {
                    if (exception.getMessage().equals("Connection reset")) {
                        this.connected = false;
                        // TODO: send disconnect command to the server
                        close();
                    }
                 } catch (IOException exception) {
                     exception.printStackTrace();
                 }
             }
         };

         this.listenerThread = new Thread(runnable);
         this.listenerThread.start();
     }

     public void close() {
         try {
             this.input.close();
             this.output.close();
             this.socket.close();
             this.input = null;
             this.output = null;
             this.socket = null;
         } catch (IOException exception) {
             exception.printStackTrace();
         }
     }

    public CommandDispatcher getDispatcher() {
        return dispatcher;
    }

    public boolean isConnected(){
         return this.connected;
    }

    public void send(String message) {
        this.output.println(message);
     }
}
