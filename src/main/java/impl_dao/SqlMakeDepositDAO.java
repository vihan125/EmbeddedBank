package impl_dao;

import java.util.List;

import DAO.MakeDepositDAO;
import model2.MakeDeposit;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public class SqlMakeDepositDAO implements MakeDepositDAO{
	
	
	public void addMakeDeposit(MakeDeposit md) {
	}
	
	public MakeDeposit getMakeDeposit (int deposit_ID) {
		return null;
	}
	
	public void removeMakeDeposit(int deposit_ID) {
	}
	
	public void updateMakeDeposit(MakeDeposit md) {
	}
	
	public List<MakeDeposit> getMakeDepositList() {
		return null;
	}

}
