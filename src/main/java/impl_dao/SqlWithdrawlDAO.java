package impl_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.WithdrawlDAO;
import model2.Withdrawl;
import util.databaseConnection;

public class SqlWithdrawlDAO implements WithdrawlDAO{
	
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlWithdrawlDAO() {
		this.connection = databaseConnection.connect();
	}

	public void addWithdrawl(Withdrawl withdrawl, int account_ID) throws SQLException {
		String queryString = "call makeWithdrawal(?,?,'current_date')";
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(1, account_ID);
		ptmt.setInt(2, withdrawl.getAmount());
		
		ptmt.executeUpdate();
		System.out.println("Withdrawl Added Successfully for customer: "+ Integer.toString(account_ID));
		
	}

	
	
	public Withdrawl getWithdrawl(int withdrawl_ID) throws SQLException {

		String queryString = "SELECT * FROM withdrawls where withdrawl_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, withdrawl_ID);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		
		Withdrawl withdrawl = new Withdrawl();
		withdrawl.setDateOfWithdrawl(resultSet.getDate("date_of_withdrawl"));
		withdrawl.setWithdrawl_ID(withdrawl_ID);
		withdrawl.setAmount(resultSet.getInt("amount"));
		
		return withdrawl;
		
	}

	public void removeWithdrawl(int withdrawl_ID) throws SQLException {

		String queryString = "DELETE FROM withdrawls where withdrawl_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, withdrawl_ID);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where withdrawl_ID = " + Integer.toString(withdrawl_ID));
	
	}

	public void updateBalance(Withdrawl withdrawl) throws SQLException {
		String queryString = "UPDATE deposits set date_of_withdrawl=?,amount=? where withdrawl_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setDate(1, withdrawl.getDateOfWithdrawl());
		ptmt.setInt(2, withdrawl.getAmount());
		ptmt.setInt(3, withdrawl.getWithdrawl_ID());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where account_ID = " + Integer.toString(withdrawl.getWithdrawl_ID()));
	}

	
	
	
	public List<Withdrawl> getWithdrawlList() throws SQLException {
		String queryString = "SELECT * FROM withdrawls";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<Withdrawl> list = new  ArrayList<Withdrawl>();
		Withdrawl with;
		
		while (resultSet.next()) {
			int withdrawl_ID = resultSet.getInt("withdrawl_ID");
			Date dateOfWithdrawl = 	resultSet.getDate("date_of_withdrawl");
			int amount = resultSet.getInt("amount");
			with = new  Withdrawl(withdrawl_ID, amount, dateOfWithdrawl);
	
			list.add(with);
			
		}
		return list;
	}

}
