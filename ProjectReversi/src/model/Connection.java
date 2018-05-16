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
    GameFW gFW;
    MessageParser parser;
    CommandDispatcher dispatcher = new CommandDispatcher(this);
    
    public Connection(GameFW gFW){
    	this.gFW = gFW;
    }

     public void start (String host, int port) throws Exception {
         try {
        	 parser = new MessageParser(gFW);
             socket = new Socket();
             socket.connect(new InetSocketAddress(host,port), 200);
             input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
                     parser.parse(message);
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
         this.listenerThread.setName("Listening Thread");
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
