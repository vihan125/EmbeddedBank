package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDeposit {
	
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	

	
	public AddDeposit() {
		this.connection = databaseConnection.connect();
	}
	
	
	public void add_account(int user_ID, int account_type,
			int initial_deposit, Date date_created) throws SQLException{
		
		//String queryString = "CALL addUser(?,?,?,?)";
		String queryString = "CALL addAccount(?,?,?, ?)";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, user_ID);
		ptmt.setInt(2, account_type);
		ptmt.setInt(3, initial_deposit);
		ptmt.setDate(4, date_created);
		ptmt.executeUpdate();

		
		
	}

}
