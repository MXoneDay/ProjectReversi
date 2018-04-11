package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Connection {
    boolean connected = false;
    BufferedReader input;
    PrintWriter output;
    Socket socket;
    Thread listenerThread;
    MessageParser parser = new MessageParser();
    CommandDispatcher dispatcher = new CommandDispatcher(this);

     public void start (String host, int port) {
         try {
             this.socket = new Socket(host, port);
             this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             this.output = new PrintWriter(socket.getOutputStream(), true);
             this.connected = true;
             listen();
         } catch (IOException exception) {
            this.connected = false;
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
