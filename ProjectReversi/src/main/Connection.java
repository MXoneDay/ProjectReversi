package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection {
    boolean connected = false;

     public boolean startConnection(String host, int port){
         try {
             Socket clientSocket = new Socket(host, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader serverOutput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             this.connected = true;
         } catch(IOException exception) {
            this.connected = false;
         }

         return this.connected;
     }
}
