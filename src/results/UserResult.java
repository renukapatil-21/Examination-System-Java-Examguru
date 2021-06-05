package results;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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
import user.UserPanel;
import database.Connect;
import database.UserData;


public class UserResult {

	private String USERNAME;
	private String[][] DATA;
	Connect c=new Connect("root","");
	ResultSet rs;
	private String Handler;
	
	private void fetchData()
	{
		ResultSet temp1;
		try{
			temp1=databaseWork("select count(course_name) from result where username='"+USERNAME+"'");
			temp1.next();
			int totalTest=temp1.getInt(1);
			DATA=new String[totalTest][10];
			temp1=databaseWork("select *from result where username='"+USERNAME+"'");
			for(int i=0;i<totalTest;i++)
			{
				if(temp1.next())
				{
					DATA[i][0]=temp1.getString("course_name");
					DATA[i][1]=temp1.getString("total_questions");
					DATA[i][2]=temp1.getString("attempted_question");
					DATA[i][3]=""+(temp1.getInt("attempted_question")-temp1.getInt("wrong_question"))+"";//correct questions
					DATA[i][4]=temp1.getString("wrong_question");
					DATA[i][5]=temp1.getString("total_marks");
					DATA[i][6]=temp1.getString("obtained_marks");
					DATA[i][7]=temp1.getString("percentage");
					DATA[i][8]=temp1.getString("time_taken");
					DATA[i][9]=temp1.getString("test_date");
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	private ResultSet databaseWork(String query)
	{
		ResultSet rs1;
		try{
			Statement st=c.con.createStatement();
			rs1=st.executeQuery(query);
		}
		catch(SQLException e)
		{
			System.out.println("UserResult->databaseWork(String query) Exception : "+e);
			rs1=null;
		}
		return rs1;
	}
	public UserResult(String Username,String handler)
	{
		USERNAME=Username;
		Handler=handler;
		fetchData();
		if(DATA.length==0)
		{
			JOptionPane.showMessageDialog(null, "No test given by this user.");
		}
		else
		{
			MainFrame.AddPanel(makeGUI());
		}
	}
	private JPanel makeGUI() {
		JPanel p=new JPanel();
		p.setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Handler.equals("user"))
					MainFrame.AddPanel(new UserPanel(USERNAME));
				else if(Handler.equals("admin"))
					new UserData(USERNAME,true,"UsersData");
			}
		});
		
		
		
		String ColHeads[]={"Course","Total Ques.","Attempted Ques.","Correct Ques.","Wrong Ques.","Total Marks","Marks Obtained","Percentage","Time taken","Test date"};
		
		JLabel label = new JLabel(USERNAME);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(1050, 70, 300, 28);
		p.add(label);
		
		JLabel lblUsername = new JLabel("Username : ");
                lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUsername.setBounds(950, 70, 300, 28);
		p.add(lblUsername);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
                panel.setBounds(140, 160, 1500, 500);
		p.add(panel);
		panel.setLayout(null);
				
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 20));
		btnNewButton.setBounds(30, 50, 100, 50);
		p.add(btnNewButton);
               
		
		
		
		
		JLabel lblOnlineExamination = new JLabel("RESULT");
		lblOnlineExamination.setForeground(new Color(255, 255, 255));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Lucida Handwriting", Font.BOLD, 42));
		lblOnlineExamination.setBounds(550, 50, 240, 74);
		p.add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/user.jpg")));;
//		lblNewLabel.setBorder(new LineBorder(new Color(123, 104, 238), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 1366, 750);
		p.add(lblNewLabel);
		
		Result result = new Result(10,ColHeads,DATA.length,DATA);
		result.setOpaque(false);
                result.setBounds(30, 11, 951, 418);
		panel.add(result);
		
		return p;
	}
}
