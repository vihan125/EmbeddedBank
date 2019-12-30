package impl_dao;


import java.util.List;

import DAO.FixedDepositDAO;
import model2.FixedDeposit;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public class SqlFixedDepositDAO implements FixedDepositDAO{
	
	
	public void addFixedDeposit(FixedDeposit fd) {
	}
	
	public FixedDeposit getFixedDeposit (int fdId) {
		return null;
	}
	
	public void removeFixedDeposit(FixedDeposit fd) {
	}
	
	public void updateFixedDeposit(FixedDeposit fd) {
	}
	
	public List<FixedDeposit> getDepositList() {
		return null;
	}

}
