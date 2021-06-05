package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import results.CourseResult;
import main.MainFrame;
import admin.MainAdmin;
import database.Connect;

@SuppressWarnings("serial")
public class CoursesResult extends JPanel {

	/**
	 * Create the panel.
	 */
		private static Connect c=new Connect("root","");
		private JComboBox<String> comboBox;
		private String CourseName;
		private String[] DATA;
		/**
		 * Create the panel.
		 */
		public CoursesResult() {
			databaseVerify();
			makeGUI();
		}
		private void databaseVerify()
		{
			try{
				Statement st=c.con.createStatement();
				String query="select count(course_name) from course_details";
				java.sql.ResultSet rs=st.executeQuery(query);
				rs.next();
				int i=rs.getInt(1);
				DATA=new String[i];
				i=0;
				query="select course_name from course_details";
				rs=st.executeQuery(query);
				while(rs.next())
					DATA[i++]=rs.getString("course_name");
				for(String s:DATA)
					System.out.println(s);
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}

		}
		public void makeGUI() {
			//public Verification(){
				setLayout(null);
				
				JButton btnSearch = new JButton("SEARCH");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Show details of that username
						new CourseResult(CourseName);
					}
				});
				btnSearch.setForeground(new Color(0, 0, 0));
				btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 24));
//				btnSearch.setBackground(SystemColor.textInactiveText);
                                btnSearch.setBackground(new Color(255, 255, 255));
				btnSearch.setBounds(939, 323, 135, 40);
				add(btnSearch);
				
				
				
				JLabel lblUsersForVerification = new JLabel("Available Courses");
				lblUsersForVerification.setForeground(new Color(255, 255, 255));
				lblUsersForVerification.setFont(new Font("Times New Roman", Font.BOLD, 28));
				lblUsersForVerification.setBounds(370, 317, 290, 50);
				add(lblUsersForVerification);
				
				comboBox = new JComboBox<String>();
				comboBox.setModel(new DefaultComboBoxModel<String>(DATA));
				comboBox.setFont(new Font("Times New Roman", Font.BOLD, 22));
                                comboBox.setBackground(new Color(255, 255, 255));
				comboBox.setBounds(634, 323, 266, 30);
				add(comboBox);
				CourseName=DATA[0];
				comboBox.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						CourseName=(String)comboBox.getSelectedItem();				
					}
				});
				
				JButton btnNewButton = new JButton("BACK");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MainFrame.AddPanel(new MainAdmin());
					}
				});
				btnNewButton.setForeground(new Color(0, 0, 0));
//				btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
                                btnNewButton.setBackground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
                                btnNewButton.setBounds(115, 500, 140, 60);                               
				add(btnNewButton);
				
				JLabel lblOnlineExamination = new JLabel("COURSES");
				lblOnlineExamination.setForeground(new Color(255, 255, 255));
				lblOnlineExamination.setBackground(Color.GREEN);
				lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
				lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 45));
				lblOnlineExamination.setBounds(507, 100, 378, 82);
				add(lblOnlineExamination);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/admin.jpg")));
//				lblNewLabel.setBorder(new LineBorder(new Color(135, 206, 235), 4));
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setBounds(0, 0, 1366, 750);
				add(lblNewLabel);
			}

}
