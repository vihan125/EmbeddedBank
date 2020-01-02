package util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CheckDeal {
	
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public CheckDeal() {
		this.connection = databaseConnection.connect();
	}
	
	
	public boolean ischeckDeal(int MU_ID, int account_ID) throws SQLException{
		
		String queryString = "SELECT * FROM deal_with where account_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, account_ID);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		
		int return_MU_ID = resultSet.getInt("MU_ID");
		
		if(MU_ID == return_MU_ID) {
			return true;
		}else {
			return false;
		}	
	}
	

}
