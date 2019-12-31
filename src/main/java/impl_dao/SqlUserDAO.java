package impl_dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.UserDAO;
import model2.User;
import util.databaseConnection;

public class SqlUserDAO implements UserDAO {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlUserDAO() {
		this.connection = databaseConnection.connect();
	}
	
	public void addUser(User user) throws SQLException {
		
		String queryString = "CALL addUser(?,?,?,?)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setString(1, user.getEmail());
		ptmt.setDate(2, user.getDateOfBirth());
		ptmt.setString(3, user.getFirstName());
		ptmt.setString(4, user.getLastName());
		
		ptmt.executeUpdate();
		System.out.print("New user Added Successfully : " );
		System.out.println(user.toString());
		
	}
	
	public User getUser(int customer_ID) throws SQLException {
		
		String queryString = "SELECT * FROM users where customer_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, customer_ID);
		resultSet = ptmt.executeQuery();
		resultSet.first();
		String Email = resultSet.getString("Email");
		Date date_of_birth = resultSet.getDate("date_of_birth");
		String first_name = resultSet.getString("first_name");		
		String last_name = resultSet.getString("last_name");			
		
		
		User user = new User(customer_ID,date_of_birth, Email, first_name,last_name);
		
		return user;
	}
	
	
	public void removeUser(int customer_ID) throws SQLException {
		String queryString = "DELETE FROM users where customer_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, customer_ID);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where customer_ID = " + Integer.toString(customer_ID));
	}
	
	public void updateUser(User user) throws SQLException {
		String queryString = "UPDATE users set email=?, date_of_birth=?,first_name=?,last_name=? where account_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setString(1, user.getEmail());
		ptmt.setDate(2, user.getDateOfBirth());
		ptmt.setString(3, user.getFirstName());
		ptmt.setString(4, user.getLastName());
		ptmt.setInt(5, user.getCustomer_ID());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where account_ID = " + Integer.toString(user.getCustomer_ID()));
	}
	
	public List<User> getUserList() throws SQLException {
		String queryString = "SELECT * FROM users";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<User> list = new  ArrayList<User>();
		User user;
		
		while (resultSet.next()) {
			
			String Email = resultSet.getString("Email");
			Date date_of_birth = resultSet.getDate("date_of_birth");
			String first_name = resultSet.getString("first_name");		
			String last_name = resultSet.getString("last_name");			
			int customer_ID = resultSet.getInt("customer_ID");
			
			user = new User(customer_ID,date_of_birth, Email, first_name,last_name);
			list.add(user);
			
		}
		return list;
	}

}
