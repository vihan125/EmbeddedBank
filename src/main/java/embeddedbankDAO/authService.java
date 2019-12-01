package embeddedbankDAO;

import java.sql.*;  

public class authService {
	
	private Statement stmt;
	private ResultSet rs;
	
	public authService() throws SQLException 
	{
		stmt = databaseConnection.connect().createStatement();
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
	


