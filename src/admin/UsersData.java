package admin;
import database.Connect;
import database.UserData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javafx.css.StyleOrigin.USER;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import user.RegistrationForm;
import java.sql.PreparedStatement;

import javax.swing.table.DefaultTableModel;
import main.MainFrame;

public class UsersData extends javax.swing.JPanel { 
    public UsersData() {
        initComponents();
        databaseVerify();
    }    
        private static Connect c=new Connect("root","");
	private String Username;
	private String[] DATA;
        private String cell;
	
	private void databaseVerify()
	{
		try{
			Statement st=c.con.createStatement();
			String query="select * from userdetails";
//			java.sql.PreparedStatement pst=c.PreparedStatement(query);
			java.sql.ResultSet rs = st.executeQuery(query);
//			table.setModel(UserData.resultSetToTableModel(rs));
                       
                        while(rs.next()){
                            String regno = String.valueOf(rs.getInt("RegNo"));
                            String username = rs.getString("Username");
                            String regdate = rs.getString("RegDate");
                            String password = rs.getString("Password");
                            String first = rs.getString("FirstName");
                            String middle = rs.getString("MiddleName");
                            String last = rs.getString("LastName");
                            String gender = rs.getString("Gender");
                            String email = rs.getString("E-mail");
                            String mobile = rs.getString("Mobile");
                            String dob = rs.getString("DOB");
                            String address = rs.getString("Address");
                            String college = rs.getString("College");
                            
                            
                            String tbdata[] = {regno, regdate, username, password,first,middle,last,gender,email,mobile,dob,address,college};
                            DefaultTableModel tbmodel = (DefaultTableModel)table.getModel();
                            
                            tbmodel.addRow(tbdata);
                        }          
		}catch(SQLException e){
			System.out.println(e);
		}
	}             

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1366, 750));
        setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(60, 40, 170, 60);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("USERS");
        add(jLabel1);
        jLabel1.setBounds(600, 30, 220, 70);

        table.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg.No.", "Reg Date", "UserName", "Password", "First Name", "MiddleName", "Last Name", "Gender", "Email", "Mobile", "DOB", "Address", "College"
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
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMinWidth(130);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(1).setMaxWidth(130);
            table.getColumnModel().getColumn(2).setMinWidth(70);
            table.getColumnModel().getColumn(2).setPreferredWidth(70);
            table.getColumnModel().getColumn(2).setMaxWidth(70);
            table.getColumnModel().getColumn(3).setMinWidth(70);
            table.getColumnModel().getColumn(3).setPreferredWidth(70);
            table.getColumnModel().getColumn(3).setMaxWidth(70);
            table.getColumnModel().getColumn(4).setMinWidth(70);
            table.getColumnModel().getColumn(4).setPreferredWidth(70);
            table.getColumnModel().getColumn(4).setMaxWidth(70);
            table.getColumnModel().getColumn(5).setMinWidth(85);
            table.getColumnModel().getColumn(5).setPreferredWidth(85);
            table.getColumnModel().getColumn(5).setMaxWidth(85);
            table.getColumnModel().getColumn(6).setMinWidth(70);
            table.getColumnModel().getColumn(6).setPreferredWidth(70);
            table.getColumnModel().getColumn(6).setMaxWidth(70);
            table.getColumnModel().getColumn(7).setMinWidth(50);
            table.getColumnModel().getColumn(7).setPreferredWidth(50);
            table.getColumnModel().getColumn(7).setMaxWidth(50);
            table.getColumnModel().getColumn(8).setMinWidth(200);
            table.getColumnModel().getColumn(8).setPreferredWidth(200);
            table.getColumnModel().getColumn(8).setMaxWidth(200);
            table.getColumnModel().getColumn(9).setMinWidth(100);
            table.getColumnModel().getColumn(9).setPreferredWidth(100);
            table.getColumnModel().getColumn(9).setMaxWidth(100);
            table.getColumnModel().getColumn(10).setMinWidth(70);
            table.getColumnModel().getColumn(10).setPreferredWidth(70);
            table.getColumnModel().getColumn(10).setMaxWidth(70);
            table.getColumnModel().getColumn(11).setMinWidth(250);
            table.getColumnModel().getColumn(11).setPreferredWidth(250);
            table.getColumnModel().getColumn(11).setMaxWidth(250);
            table.getColumnModel().getColumn(12).setMinWidth(300);
            table.getColumnModel().getColumn(12).setPreferredWidth(300);
            table.getColumnModel().getColumn(12).setMaxWidth(300);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 1310, 510);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(1180, 50, 150, 60);

        field.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldActionPerformed(evt);
            }
        });
        add(field);
        field.setBounds(970, 50, 180, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1370, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        field.setText(model.getValueAt(row, 2).toString());
        
    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainFrame.AddPanel(new MainAdmin());
    }//GEN-LAST:event_jButton1ActionPerformed
   
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

          String del = field.getText(); 
          DefaultTableModel model = (DefaultTableModel)table.getModel();
        if(table.getSelectedRowCount() == 1){
              try{
                String sql = "DELETE FROM userdetails WHERE Username = '"+ del +"'" ;
                java.sql.PreparedStatement pst=c.con.prepareStatement(sql);
                pst.execute();
                
                JOptionPane.showMessageDialog(this, "Deleted data successfully");
                
                }catch(Exception e){
                    System.out.println(e);
                JOptionPane.showMessageDialog(this, "Please select single Row "+e);
            }
            
            model.removeRow(table.getSelectedRow());
        }else{
            if(table.getRowCount()==0){
                JOptionPane.showMessageDialog(this, "table is Empty");
            }else{
                JOptionPane.showMessageDialog(this, "Please select single Row");
            }
        }
                
   
              
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
