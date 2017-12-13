/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_messenger;

import static chat_messenger.chat_fr.text_area;
import static chat_messenger.chat_fr.attachFile;
import static chat_messenger.chat_fr.btn_receive_file;
import static chat_messenger.chat_fr.btn_send_file;
import static chat_messenger.chat_fr.set_default_save_location;
import static chat_messenger.chat_fr.set_theme;
import static chat_messenger.chat_fr.save_message;
import static chat_messenger.chat_fr.call_voice_client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Risad
 */
public class Chat_Messenger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Chat_Messenger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Chat_Messenger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Chat_Messenger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Chat_Messenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chat_fr frame = new chat_fr();
        frame.setTitle("P2P Chat Messenger");
        frame.setDefaultLookAndFeelDecorated(true);
        
        text_area.setEditable(false);
        
        btn_receive_file.setEnabled(false);
        btn_send_file.setEnabled(false);
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenu edit = new JMenu("Edit");
        mb.add(edit);
        JMenu call = new JMenu("Call");
        mb.add(call);
        JMenuItem attach_file = new JMenuItem("Attach File");
        file.add(attach_file);
        JMenuItem set_default = new JMenuItem("Set Default Save Location");
        file.add(set_default);
        JMenuItem save_msg = new JMenuItem("Save Message History");
        file.add(save_msg);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        JMenuItem set_theme = new JMenuItem("Set Theme");
        edit.add(set_theme);
        JMenuItem voice_call = new JMenuItem("Start Voice Call");
        call.add(voice_call);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        attach_file.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    System.out.println("Selected file: " + file.getAbsolutePath());
                    attachFile(file);
                    btn_send_file.setEnabled(true);
                }
                
            }
        });
        set_default.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fc.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    File folder = fc.getSelectedFile();
                    String s = folder.getAbsolutePath();
                    System.out.println("Selected file: " + s);
                    set_default_save_location(s);
                }
            }
            
        });
        save_msg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                save_message();
            }
        });
        set_theme.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
                 int color_int = newColor.getRGB();
                 set_theme(color_int);
            }
            
        });
        voice_call.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                call_voice_client();
            }
        });
        
        frame.setJMenuBar(mb);
        frame.setVisible(true);
    }
    
}
