package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import login.Login;
import main.MainFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import javax.swing.border.MatteBorder;
import database.Connect;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class UserLogin extends JPanel implements FocusListener{
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	Connect c=new Connect("root","");
	/**
	 * Create the panel.
	 */
	static HashMap<String, String> hm=new HashMap<String, String>();
	
	public static String exixtsUsername(String un)
	{
		Set<Map.Entry<String,String>> set = hm.entrySet();
		for(Map.Entry<String, String> me : set) {
			if(me.getKey().equals(un))
					{
						return me.getValue();
					}
			}
		return null;
	}
	
	private boolean checkVerification(String u_name)
	{
		String query="select verify from userdetails where username='"+u_name+"'";
		try{
			Statement stmt=c.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			if((boolean)rs.getBoolean("verify"))
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println("UserLogin : "+e);
			return false;
		}
		
	}
	public UserLogin() {
		setLayout(null);
		//take username and password from database and runs separately.
		new Thread(new Runnable() {
			
			public void run() {
				hm.clear();
				String course_query="select username,password from userdetails";
				try{
					Statement stmt=c.con.createStatement();
					ResultSet rs=stmt.executeQuery(course_query);
					while(rs.next())
					{
						hm.put(rs.getString(1), rs.getString(2));
					}
				}
				catch(SQLException e)
				{
					System.out.println("UserLogin : "+e);
				}
			}
		}).start();
		
//		JButton btnForgotPassword = new JButton("Forget Password");
//		btnForgotPassword.setToolTipText("Forget Password");
//		btnForgotPassword.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
////				MainFrame.AddPanel(new FrogotPassword());
//			}
//		});
//		btnForgotPassword.setForeground(new Color(0, 0, 0));
//		btnForgotPassword.setFont(new Font("Century Gothic", Font.BOLD, 18));
//		btnForgotPassword.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 205)));
//		btnForgotPassword.setBounds(707, 382, 254, 44);
//		add(btnForgotPassword);
		
		JLabel lblNewUser = new JLabel("New User - ");
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setForeground(new Color(0, 0, 0));
		lblNewUser.setFont(new Font("Bahnshrift", Font.BOLD, 30));
		lblNewUser.setBackground(Color.GREEN);
		lblNewUser.setBounds(520, 475, 170, 29);
		add(lblNewUser);
		
		JButton btnRegisterNow = new JButton("REGISTER");
		btnRegisterNow.setToolTipText("Register(if new user)");
		btnRegisterNow.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 205)));
		btnRegisterNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new RegistrationForm());
			}
		});
		btnRegisterNow.setForeground(new Color(0, 0, 0));
		btnRegisterNow.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		btnRegisterNow.setBounds(700, 477, 133, 29);
		add(btnRegisterNow);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setToolTipText("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtUsername.getForeground()!=SystemColor.activeCaptionBorder)
				{
					if(txtPassword.getForeground()!=SystemColor.activeCaptionBorder)
					{
						String username=txtUsername.getText();
						String password=txtPassword.getText();
						String pass=exixtsUsername(username);
						if(pass!=null)
						{
							
							if(password.equals(pass))
							{
								if(checkVerification(username))
								{
									MainFrame.AddPanel(new UserPanel(username));
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Please get you details verified by Admin.");
								}
							}
							else
							{
								System.out.println("Wrong Password");
								//Wrong Password.
								JOptionPane.showMessageDialog(null,"Wrong Password");
							}
						}
						else
						{
							System.out.println("Not Registered");
							//Not registered user
							JOptionPane.showMessageDialog(null,"Not Registered");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Password");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter username");
				}
			}
		});
		btnLogin.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		btnLogin.setBounds(538, 383, 316, 36);
		add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(SystemColor.activeCaptionBorder);
		txtPassword.setEchoChar('*');
		txtPassword.setToolTipText("PASSWORD");
		txtPassword.setText("Password");
		txtPassword.setSelectionColor(new Color(153, 51, 153));
		txtPassword.setSelectedTextColor(new Color(102, 204, 255));
		txtPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		txtPassword.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtPassword.setColumns(10);
		txtPassword.setBorder(UIManager.getBorder("ToolTip.border"));
		txtPassword.setBackground(new Color(255, 255, 255));
		txtPassword.setBounds(538, 313, 316, 36);
		add(txtPassword);
		txtPassword.addFocusListener(this);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(SystemColor.activeCaptionBorder);
		txtUsername.setSelectionColor(new Color(153, 51, 153));
		txtUsername.setSelectedTextColor(new Color(102, 204, 255));
		txtUsername.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtUsername.setText("Enter Username");
		txtUsername.setToolTipText("USERNAME");
		txtUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		txtUsername.setBorder(UIManager.getBorder("ToolTip.border"));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setBounds(538, 266, 316, 36);
		add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.addFocusListener(this);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Login());
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(2, 10, 48));
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		btnNewButton.setBounds(110, 600, 110, 50);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("User Login");
		lblOnlineExamination.setBorder(null);
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setBackground(new Color(255, 255, 255));
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Cambria Math", Font.BOLD, 48));
		lblOnlineExamination.setBounds(535, 150, 300, 54);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/user.jpg")));
//		lblNewLabel.setBorder(new LineBorder(new Color(60, 179, 113), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 1366, 750);
		add(lblNewLabel);
		
		
		new Thread(new Runnable() {
			
			public void run() {
				hm.clear();
				String course_query="Select username,password from userdetails";
				try{
					Statement stmt=c.con.createStatement();
					ResultSet rs=stmt.executeQuery(course_query);
					while(rs.next())
					{
						hm.put(rs.getString(1), rs.getString(2));
					}
				}
				catch(SQLException e)
				{
					System.out.println("User Login : "+e);
				}
			}
		}).start();
	}

	public void focusGained(FocusEvent arg0) {
		if(arg0.getSource()==txtPassword && txtPassword.getForeground()==SystemColor.activeCaptionBorder)
		{
			txtPassword.setText("");
			txtPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
			txtPassword.setForeground(Color.black);
		}
		if(arg0.getSource()==txtUsername && txtUsername.getForeground()==SystemColor.activeCaptionBorder)
		{
			txtUsername.setText("");
			txtUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
			txtUsername.setForeground(Color.black);
		}
	}

	public void focusLost(FocusEvent arg0) {
		if(txtPassword.getText().equals(""))
		{
			txtPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
			txtPassword.setText("Enter Password");
			txtPassword.setForeground(SystemColor.activeCaptionBorder);
		}
		if(txtUsername.getText().equals(""))
		{
			txtUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
			txtUsername.setText("Enter Username");
			txtUsername.setForeground(SystemColor.activeCaptionBorder);;
		}
		
	}
}
