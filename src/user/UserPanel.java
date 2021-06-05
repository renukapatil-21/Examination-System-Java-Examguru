package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.MainFrame;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;

import database.Connect;

import javax.swing.JTextArea;

import results.UserResult;
import startTest.BeginTest;
import user.UserLogin;

public class UserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Connect c=new Connect("root","");
	private String[] Courses;
	private String Name;
	private String Username;
	private JComboBox<String> comboBox;
	private String Selected_course="";
	private String totalQuestions;
	private String eachMark;
	private String time;

    UserPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	//initialises the Selected_course and fill values in courses array this function will run one time only
	private void dataBaseWork()
	{
		String course_query="select *from course_details where hide=0";
		try{
			Statement stmt=c.con.createStatement();
			ResultSet rs=stmt.executeQuery("select count(course_name) from course_details where hide=0");
			rs.next();
			int i=rs.getInt(1);
			rs=stmt.executeQuery(course_query);
			Courses=new String[i];
			i=0;
			while(rs.next())
				Courses[i++]=rs.getString("course_name");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	// this function helps the start button to add beginTest panel or not.
	private int courseDetail(String Course)
	{
		try {
			Statement stmt = c.con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from course_details where course_name='"+Course+"'");
			rs.next();
			int i=(int)rs.getInt("total_question");
			time=rs.getString("time");
			totalQuestions=rs.getString("total_question");
			eachMark=rs.getString("question_mark");
			System.out.println("Questions are available : "+i);
			return i;
		} catch (SQLException e) {
			System.out.println("UserPanel->availableQuestions : "+e);
		}
		System.out.println("No questions are available ");
		return -1;
	}
	
	// this function gives the details of current user who is login
	private void dataBaseWork(String username)
	{
		String query="select * from userdetails where username='"+username+"'";
		try{
			Statement stmt=c.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			Name=rs.getString("FirstName")+" "+rs.getString("MiddleName")+" "+rs.getString("LastName");
			System.out.println(Name);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	JTextArea instructions;
	
	
	public UserPanel(String username) {
		setLayout(null);
		Username=username;
		dataBaseWork();
		dataBaseWork(Username);
		
		JButton btnStartTest = new JButton("START TEST");
		btnStartTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Selected_course.equals(""))
				{
					//Start test of selected course if no of questions available are greater than 1.
					if(courseDetail(Selected_course)>0)	
					{
						MainFrame.AddPanel(new BeginTest(Username,Selected_course,eachMark));
					}
					else
						JOptionPane.showMessageDialog(null, "Questions are not available.\nPlease contact admin.");
				}
				else
					JOptionPane.showMessageDialog(null, "Select course first.");;	
			}
		});
		
		JButton btnResult = new JButton("RESULT");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Show Result of current user
				new UserResult(Username,"user");			}
		});
		
                btnResult.setForeground(new Color(255, 255, 255));
		btnResult.setBackground(new Color(2, 10, 48));
		btnResult.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnResult.setBounds(1075, 600, 150, 50);
		add(btnResult);
                
                
               
                
//		btnStartTest.setBorder(new LineBorder(new Color(0, 255, 0), 3, true));
		btnStartTest.setBackground(new Color(2, 10, 48));
		btnStartTest.setForeground(new Color(255, 255, 255));
		btnStartTest.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		btnStartTest.setBounds(765, 280, 166, 42);
		add(btnStartTest);
		
		instructions = new JTextArea();
		instructions.setToolTipText("INSTRUCTIONS");
		instructions.setEditable(false);
		instructions.setDisabledTextColor(new Color(221, 160, 221));
		instructions.setBackground(new Color(192, 192, 192));
		instructions.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		instructions.setForeground(new Color(0, 0, 0));
		instructions.setBounds(10, 399, 971, 248);
		instructions.setVisible(false);
		add(instructions);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(Courses));
		comboBox.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		comboBox.setBounds(555, 280, 171, 36);
		comboBox.setSelectedIndex(-1);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Selected_course=(String)comboBox.getSelectedItem();
				courseDetail(Selected_course);
				
				instructions.setText("////////////////////////////////////\r\n              INSTRUCTIONS   \r\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\r\n\r\n1. There are total "+totalQuestions+" questions each of "+eachMark+" marks in this course.\r\n2. Maximum time is "+time+" .\r\n3. There is no negative marking for any question.\r\n4. After time is up you will be automatically logged out.\r\n5. You can see the time left on the upper right corner.\r\n6. Wish You All The Best.");
				instructions.setVisible(true);
				revalidate();
			}
		});
				
		JLabel lblSelectCourse = new JLabel("SELECT COURSE -");
//		lblSelectCourse.setForeground(UIManager.getColor("CheckBoxMenuItem.foreground"));
                lblSelectCourse.setForeground(new Color(0, 0, 0));
		lblSelectCourse.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblSelectCourse.setBounds(360, 284, 180, 28);
		add(lblSelectCourse);
		
		
		
		JButton btnEditDetails = new JButton("EDIT DETAILS");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Edit Details of User with the username
				new EditDetails(Username);
			}
		});
		
                btnEditDetails.setForeground(new Color(255, 255, 255));
		btnEditDetails.setBackground(new Color(2, 10, 48));
		btnEditDetails.setFont(new Font("Book Antiqua", Font.BOLD, 20));
                btnEditDetails.setBounds(1050, 540, 200, 50);
                add(btnEditDetails);
		
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Save Data if any.
				MainFrame.AddPanel(new UserLogin());
				JOptionPane.showMessageDialog(null, "Logout Successfully");
			}
		});
		
                btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(2, 10, 48));
		btnLogout.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		btnLogout.setBounds(50, 50, 130, 50);
		add(btnLogout);
                
		
		
		
		JLabel WlecomeLabel = new JLabel("WELCOME, "+Name+"!");
		WlecomeLabel.setForeground(new Color(0, 0, 0));
		WlecomeLabel.setFont(new Font("Cambria Math", Font.BOLD, 36));
		WlecomeLabel.setBounds(100, 200, 1000, 30);
		add(WlecomeLabel);
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/user.jpg")));
//		lblNewLabel.setBorder(new LineBorder(new Color(147, 112, 219), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 1366, 750);
		add(lblNewLabel);
	}
}



