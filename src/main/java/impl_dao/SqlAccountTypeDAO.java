package impl_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.AccountTypeDAO;
import model2.AccountType;
import util.databaseConnection;

public class SqlAccountTypeDAO implements AccountTypeDAO {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlAccountTypeDAO() {
		this.connection = databaseConnection.connect();
	}
	
	
	/*
	 *  Adding new Account type to the system
	 *  Required param - interest rate , minimum balance, name
	 * 
	 * */
	public void addAccountType(AccountType act) throws SQLException {
		String queryString = "insert into account_type(interest_rate,minimum_balance,name) values (?,?,?)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(1, act.getInterestRate());
		ptmt.setInt(2, act.getMinimumBalance());
		ptmt.setString(3, act.getName());
		
		ptmt.executeUpdate();
		System.out.println("Data Added Successfully");
		
	}

	
	/*
	 *  Populate  Account type from the system
	 *  Required param - acc_type_ID
	 * 
	 * */
	public AccountType getAccountType(int acc_type_ID) throws SQLException {
		
		String queryString = "SELECT * FROM account_type where acc_type_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, acc_type_ID);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		AccountType account = new AccountType(acc_type_ID, resultSet.getInt("interest_rate"),
				resultSet.getInt("minimum_balance"), resultSet.getString("name"));
		return account;
	}

	
	/*
	 *  Removing  Account type from the system
	 *  Required param - acc_type_ID
	 * 
	 * */
	public void removeAccountType(int acc_type_ID) throws SQLException{
		String queryString = "DELETE FROM account_type where acc_type_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, acc_type_ID);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where acc_type_ID = " + Integer.toString(acc_type_ID));
	
	}
	
	
	/*
	 *  Updating  Account type from the system
	 *  Required param - acc_type_ID
	 * 
	 * */

	public void updateAccountType(AccountType act) throws SQLException {
		String queryString = "UPDATE account_type set interest_rate=?,minimum_balance=?,name=? where acc_type_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, act.getInterestRate());
		ptmt.setInt(2, act.getMinimumBalance());
		ptmt.setString(3, act.getName());
		ptmt.setInt(4, act.getAcc_type_ID());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where account_ID = " + Integer.toString(act.getAcc_type_ID()));
	}
		

	public List<AccountType> getAccountTypeList() throws SQLException {
		String queryString = "SELECT * FROM account_type";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<AccountType> list = new  ArrayList<AccountType>();
		AccountType act;
		
		while (resultSet.next()) {
			
			
			int acc_type_ID = resultSet.getInt("acc_type_ID");
			int interet_rate = resultSet.getInt("interest_rate");
			int minimum_balance = resultSet.getInt("minimum_balance");
			String name = resultSet.getString("name");
			
			
			act = new  AccountType(acc_type_ID,interet_rate, minimum_balance, name);
	
			list.add(act);
			
		}
		return list;
	}


}
