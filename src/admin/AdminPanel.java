package admin;
import database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.MainFrame;
import login.Login;

public class AdminPanel extends javax.swing.JPanel {

    public AdminPanel() {
        initComponents();
    }
//    static String password="admin";
    private static Connect c=new Connect("root","");
    PreparedStatement pst = null;
    ResultSet rs = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        forgetpass = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1366, 750));
        setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(190, 610, 140, 40);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN LOGIN");
        add(jLabel1);
        jLabel1.setBounds(500, 130, 450, 70);

        username.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        username.setToolTipText("USERNAME");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        add(username);
        username.setBounds(670, 290, 330, 50);

        pass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add(pass);
        pass.setBounds(670, 400, 330, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        add(jLabel2);
        jLabel2.setBounds(410, 290, 250, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");
        add(jLabel3);
        jLabel3.setBounds(410, 390, 230, 40);

        forgetpass.setBackground(new java.awt.Color(255, 255, 255));
        forgetpass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        forgetpass.setText("Forget Password");
        forgetpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetpassActionPerformed(evt);
            }
        });
        add(forgetpass);
        forgetpass.setBounds(420, 520, 220, 60);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("LOGIN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(810, 520, 190, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin1.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, -6, 1370, 760);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
       
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    MainFrame.AddPanel(new Login());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void forgetpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetpassActionPerformed
//       AdminPanel.password=JOptionPane.showInputDialog(null, "New password");
        MainFrame.AddPanel(new Forgetpass());
        
    }//GEN-LAST:event_forgetpassActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
//        String ans = pass.getText();
//        if(ans.equals("")){
//            JOptionPane.showMessageDialog(null, "Please Fill Answer to retrive password");
//        }else{
//            String sq = "SELECT * FROM forgetpass WHERE 'pass'= '"+ans+"'";
//            try {
//                pst=c.con.prepareStatement(sq);
//                rs = pst.executeQuery();
//                
//                if(username.getText().equals("admin") && ans.equals(rs.getString("pass"))){
//                MainFrame.AddPanel(new MainAdmin());
//                }else{
//                    JOptionPane.showMessageDialog(null, "Only for Administrators");
//            }
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, ex);
//            }
                
                try {
//                    String user1 = username.getText();
//                    String pass1 = String.valueOf(pass.getPassword());
                    
                String sq = "SELECT uname, pass FROM forgetpass WHERE uname= ? AND pass= ? ";    
                pst = c.con.prepareStatement(sq);
               
                pst.setString(1, username.getText());
                pst.setString(2, String.valueOf(pass.getPassword()));
                
                rs = pst.executeQuery();
                if(rs.next()){
//                    JOptionPane.showMessageDialog(null, "Login Successfully");
                    MainFrame.AddPanel(new MainAdmin());
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                }
                
                
                
            
        
            
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgetpass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPasswordField pass;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
