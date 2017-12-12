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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Risad
 */
public class Chat_Messenger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        chat_fr frame = new chat_fr();
        frame.setTitle("P2P Chat Messenger");
        
        text_area.setEditable(false);
        
        btn_receive_file.setEnabled(false);
        btn_send_file.setEnabled(false);
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenu edit = new JMenu("Edit");
        mb.add(edit);
        JMenuItem attach_file = new JMenuItem("Attach File");
        file.add(attach_file);
        JMenuItem set_default = new JMenuItem("Set Default Save Location");
        file.add(set_default);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        JMenuItem set_theme = new JMenuItem("Set Theme");
        edit.add(set_theme);
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
        set_theme.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
                 int color_int = newColor.getRGB();
                 set_theme(color_int);
            }
            
        });
        
        frame.setJMenuBar(mb);
        frame.setVisible(true);
    }
    
}
