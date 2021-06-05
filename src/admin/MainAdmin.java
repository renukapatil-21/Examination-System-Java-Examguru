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
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.UIManager;
import course.CoursePanel;
import database.Connect;
import results.Printresults;

public class MainAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private boolean executeQuery(String query)
	{
		Connect c=new Connect("root","");
		try{
			Statement st=c.con.createStatement();
			if(st.executeQuery(query).next())
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}
	public MainAdmin() {
		setLayout(null);
		
		JButton btnUsers = new JButton("USERS");
		btnUsers.setFocusable(false);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from userdetails"))
					MainFrame.AddPanel(new UsersData());
				else
					JOptionPane.showMessageDialog(null, "No users found.");
			}
		});
		
//		JButton btnChangePassword = new JButton("Change Password");
//		btnChangePassword.setFocusable(false);
//		btnChangePassword.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				AdminPanel.password=JOptionPane.showInputDialog(null, "New password");
//			}
//		});
//		btnChangePassword.setBounds(1050, 40, 280, 50);
//                btnChangePassword.setBackground(new Color(255, 255, 255));
//                btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 22));
//		add(btnChangePassword);
		btnUsers.setForeground(new Color(0, 0, 0));
		btnUsers.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnUsers.setBackground(new Color(255, 255, 255));
		btnUsers.setBounds(500, 200, 332, 79);
		add(btnUsers);
		
		JButton btnResults = new JButton("COURSE RESULTS");
		btnResults.setFocusable(false);
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from result"))
					MainFrame.AddPanel(new CoursesResult());
				else
					JOptionPane.showMessageDialog(null, "No result found.");
			}
		});
		btnResults.setForeground(new Color(0, 0, 0));
		btnResults.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnResults.setBackground(new Color(255, 255, 255));
		btnResults.setBounds(500, 300, 332, 79);
		add(btnResults);
		
		JButton btnVerification = new JButton("VERIFICATION");
		btnVerification.setFocusable(false);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from userdetails where verify=0"))
					new Verification();
				else
					JOptionPane.showMessageDialog(null, "No users for verification.");
			}
		});
		btnVerification.setForeground(new Color(0, 0, 0));
		btnVerification.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnVerification.setBackground(new Color(255, 255, 255));
		btnVerification.setBounds(500, 400, 332, 79);
		add(btnVerification);
                
                JButton btnprint = new JButton("PRINT RESULTS");
		btnprint.setFocusable(false);
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Printresults());
			}
		});
                btnprint.setForeground(new Color(0, 0, 0));
		btnprint.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnprint.setBackground(new Color(255, 255, 255));
		btnprint.setBounds(500, 600, 332, 79);
		add(btnprint);
		
		JButton btnManageCourses = new JButton("MANAGE COURSES");
		btnManageCourses.setFocusable(false);
		btnManageCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new CoursePanel());
			}
		});
		btnManageCourses.setForeground(new Color(0, 0, 0));
		btnManageCourses.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnManageCourses.setBackground(new Color(255, 255, 255));
		btnManageCourses.setBounds(500, 500, 332, 79);
		add(btnManageCourses);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setBounds(20, 511, 99, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
				JOptionPane.showMessageDialog(null, "Successfully Logout.");	
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(30, 40, 130, 45);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("ADMIN");
		lblOnlineExamination.setForeground(new Color(255, 255, 255));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblOnlineExamination.setBounds(400, 75, 535, 57);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/admin1.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 1366, 750);
		add(lblNewLabel);
	}
}
