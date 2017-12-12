/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_messenger;

import static chat_messenger.chat_fr.btn_receive_file;
import static chat_messenger.chat_fr.file_transfer;
import static chat_messenger.chat_fr.set_theme_client;
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
    private static int port;
    chat_fr frame;
    private static String msg;
    private static boolean ft = false;
    private static ServerSocket s1;
    private static ServerSocket s2;
    Socket ss;
    Server(int port, chat_fr frame){
        Server.port = port;
        this.frame = frame;
        try {
            s1 = new ServerSocket(port);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {    
            while((ss=s1.accept())!=null){
                Scanner sc = new Scanner(ss.getInputStream());
                
                if(sc.hasNextBoolean()){
                    ft = sc.nextBoolean();
                    file_transfer = ft;
                    frame.text_area.append("You received a file\n");
                    btn_receive_file.setEnabled(true);
                }
                else if(sc.hasNextInt()){
                    int color = sc.nextInt();
                    set_theme_client(color);
                    frame.text_area.append("Your peer has changed the theme\n");
                }
                else if(sc.hasNextLine()){
                    msg = sc.nextLine();
                    if(msg!=null){
                    frame.text_area.append("Client: " +msg+"\n");
                    }
                }
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void send_file(File file){
        try {
            s2 = new ServerSocket(port+5);
            Socket socket = s2.accept();
            System.out.println("Accepted connection : " + socket);
            File transferFile = file;
            byte [] bytearray = new byte [(int)transferFile.length()];
            FileInputStream fin = new FileInputStream(transferFile);
            BufferedInputStream bin = new BufferedInputStream(fin);
            bin.read(bytearray,0,bytearray.length);
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending Files...");
            os.write(bytearray,0,bytearray.length);
            os.flush(); socket.close();
            System.out.println("File transfer complete");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getMsg(){
        return msg;
    }
}
