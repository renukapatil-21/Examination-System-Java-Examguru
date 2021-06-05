package results;

import admin.MainAdmin;
import database.Connect;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import main.MainFrame;

public class Printresults extends javax.swing.JPanel {

    public Printresults() {
        initComponents();
        databaseVerify();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        text7 = new javax.swing.JLabel();
        text4 = new javax.swing.JLabel();
        text5 = new javax.swing.JLabel();
        text6 = new javax.swing.JLabel();
        text8 = new javax.swing.JLabel();
        text10 = new javax.swing.JLabel();
        text9 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        text11 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Print Result");
        add(jLabel1);
        jLabel1.setBounds(570, 30, 290, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Sakshi Computers And Commerce Academy");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 1, 346, 48);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Cource Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 81, 119, 32);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Total Questions:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 111, 155, 32);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Wrong Questions:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 170, 155, 32);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Username:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 51, 155, 32);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Attepted questions:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 140, 155, 32);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Percentage:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 260, 155, 32);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Obtained Marks:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(30, 230, 155, 32);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Total Marks:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 200, 155, 32);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Time Taken:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 290, 155, 32);

        text1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text1);
        text1.setBounds(190, 57, 177, 23);

        text3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text3);
        text3.setBounds(190, 117, 177, 26);

        text7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text7);
        text7.setBounds(190, 237, 177, 26);

        text4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text4);
        text4.setBounds(190, 147, 177, 26);

        text5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text5);
        text5.setBounds(190, 177, 177, 26);

        text6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text6);
        text6.setBounds(190, 207, 177, 26);

        text8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text8);
        text8.setBounds(195, 263, 159, 30);

        text10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text10);
        text10.setBounds(205, 524, 225, 32);

        text9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text9);
        text9.setBounds(195, 299, 159, 26);

        text2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text2);
        text2.setBounds(190, 87, 177, 25);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 41, 490, 10);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Test Date:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(30, 320, 155, 32);

        text11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(text11);
        text11.setBounds(195, 337, 159, 26);

        add(jPanel1);
        jPanel1.setBounds(1330, 660, 10, 10);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        add.setText("ADD DATA");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add(add);
        add.setBounds(220, 640, 170, 50);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(430, 640, 136, 50);

        table.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "Cource Name", "Total Questions", "Attempt Questions", "Wrong Questions", "Total Marks", "Obtained Marks", "Percentage", "Time Taken", "Test Date"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setColumnSelectionAllowed(true);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setIntercellSpacing(new java.awt.Dimension(2, 1));
        table.setOpaque(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setMaxWidth(100);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setMaxWidth(100);
            table.getColumnModel().getColumn(6).setMinWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setMaxWidth(100);
            table.getColumnModel().getColumn(7).setMinWidth(100);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
            table.getColumnModel().getColumn(7).setMaxWidth(100);
            table.getColumnModel().getColumn(8).setMinWidth(100);
            table.getColumnModel().getColumn(8).setPreferredWidth(100);
            table.getColumnModel().getColumn(8).setMaxWidth(100);
            table.getColumnModel().getColumn(9).setMinWidth(100);
            table.getColumnModel().getColumn(9).setPreferredWidth(100);
            table.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(570, 100, 770, 530);

        textarea.setColumns(20);
        textarea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textarea.setRows(5);
        jScrollPane2.setViewportView(textarea);

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 100, 530, 530);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(30, 640, 140, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-6, -6, 1370, 760);
    }// </editor-fold>//GEN-END:initComponents

    private static Connect c=new Connect("root","");
    private String Username;
    private String[] DATA;
    
        private void databaseVerify()
	{
		try{
			Statement st=c.con.createStatement();
			String query="select * from result";
//			java.sql.PreparedStatement pst=c.PreparedStatement(query);
			java.sql.ResultSet rs = st.executeQuery(query);
                       
                        while(rs.next()){
                            String username = rs.getString("Username");  
                            String cource = rs.getString("course_name");  
                            String totalques = rs.getString("total_questions");
                            String attemptques = rs.getString("attempted_question");
                            String wrongques = rs.getString("wrong_question");
                            String total = rs.getString("total_marks");
                            String obtain = rs.getString("obtained_marks");
                            String per = rs.getString("percentage");
                            String time = rs.getString("time_taken");
                            String date = rs.getString("test_date");
                            
                            
                            String tbdata[] = {username, cource, totalques, attemptques, wrongques, total, obtain, per, time, date};
                            DefaultTableModel tbmodel = (DefaultTableModel)table.getModel();
                            
                            tbmodel.addRow(tbdata);
                        }          
		}catch(SQLException e){
			System.out.println(e);
		}
	}
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        textarea.append("\n\n\t Sakshi Computers And Commerce Academy \n " +
                    "------------------------------------------------------------------------------------- \n"+
                    " \t Username \t\t" + text1.getText()+ "\n\n"+
                    "\t Cource Name: \t " + text2.getText()+ "\n\n"+
                    "\t Total Questions: \t " + text3.getText()+ "\n\n"+
                    "\t Attempted Questions: \t " + text4.getText()+ "\n\n"+
                    "\t Correct Questions: \t " + ((Integer.parseInt(text4.getText()))-(Integer.parseInt(text5.getText()))) + "\n\n"+        
                    "\t Wrong Questions: \t " + text5.getText()+ "\n\n"+
                    "\t Total Marks: \t\t " + text6.getText()+ "\n\n"+
                    "\t Obtained Marks: \t " + text7.getText()+ "\n\n"+
                    "\t Percentage: \t\t " + text8.getText()+ "\n\n"+
                    "\t Time Taken: \t\t " + text9.getText()+ "\n\n"+
                    "\t Test Date: \t\t " + text11.getText()+ "\n\n");
    }//GEN-LAST:event_addActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            textarea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Printresults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        
        text1.setText(model.getValueAt(selectedRowIndex, 0).toString());
        text2.setText(model.getValueAt(selectedRowIndex, 1).toString());
        text3.setText(model.getValueAt(selectedRowIndex, 2).toString());
//        
        text4.setText(model.getValueAt(selectedRowIndex, 3).toString());
        text5.setText(model.getValueAt(selectedRowIndex, 4).toString());
        text6.setText(model.getValueAt(selectedRowIndex, 5).toString());
        text7.setText(model.getValueAt(selectedRowIndex, 6).toString());
        text8.setText(model.getValueAt(selectedRowIndex, 7).toString());
        text9.setText(model.getValueAt(selectedRowIndex,8).toString());
        text11.setText(model.getValueAt(selectedRowIndex, 9).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainFrame.AddPanel(new MainAdmin());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable table;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text10;
    private javax.swing.JLabel text11;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JLabel text5;
    private javax.swing.JLabel text6;
    private javax.swing.JLabel text7;
    private javax.swing.JLabel text8;
    private javax.swing.JLabel text9;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
