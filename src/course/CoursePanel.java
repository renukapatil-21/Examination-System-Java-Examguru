package course;

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
import admin.MainAdmin;
import main.MainFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CoursePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public  CourseDetails CD;
	private JComboBox<String> comboBox;
	private String SelectedCourse="";
	private boolean deleteCourse(String courseName)
	{
	
		try {
			Statement st=CourseDetails.c.con.createStatement();
			String query="DELETE FROM course_details where course_name='"+courseName+"'";
			st.execute(query);
			query="DELETE FROM questions where course_name='"+courseName+"'";
			st.execute(query);
			return true;
		} catch (SQLException e) {
			System.out.println("Course cannot be deleted. : "+e);
			return false;
		}
	}

	public CoursePanel() {
		setLayout(null);
		CD=new CourseDetails();
		
		comboBox= new JComboBox<String>();
		comboBox.setFont(new Font("Verdana", Font.BOLD, 18));
                comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel<String>(CD.Courses));
		comboBox.setBounds(510, 323, 206, 36);
		comboBox.setSelectedIndex(-1);
		add(comboBox);
//		SelectedCourse=CD.Courses[0];
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				SelectedCourse=(String)comboBox.getSelectedItem();
			}
		});
		
		JButton btnViewCourse = new JButton("EDIT COURSE");
		btnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//edit course and save changes in courses if any
				if(!SelectedCourse.equals(""))
					MainFrame.AddPanel(new EditCourse(SelectedCourse));
				else
					JOptionPane.showMessageDialog(null, "No course selected.\nSelect course first.");
			}
		});
		btnViewCourse.setForeground(new Color(0, 0, 0));
                btnViewCourse.setBackground(new Color(255, 255, 255));
		btnViewCourse.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnViewCourse.setBounds(742, 324, 206, 36);
		add(btnViewCourse);
		
		JButton btnDeleteCourse = new JButton("DELETE COURSE");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//delete selected course and refresh GUI
				
				if(!SelectedCourse.equals(""))
				{
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete course "+SelectedCourse)==0)
					{
						if(deleteCourse(SelectedCourse))
						{
						// course deleted successfully
						JOptionPane.showMessageDialog(null, SelectedCourse+" deleted successfully");
						MainFrame.AddPanel(new CoursePanel());
						}
						else
						{
						JOptionPane.showMessageDialog(null, SelectedCourse+" cannot be deleted.");
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No course Selected.\nSelect course first");
				}
			}
		});
		btnDeleteCourse.setForeground(new Color(0, 0, 0));
                btnDeleteCourse.setBackground(new Color(255, 255, 255));
		btnDeleteCourse.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDeleteCourse.setBounds(742, 371, 206, 36);
		add(btnDeleteCourse);
		
		JButton btnAddNewCourse = new JButton("ADD NEW COURSE");
		btnAddNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//add new course to course_details table in database
				MainFrame.AddPanel(new AddNewCourse());
			}
		});
		btnAddNewCourse.setForeground(new Color(0, 0, 0));
                btnAddNewCourse.setBackground(new Color(255, 255, 255));
		btnAddNewCourse.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAddNewCourse.setBounds(504, 418, 444, 88);
		add(btnAddNewCourse);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new MainAdmin());
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(70, 590, 110, 60);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("MANAGE COURSES");
		lblOnlineExamination.setForeground(new Color(255, 255, 255));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblOnlineExamination.setBounds(400, 80, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/admin.jpg")));
//		lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 1366, 750);
		add(lblNewLabel);

	}

}
