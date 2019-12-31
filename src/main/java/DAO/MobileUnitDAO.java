package DAO;

import java.sql.SQLException;
import java.util.List;

import model2.MobileUnit;

public interface MobileUnitDAO {
	
	public void addMobileUnit(MobileUnit mu) throws SQLException;
	
	public MobileUnit getMobileUnit (int muId) throws SQLException;
	
	public void removeMobileUnit(int muId) throws SQLException;
	
	public void updateBalance(MobileUnit mu) throws SQLException;
	
	public List<MobileUnit> getMobileUnitList() throws SQLException;

}
