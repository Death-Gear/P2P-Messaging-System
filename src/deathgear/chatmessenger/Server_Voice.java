/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deathgear.chatmessenger;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Risad
 */

public class Server_Voice {
    public static boolean calling = false;
    public SourceDataLine audio_out;
    public int port;
    static Server_Player_Thread p;
    Server_Voice(int port){
        this.port = port;
    }
    
    public void start(){
        init_audio();
    }
    
    public static void stop(){
        calling = false;
        p.din.close();
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
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info_out = new DataLine.Info(SourceDataLine.class, format);
            if(!AudioSystem.isLineSupported(info_out)){
                System.out.println("Not supported");
                System.exit(0);
            }
            audio_out = (SourceDataLine) AudioSystem.getLine(info_out);
            audio_out.open(format);
            audio_out.start();
            p = new Server_Player_Thread();
            p.din = new DatagramSocket(port);
            p.audio_out = audio_out;
            calling = true;
            p.start();
//            btn_start.setEnabled(false);
//            btn_stop.setEnabled(true);
        } catch (LineUnavailableException | SocketException ex) {
            Logger.getLogger(Server_Voice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
