/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_messenger;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Risad
 */
public class Client extends Thread{
    String ip, message;
    int port;
    
    Client(String ip, int port, String message){
        this.ip = ip;
        this.port = port;
        this.message = message;
    }
    @Override
    public void run() {
        try {
            Socket s = new Socket(ip,port);
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(message);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
