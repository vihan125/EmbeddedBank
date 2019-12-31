package DAO;

import java.sql.SQLException;
import java.util.List;

import model2.Account;

/**
 * AccountDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing accounts and 
 * updating account balance.
 */
public interface AccountDAO {
	
	
	public void addAccount(Account account) throws SQLException;
	
	public Account getAccount(int account_ID) throws SQLException;
	
	public void removeAccount(int account_ID) throws SQLException;
	
	public void updateBalance(Account account) throws SQLException;
	
	public List<Account> getAccountList() throws SQLException;

}
