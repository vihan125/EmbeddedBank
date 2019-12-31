package DAO;


import java.sql.SQLException;
import java.util.List;


import model2.FixedDeposit;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public interface FixedDepositDAO {
	
	
	public void addFixedDeposit(FixedDeposit fd) throws SQLException;
	
	public FixedDeposit getFixedDeposit (int fdId) throws SQLException;
	
	public void removeFixedDeposit(int fd) throws SQLException;
	
	public void updateFixedDeposit(FixedDeposit fd) throws SQLException;
	
	public List<FixedDeposit> getDepositList() throws SQLException;

}
