package DAO;

import java.math.BigDecimal;
import java.util.List;

import model2.MobileUnit;
import model2.Mobilet;

public interface MobileUnitDAO {
	
	public void addMobileUnit(MobileUnit mu);
	
	public Mobilet getMobileUnit (int muId);
	
	public void removeMobileUnit(int muId);
	
	public void updateBalance(Mobilet mu, BigDecimal balance );
	
	public List<MobileUnit> getMobileUnitList();

}
