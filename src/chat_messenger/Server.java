/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_messenger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Risad
 */
public class Server extends Thread{
    int port;
    chat_fr frame;
    private static String msg;
    Server(int port, chat_fr frame){
        this.port = port;
        this.frame = frame;
    }

    @Override
    public void run() {
        try {
            ServerSocket s1 = new ServerSocket(port);
            Socket ss;
            while((ss=s1.accept())!=null){
                Scanner sc = new Scanner(ss.getInputStream());
                msg = sc.nextLine();
                if(msg!=null){
                    frame.text_area.append("Client: " +msg+"\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getMsg(){
        return msg;
    }
}
