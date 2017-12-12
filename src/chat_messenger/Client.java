/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_messenger;

import static chat_messenger.chat_fr.def_name;
import static chat_messenger.chat_fr.def_save_location;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Risad
 */
public class Client extends Thread{
    private static String ip, message;
    Boolean ft;
    private static int port;
    private static Socket s;
    private static Socket s1;
    private static int color;
    
    Client(String ip, int port, String message){
        this.ip = ip;
        this.port = port;
        this.message = message;
        try {
            s = new Socket(ip,port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Client(String ip, int port, Boolean ft){
        this.ip = ip;
        this.port = port;
        this.ft = ft;
        try {
            s = new Socket(ip,port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Client(String ip, int port, int color){
        this.ip = ip;
        this.port = port;
        this.color = color;
        try {
            s = new Socket(ip,port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        try {       
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(message);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void file_msg(){
        try {       
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(ft);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void color_msg(){
        try {       
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(color);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void receive_file(){
        InputStream is=null;
        try {
            int filesize=1022386;
            int bytesRead;
            int currentTot = 0;
            Socket socket = new Socket(ip, port+5);
            byte [] bytearray = new byte [filesize];
            is = socket.getInputStream();
            String s = def_save_location+"\\"+def_name;
            FileOutputStream fos = new FileOutputStream(s);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(bytearray,0,bytearray.length);
            currentTot = bytesRead;
            do { bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
            if(bytesRead >= 0) currentTot += bytesRead;
            } while(bytesRead > -1);
            bos.write(bytearray, 0 , currentTot);
            bos.flush();
            bos.close();
            System.out.println("File receive complete");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
