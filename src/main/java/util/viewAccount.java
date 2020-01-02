package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.viewAccountModel;

public class viewAccount {

	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public viewAccount() {
		this.connection = databaseConnection.connect();
	}
	
	
	public viewAccountModel getAccount(int customer_ID) throws SQLException{
		
		String queryString = "select customer_ID, Email, date_of_birth,"
				+ "first_name,last_name, balance, name from users "
				+ "natural join own_by natural join account natural "
				+ "join account_type where customer_ID = ?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, customer_ID);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		viewAccountModel view = new viewAccountModel();
		
		view.setBalance(resultSet.getInt("balance"));
		view.setCustomer_ID(resultSet.getInt("customer_ID"));
		view.setDate_of_birth(resultSet.getDate("date_of_birth"));
		view.setEmail(resultSet.getString("Email"));
		view.setFirst_name(resultSet.getString("first_name"));
		view.setLast_name(resultSet.getString("last_name"));
		view.setName(resultSet.getString("name"));
		
		return view;
		
		
	}
	

}