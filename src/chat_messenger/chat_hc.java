/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_messenger;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Risad
 */
public class chat_hc extends javax.swing.JFrame {

    /**
     * Creates new form chat_hc
     */
    public static boolean file_transfer = false;
    static File file;
    public static String def_save_location = "D:";
    public static String def_name = "copy.txt";
    public static int def_color;
    public chat_hc() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dst_port = new javax.swing.JTextField();
        text_filePath = new javax.swing.JTextField();
        btn_connect = new javax.swing.JButton();
        btn_receive_file = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        my_port = new javax.swing.JTextField();
        btn_send_file = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area = new javax.swing.JTextArea();
        text_msg = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IP Address");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        ip.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ip.setForeground(new java.awt.Color(255, 255, 255));
        ip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip.setText("127.0.0.1");
        ip.setOpaque(false);
        ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipActionPerformed(evt);
            }
        });
        getContentPane().add(ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 140, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Destination Port");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        dst_port.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        dst_port.setForeground(new java.awt.Color(255, 255, 255));
        dst_port.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dst_port.setText("8878");
        dst_port.setOpaque(false);
        getContentPane().add(dst_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 70, 30));

        text_filePath.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        text_filePath.setForeground(new java.awt.Color(255, 255, 255));
        text_filePath.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_filePath.setText("File Path");
        text_filePath.setOpaque(false);
        getContentPane().add(text_filePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 140, -1));

        btn_connect.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_connect.setForeground(new java.awt.Color(255, 255, 255));
        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/Webp.net-resizeimage (6).png"))); // NOI18N
        btn_connect.setText("CONNECT ");
        btn_connect.setBorderPainted(false);
        btn_connect.setContentAreaFilled(false);
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });
        getContentPane().add(btn_connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        btn_receive_file.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_receive_file.setForeground(new java.awt.Color(255, 255, 255));
        btn_receive_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/Webp.net-resizeimage (4).png"))); // NOI18N
        btn_receive_file.setText("Receive File");
        btn_receive_file.setBorderPainted(false);
        btn_receive_file.setContentAreaFilled(false);
        btn_receive_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_receive_fileActionPerformed(evt);
            }
        });
        getContentPane().add(btn_receive_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("My Port");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        my_port.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        my_port.setForeground(new java.awt.Color(255, 255, 255));
        my_port.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        my_port.setText("8877");
        my_port.setOpaque(false);
        getContentPane().add(my_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, 30));

        btn_send_file.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_send_file.setForeground(new java.awt.Color(255, 255, 255));
        btn_send_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/Webp.net-resizeimage (3).png"))); // NOI18N
        btn_send_file.setText("Send File");
        btn_send_file.setBorderPainted(false);
        btn_send_file.setContentAreaFilled(false);
        btn_send_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_send_fileActionPerformed(evt);
            }
        });
        getContentPane().add(btn_send_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 92, 110, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/background.png"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        jScrollPane1.setOpaque(false);

        text_area.setColumns(20);
        text_area.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        text_area.setRows(5);
        jScrollPane1.setViewportView(text_area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 400, 310));

        text_msg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        text_msg.setForeground(new java.awt.Color(255, 255, 255));
        text_msg.setText(" ");
        text_msg.setToolTipText("");
        text_msg.setOpaque(false);
        getContentPane().add(text_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 320, 40));

        btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/Webp.net-resizeimage (5).png"))); // NOI18N
        btn_send.setBorderPainted(false);
        btn_send.setContentAreaFilled(false);
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });
        getContentPane().add(btn_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 410, 60, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 452, 320, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 190, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/Webp.net-resizeimage (7).png"))); // NOI18N
        jLabel4.setText("P2P MESSENGER");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 190, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_messenger/bgta.png"))); // NOI18N
        jLabel6.setText(" ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 420, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        Server server = new Server(Integer.parseInt(my_port.getText()), this);
        server.start();
        btn_connect.setEnabled(false);
    }//GEN-LAST:event_btn_connectActionPerformed

    private void ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipActionPerformed

    private void btn_send_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_send_fileActionPerformed
        Client client = new Client(ip.getText(), Integer.parseInt(dst_port.getText()), true);
        client.file_msg();
        File_Sender fs = new File_Sender(file);
        fs.start();
    }//GEN-LAST:event_btn_send_fileActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        Client client = new Client(ip.getText(), Integer.parseInt(dst_port.getText()), text_msg.getText());
        client.start();
        text_area.append("Me: "+text_msg.getText()+ "\r\n");
        text_msg.setText("");
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_receive_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_receive_fileActionPerformed
        if(file_transfer){
            //System.out.println("Receiving file");
            File_Receiver fr = new File_Receiver();
            fr.start();
        }
    }//GEN-LAST:event_btn_receive_fileActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void attachFile(File file){
        chat_hc.file = file;
        text_filePath.setText(file.getAbsolutePath());
    }
    public static void set_default_save_location(String loc){
        def_save_location = loc;
    }
    public static void set_theme(int color){
        def_color = color;
        Color clr = new Color(def_color);
        text_area.setBackground(clr);
        //System.out.println(def_color);
        Client client = new Client(ip.getText(), Integer.parseInt(dst_port.getText()), def_color);
        client.color_msg();
    }
    public static void set_theme_client(int color){
        def_color = color;
        Color clr = new Color(def_color);
        text_area.setBackground(clr);
    }
    public static void call_voice_client(){
        Client client = new Client(ip.getText(), Integer.parseInt(dst_port.getText()), true);
        client.voice_msg();
    }
    public static void call_voice_server(){
        Client client = new Client(ip.getText(), Integer.parseInt(dst_port.getText()), true);
        client.voice_msg_s();
    }
    public static void start_call_client(){
        Client_Voice cv = new Client_Voice(ip.getText(), Integer.parseInt(dst_port.getText())-5);
        cv.start();
    }
    public static void start_call_server(){
        Server_Voice sv = new Server_Voice(Integer.parseInt(my_port.getText())-5);
        sv.start();
    }
    
    public static void save_message(){
        String content = text_area.getText();
        String name = "history.txt";
        String path = def_save_location + "\\" + name;
        System.out.println(content);
          
        try {
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(content);
		fileWriter.flush();
		fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chat_hc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_hc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_hc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_hc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_hc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    public static javax.swing.JButton btn_receive_file;
    private javax.swing.JButton btn_send;
    public static javax.swing.JButton btn_send_file;
    private static javax.swing.JTextField dst_port;
    private static javax.swing.JTextField ip;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private static javax.swing.JTextField my_port;
    public static javax.swing.JTextArea text_area;
    private static javax.swing.JTextField text_filePath;
    private javax.swing.JTextField text_msg;
    // End of variables declaration//GEN-END:variables
}
