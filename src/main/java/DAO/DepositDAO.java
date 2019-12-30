package DAO;

import java.math.BigDecimal;
import java.util.List;


import model2.Deposit;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public interface DepositDAO {
	
	
	public void addDeposit(Deposit deposit);
	
	public Deposit getDeposit (int deposit_ID);
	
	public void removeDeposit(int deposit_ID);
	
	public void updateBalance(Deposit deposit, BigDecimal amount );
	
	public List<Deposit > getDepositList();

}
