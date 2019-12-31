package DAO;


import java.sql.SQLException;
import java.util.List;
import model2.User;

public interface UserDAO {
	
	public void addUser(User user) throws SQLException;
	
	public User getUser(int customer_ID) throws SQLException;
	
	public void removeUser(int customer_ID) throws SQLException;
	
	public void updateUser(User user) throws SQLException;
	
	public List<User> getUserList() throws SQLException;

}
