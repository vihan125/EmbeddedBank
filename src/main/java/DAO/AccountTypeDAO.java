package DAO;

import java.sql.SQLException;
import java.util.List;

import model2.AccountType;

public interface AccountTypeDAO {
	
	

	public void addAccountType(AccountType act) throws SQLException;
	
	public AccountType getAccountType (int acc_type_ID) throws SQLException;
	
	public void removeAccountType(int acc_type_ID) throws SQLException;
	
	public void updateAccountType(AccountType act) throws SQLException;
	
	public List<AccountType> getAccountTypeList() throws SQLException;

}
