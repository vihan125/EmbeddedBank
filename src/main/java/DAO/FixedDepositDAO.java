package DAO;


import java.util.List;


import model2.FixedDeposit;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public interface FixedDepositDAO {
	
	
	public void addFixedDeposit(FixedDeposit fd);
	
	public FixedDeposit getFixedDeposit (int fdId);
	
	public void removeFixedDeposit(FixedDeposit fd);
	
	public void updateFixedDeposit(FixedDeposit fd);
	
	public List<FixedDeposit> getDepositList();

}
