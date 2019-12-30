package DAO;


import java.util.List;
import model2.makeMobileT;



/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */

public interface MakeMobiteTDAO {
	
	public void addMakeMobiteT(makeMobileT md);
	
	public makeMobileT getMakeMobiteT (int mobileT_ID);
	
	public void removeMakeMobiteT(int mobileT_ID);
	
	public void updateMakeMobiteT(makeMobileT md);
	
	public List<makeMobileT> getMakeMobiteTList();

}