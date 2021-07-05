/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deathgear.chatmessenger;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author Risad
 */
public class Client_Voice {
    public static boolean calling = false;
    public int port_server;
    public String add_server;
    TargetDataLine audio_in;
    static Client_Player_Thread r;
    
    Client_Voice(String ip, int port){
        port_server = port;
        add_server = ip;
    }
    
    public void start(){
        init_audio();
    }
    
    public static void stop(){
        calling = false;
        r.dout.close();
    }
    
    public static AudioFormat getAudioFormat(){
        float sampleRate = 8000.0F;
        int sampleSizeInBits = 16;
        int channel = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channel, signed, bigEndian);
    }
    
    public void init_audio(){
        try{
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if(! AudioSystem.isLineSupported(info)){
                System.out.println("Not Supported");
                System.exit(0);
            }
            audio_in = (TargetDataLine) AudioSystem.getLine(info);
            audio_in.open(format);
            audio_in.start();
            r = new Client_Player_Thread();
            InetAddress inet = InetAddress.getByName(add_server);
            r.audio_in = audio_in;
            r.dout = new DatagramSocket();
            r.server_ip = inet;
            r.server_port = port_server;
            calling = true;
            r.start();
//            btn_start.setEnabled(false);
//            btn_stop.setEnabled(true);
        } catch (LineUnavailableException | UnknownHostException | SocketException ex) {
            Logger.getLogger(Client_Voice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
