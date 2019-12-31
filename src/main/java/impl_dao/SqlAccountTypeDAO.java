package impl_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.AccountTypeDAO;
import model2.AccountType;
import util.databaseConnection;

public class SqlAccountTypeDAO implements AccountTypeDAO {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlAccountTypeDAO() {
		this.connection = databaseConnection.connect();
	}
	
	
	public void addAccountType(AccountType act) throws SQLException {
		String queryString = "insert into account_type(interest_rate,minimum_balance,name) values (?,?,?)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(1, act.getInterestRate());
		ptmt.setInt(2, act.getMinimumBalance());
		ptmt.setString(3, act.getName());
		
		ptmt.executeUpdate();
		System.out.println("Data Added Successfully");
		
	}

	public AccountType getAccountType(int acc_type_ID) throws SQLException {
		
		String queryString = "SELECT * FROM account_type where acc_type_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, acc_type_ID);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		AccountType account = new AccountType(acc_type_ID, resultSet.getInt("interest_rate"),
				resultSet.getInt("minimum_balance"), resultSet.getString("name"));
		return account;
	}

	public void removeAccountType(int acc_type_ID) {
		// TODO Auto-generated method stub
		
	}

	public void updateAccountType(AccountType act) {
		// TODO Auto-generated method stub
		
	}

	public List<AccountType> getAccountTypeList() {
		// TODO Auto-generated method stub
		return null;
	}


}
