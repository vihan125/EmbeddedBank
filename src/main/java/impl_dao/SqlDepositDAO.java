package impl_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DepositDAO;
import model2.Deposit;
import util.databaseConnection;


public class SqlDepositDAO implements DepositDAO{
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlDepositDAO() {
		this.connection = databaseConnection.connect();
	}
	
	
	/*
	 *  Adding a new deposit to the customer
	 *  required parameters = Deposit, customer_ID
	 * 
	 * */
	public void addDeposit(Deposit deposit, int account_ID) throws SQLException {
		String queryString = "call makeDeposit(?,?,current_date)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(1, account_ID);
		ptmt.setInt(2, deposit.getAmount());
		
		ptmt.executeUpdate();
		System.out.println("Deposit Added Successfully for customer: "+ Integer.toString(account_ID));
		
	}
	
	
	/*
	 *  populating a deposit to the customer
	 *  required parameters = Deposit, customer_ID
	 * 
	 * */
	
	public Deposit getDeposit (int deposit_ID) throws SQLException {

		String queryString = "SELECT * FROM deposits where deposit_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, deposit_ID);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		
		Deposit deposit = new Deposit();
		deposit.setDateOfDeposit(resultSet.getDate("date_of_deposit"));
		deposit.setDeposit_ID(deposit_ID);
		deposit.setAmount(resultSet.getInt("amount"));
		return deposit;
		
	}
	
	
	/*
	 *  removing a new deposit 
	 *  required parameters = Deposit_ID
	 * 
	 * */
	public void removeDeposit(int deposit_ID) throws SQLException {
		
		String queryString = "DELETE FROM deposits where deposit_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, deposit_ID);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where deposit_ID = " + Integer.toString(deposit_ID));
	
	}
	
	
	
	/*
	 *  updating a balance
	 *  required parameters = Deposit
	 * 
	 * */
	public void updateBalance(Deposit deposit) throws SQLException {
		String queryString = "UPDATE deposits set date_of_deposit=?,amount=? where deposit_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setDate(1, deposit.getDateOfDeposit());
		ptmt.setInt(2, deposit.getAmount());
		ptmt.setInt(3, deposit.getDeposit_ID());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where account_ID = " + Integer.toString(deposit.getDeposit_ID()));
	}
		
	
	
	/*
	 *  listing all deposits
	 * 
	 * */
	public List<Deposit> getDepositList() throws SQLException {
		String queryString = "SELECT * FROM deposits";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<Deposit> list = new  ArrayList<Deposit>();
		Deposit depot;
		
		while (resultSet.next()) {
			int deposit_ID = resultSet.getInt("deposit_ID");
			Date dateOfDeposit = 	resultSet.getDate("date_of_deposit");
			int amount = resultSet.getInt("amount");
			depot = new  Deposit(deposit_ID, amount, dateOfDeposit);
	
			list.add(depot);
			
		}
		return list;
	}

}
