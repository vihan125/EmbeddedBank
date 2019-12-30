package impl_dao;

import java.math.BigDecimal;
import java.util.List;

import DAO.AccountDAO;
import model2.Account;

/**
 * AccountDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing accounts and 
 * updating account balance.
 */
public class SqlAccountDAO implements AccountDAO{
	
	
	public void addAccount(Account account) {
	}
	
	public Account getAccount(int account_ID) {
		return null;
	}
	
	public void removeAccount(Account account) {
	}
	
	public void updateBalance(Account account, BigDecimal balance ) {
	}
	
	public List<Account> getAccountList() {
		return null;
	}

}
