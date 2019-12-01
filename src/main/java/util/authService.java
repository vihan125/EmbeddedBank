package util;

import java.sql.*;  

public class authService {
	
	private Statement stmt;
	private ResultSet rs;
	
	public authService() 
	{
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/embeddedbank","root","r00t@1997");  
		stmt=con.createStatement();  

	 }catch(Exception e){ 
		System.out.println(e);
	
	} 
	}
	
	public int validateUnsuccessfull(String username, String password){
		
		
		try {
			rs= stmt.executeQuery("select * from users where username=\"" + username + "\"and pass=\"" + password+"\";");
			
			if (rs.next() == false) { 
				return 0;
				
			} else { 
				return rs.getInt("ID");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}  
		
		
	}
}
	


