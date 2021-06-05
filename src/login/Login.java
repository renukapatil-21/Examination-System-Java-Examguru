package login;

import main.MainFrame;
import main.MainPanel;
import admin.AdminPanel;
import user.UserLogin;

public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1366, 750));
        setLayout(null);

        jButton1.setBackground(java.awt.SystemColor.text);
        jButton1.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        jButton1.setText("ADMIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(500, 350, 370, 70);

        jButton2.setBackground(java.awt.SystemColor.text);
        jButton2.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        jButton2.setText("USER");
        jButton2.setActionCommand("User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(500, 240, 370, 70);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jButton3.setText("BACK");
        jButton3.setMaximumSize(new java.awt.Dimension(50, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(50, 25));
        jButton3.setPreferredSize(new java.awt.Dimension(50, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(110, 600, 110, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin1.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1370, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        MainFrame.AddPanel(new MainPanel());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        MainFrame.AddPanel(new AdminPanel());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        MainFrame.AddPanel(new UserLogin());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
