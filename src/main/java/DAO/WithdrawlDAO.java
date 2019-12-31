package DAO;

import java.sql.SQLException;
import java.util.List;
import model2.Withdrawl;

public interface WithdrawlDAO {
	
	public void addWithdrawl(Withdrawl withdrawl, int account_ID) throws SQLException;
	
	public Withdrawl getWithdrawl (int withdrawl_ID) throws SQLException;
	
	public void removeWithdrawl(int withdrawl_ID) throws SQLException;
	
	public void updateBalance(Withdrawl withdrawl) throws SQLException;
	
	public List<Withdrawl > getWithdrawlList() throws SQLException;

}
