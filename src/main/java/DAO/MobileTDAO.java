package DAO;

import java.math.BigDecimal;
import java.util.List;
import model2.Mobilet;

public interface MobileTDAO {

	public void addMobilet(Mobilet deposit);
	
	public Mobilet getMobilet (int mobileT_ID,int agent_ID);
	
	public void removeMobilet(int mobileT_ID,int agent_ID);
	
	public void updateBalance(Mobilet deposit, BigDecimal amount );
	
	public List<Mobilet> getMobiletList();

}
