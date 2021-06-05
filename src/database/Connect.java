package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
    public Connection con;
    public Connect(String username, String Password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oes","root","");
            System.out.println("Connection established");  
            
        }catch(ClassNotFoundException e){
            System.out.println("Driver is not loaded!");
            System.out.println("Exception: "+e.getMessage());
        }
        catch(SQLException e){
	    JOptionPane.showMessageDialog(null, "Can't connect to server.");
	    System.out.println("Connection is not established : "+e.getMessage()+"\n\n"+e);
		}
    }
    public static void main(String[] args){
        new Connect("root", "");
    }

//    public PreparedStatement PreparedStatement(String query) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}

