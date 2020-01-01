package DAO;

import java.sql.SQLException;
import java.util.List;
import model2.Mobilet;

public interface MobileTDAO {

	public void addMobilet(Mobilet transaction, char type,int account_ID) throws SQLException ;
	
	public Mobilet getMobilet (int mobileT_ID) throws SQLException;
	
	public void removeMobilet(int mobileT_ID) throws SQLException;
	
	public void updateBalance(Mobilet deposit ) throws SQLException;
	
	public List<Mobilet> getMobiletList() throws SQLException;

}
