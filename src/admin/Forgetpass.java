package admin;

import database.Connect;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.MainFrame;

public class Forgetpass extends javax.swing.JPanel {

    public Forgetpass() {
        initComponents();
    }
    private static Connect c=new Connect("root","");
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        uname1 = new javax.swing.JTextField();
        passch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Change Password");
        add(jLabel1);
        jLabel1.setBounds(470, 40, 400, 100);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UserName");
        add(jLabel2);
        jLabel2.setBounds(530, 190, 250, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Changed Password");
        add(jLabel5);
        jLabel5.setBounds(530, 310, 250, 30);

        uname1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        uname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uname1ActionPerformed(evt);
            }
        });
        uname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uname1KeyPressed(evt);
            }
        });
        add(uname1);
        uname1.setBounds(530, 240, 264, 40);

        passch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add(passch);
        passch.setBounds(530, 350, 266, 41);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("CONFIRM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(570, 450, 190, 50);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(100, 580, 140, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1370, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void uname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uname1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainFrame.AddPanel(new AdminPanel());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

              String uname = uname1.getText();
              String ans = passch.getText();  
              String sq = "UPDATE forgetpass SET pass = '"+ans+"' WHERE uname = '"+uname+"' ";
              try {
                pst=c.con.prepareStatement(sq);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Password Changed successfully");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void uname1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uname1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String sql = "SELECT * FROM forgetpass WHERE 'uname' = admin";
            try {
                pst=c.con.prepareStatement(sql);
                pst.setString(1, uname1.getText());
                rs = pst.executeQuery();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Username not Found");
            }
        }
    }//GEN-LAST:event_uname1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField passch;
    private javax.swing.JTextField uname1;
    // End of variables declaration//GEN-END:variables
}
