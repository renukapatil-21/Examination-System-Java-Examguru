package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import database.Connect;
import database.UserData;
import java.awt.SystemColor;

public class Verification extends JPanel {

	/**
	 * Create the panel.
	 */
	private JComboBox<String> comboBox;
	private String Username;
	private String[] verify;
	private static boolean enteredInGUI=false;
	
	private Connect c=new Connect("root","");
	
	private void databaseVerify()
	{
		try{
			Statement st=c.con.createStatement();
			String query="select count(username) from userdetails where verify=0";
			java.sql.ResultSet rs=st.executeQuery(query);
			rs.next();
			int i=rs.getInt(1);
			verify=new String[i];
			i=0;
			query="select username from userdetails where verify=0";
			rs=st.executeQuery(query);
			while(rs.next())
				verify[i++]=rs.getString("username");
			for(String s:verify)
				System.out.println(s);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}
	
	private void databseExecuteQuery(String query)
	{
		try{
			Statement st=c.con.createStatement();
			st.execute(query);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public Verification()
	{
		databaseVerify();
		if(verify.length>0)
		{
			makeGUI();
			enteredInGUI=true;
			MainFrame.AddPanel(this);
		}
		else
		{
			//No records for verification
			if(enteredInGUI)
				MainFrame.AddPanel(new MainAdmin());
			JOptionPane.showMessageDialog(null, "All current users are verified.");
		}
	}
	public void makeGUI() {
	//public Verification(){
		setLayout(null);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Show details of that username
				new UserData(Username,true,"Verification");
			}
		});
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		btnSearch.setBackground(SystemColor.textInactiveText);
                btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setBounds(939, 323, 125, 36);
		add(btnSearch);
		
		JButton btnVerify = new JButton("VERIFY");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//make the value of verify coloum=1 of userdetails table of database OES 
				databseExecuteQuery("UPDATE userdetails SET verify=1 where username='"+Username+"'");
				
				//after that make verifiacation GUI again 
				new Verification();
			}
		});
		btnVerify.setForeground(new Color(0, 0, 0));
		btnVerify.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		btnVerify.setBackground(SystemColor.textInactiveText);
                btnVerify.setBackground(new Color(255, 255, 255));
		btnVerify.setBounds(980, 464, 140, 60);
		add(btnVerify);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//delete that record from database
				databseExecuteQuery("DELETE FROM userdetails where username='"+Username+"'");
				//after that make verification GUI again.
				new Verification();
			}
		});
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		btnDelete.setBackground(SystemColor.textInactiveText);
		btnDelete.setBounds(415, 464, 140, 60);
                btnDelete.setBackground(new Color(255, 255, 255));
		add(btnDelete);
		JLabel lblUsersForVerification = new JLabel("Users for verification");
		lblUsersForVerification.setForeground(new Color(255, 255, 255));
		lblUsersForVerification.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblUsersForVerification.setBounds(390, 323, 240, 28);
		add(lblUsersForVerification);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(verify));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
                comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(634, 323, 266, 30);
		add(comboBox);
		Username=verify[0];
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Username=(String)comboBox.getSelectedItem();				
			}
		});
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new MainAdmin());
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
//		btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
                btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(80, 611, 140, 60);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("VERIFICATION");
		lblOnlineExamination.setForeground(new Color(255, 255, 255));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblOnlineExamination.setBounds(394, 80, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/admin.jpg")));
//		lblNewLabel.setBorder(new LineBorder(new Color(135, 206, 235), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 1366, 750);
		add(lblNewLabel);
	}
}
