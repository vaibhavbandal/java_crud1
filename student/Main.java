package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	static Connection getConnection() throws ClassNotFoundException, SQLException {
	    Connection con;
	    Class.forName("com.mysql.cj.jdbc.Driver");
		String DB_URL = "jdbc:mysql://localhost:3306/student";
		String DB_USER = "root";
		String  DB_PASS = "";
		
		con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
		
		return con;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			Connection con = getConnection();
			if(con==null) {
				System.out.println("Not connected to DB...");
				return;
			}
			System.out.println("Connected to DB MySQL...");
			
			Statement stmt=con.createStatement(); 
			boolean isInserted =stmt.execute("INSERT INTO `student1` ( `name`, `mobile`, `date`) VALUES ( 'swapnil', '9832929292', current_timestamp());");
			if(isInserted) {
				System.out.println("Student inserted...");
			}else {
				System.out.println("Student insertion failed...");
			}
			ResultSet rs = stmt.executeQuery("SELECT * FROM student1");
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2));  
			}  
						
	}

}
