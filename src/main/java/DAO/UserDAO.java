package DAO;


import java.util.List;
import model2.User;

public interface UserDAO {
	
	public void addUser(User user);
	
	public User getUser(int customer_ID);
	
	public void removeUser(int customer_ID);
	
	public void updateUser(User user);
	
	public List<User> getUserList();

}
