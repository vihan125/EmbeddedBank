package impl_dao;

import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.AccountDAO;
import DAO.AccountTypeDAO;
import model2.Account;
import model2.AccountType;
import util.databaseConnection;

/**
 * AccountDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing accounts and 
 * updating account balance.
 */
public class SqlAccountDAO implements AccountDAO{
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private PreparedStatement ptmt2 = null;
	private ResultSet resultSet = null;
	private ResultSet  userResultSet = null;
	
	public SqlAccountDAO() {
		this.connection = databaseConnection.connect();
	}

	public void addAccount(Account account) throws SQLException {
		
		
		String queryString = "CALL addAccount(?,?,?,current_date)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(1, account.getUser_ID());
		ptmt.setInt(2, account.getAccountType().getAcc_type_ID());
		ptmt.setLong(3, account.getBalance());
		
		ptmt.executeUpdate();
		System.out.println("New account Added Successfully to the user :" + Integer.toString(account.getUser_ID()));
		
	}
	
	public Account getAccount(int account_ID) throws SQLException {
		
		// First get the account balance, account type from account table
		String queryString = "SELECT * FROM account where account_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, account_ID);
		resultSet = ptmt.executeQuery();
		resultSet.first();
		long balance = resultSet.getLong("balance");
		int accountType_number = resultSet.getInt("acc_type_ID");
		
		
		// Second get the owner of the account from own_by table
		String userqueryString = "SELECT * FROM `own_by` WHERE account_ID = ?";
		ptmt2 = connection.prepareStatement(userqueryString);
		ptmt2.setInt(1, account_ID);
		userResultSet = ptmt2.executeQuery();
		userResultSet.first();
		int customer_ID = userResultSet.getInt("customer_ID");
		
		// Third get the account type information
		AccountTypeDAO atd = new SqlAccountTypeDAO();
		AccountType at =  atd.getAccountType(accountType_number);
		
		Account account = new Account(customer_ID,account_ID, balance, at );
		return account;
	}
	
	
	
	public void removeAccount(int account_ID) throws SQLException {
		String queryString = "DELETE FROM account where account_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, account_ID);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where account_ID = " + Integer.toString(account_ID));
	}
	
	
	public void updateBalance(Account account) throws SQLException{
		
		String queryString = "UPDATE account set balance=? where account_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, new BigDecimal(account.getBalance()).intValue() );
		ptmt.setInt(2, account.getAccount_ID());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where account_ID = " + Integer.toString(account.getAccount_ID()));
	}
	
	
	
	public List<Account> getAccountList() throws SQLException {
		String queryString = "SELECT * FROM account";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<Account> list = new  ArrayList<Account>();
		Account account;
		
		while (resultSet.next()) {
			
			
			long balance = resultSet.getLong("balance");
			int accountType_number = resultSet.getInt("acc_type_ID");
			int account_ID = resultSet.getInt("account_ID");
			
			String userqueryString = "SELECT * FROM `own_by` WHERE account_ID = ?";
			ptmt2 = connection.prepareStatement(userqueryString);
			ptmt2.setInt(1, account_ID);
			userResultSet = ptmt2.executeQuery();
			userResultSet.first();
			int customer_ID = userResultSet.getInt("customer_ID");
			
			AccountTypeDAO atd = new SqlAccountTypeDAO();
			AccountType at =  atd.getAccountType(accountType_number);
			
			account = new Account(customer_ID,account_ID, balance, at );
			

	
			list.add(account);
			
		}
		return list;
	}

	

}
