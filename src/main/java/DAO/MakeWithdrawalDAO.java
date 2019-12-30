package DAO;

import java.util.List;
import model2.MakeWithdrawal;


public interface MakeWithdrawalDAO {

	

	public void addMakeWithdrawal(MakeWithdrawal md);
	
	public MakeWithdrawal getMakeWithdrawal (int withdrawal_ID);
	
	public void removeMakeWithdrawal(int withdrawal_ID);
	
	public void updateMakeWithdrawal(MakeWithdrawal md);
	
	public List<MakeWithdrawal> getMakeWithdrawalList();
}
