package embeddedbankDAO;

import java.sql.*;  

public class authService {
	
	private Statement stmt;
	private ResultSet rs;
	
	public authService() throws SQLException 
	{
		stmt = databaseConnection.connect().createStatement();
	}
	
	public int validateUnsuccessfull(String MBA_ID, String password){
		
		
		try {
			rs= stmt.executeQuery("select * from mobile_banking_account where MBA_ID=\"" + MBA_ID + "\"and password=\"" + password+"\";");
			
			if (rs.next() == false) { 
				return 0;
				
			} else { 
				return rs.getInt("Customer_ID");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}  
		
		
	}
}
	


