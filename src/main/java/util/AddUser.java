package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;


public class AddUser {

	
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	

	
	public AddUser() {
		this.connection = databaseConnection.connect();
	}
	
	
	public User addUser(String email, Date date_of_birth,
			String first_name, String last_name) throws SQLException{
		
		//String queryString = "CALL addUser(?,?,?,?)";
		String queryString = "Insert into users(Email,date_of_birth,first_name,last_name)"
				+ " values(?,?,?,?)";
		
		int customer_ID = 0;
		
		//ptmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
		ptmt = connection.prepareStatement(queryString, new String[]{"customer_ID"});
		ptmt.setString(1, email);
		ptmt.setDate(2, date_of_birth);
		ptmt.setString(3, first_name);
		ptmt.setString(4, last_name);
		ptmt.executeUpdate();

		
		ResultSet rs = ptmt.getGeneratedKeys();

        rs.first();
        customer_ID = rs.getInt(1);
       
		
        User return_acc = new User(customer_ID, date_of_birth, email,first_name, 
        		 last_name);
		
		return return_acc;
		
	}
}
