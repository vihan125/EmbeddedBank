package DAO;

import java.sql.SQLException;
import java.util.List;


import model2.Deposit;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public interface DepositDAO {
	
	public void addDeposit(Deposit deposit, int account_ID) throws SQLException;
	
	public Deposit getDeposit (int deposit_ID) throws SQLException;
	
	public void removeDeposit(int deposit_ID) throws SQLException;
	
	public void updateBalance(Deposit deposit) throws SQLException;
	
	public List<Deposit > getDepositList() throws SQLException;

}
