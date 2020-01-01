package impl_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.MobileTDAO;
import model2.Mobilet;
import util.databaseConnection;

public class SqlMobileTDAO implements MobileTDAO {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;
	
	public SqlMobileTDAO() {
		this.connection = databaseConnection.connect();
	}


	public void addMobilet(Mobilet transaction, char type,int account_ID) throws SQLException {
		
		if(type == 'W' || type == 'w') {
			
			String queryString = "call makeMobileWithdrawal(?, ?, CURRENT_DATE, ?, ?)" ;
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, account_ID);
			ptmt.setInt(2, transaction.getAmount());
			ptmt.setInt(3, transaction.getAgent_ID());
			ptmt.setInt(4, transaction.getMU_ID());
			
			
			ptmt.executeUpdate();
			System.out.println("Withdrawl Added Successfully for customer: "+ Integer.toString(account_ID));
			
			
		}else if(type == 'D'|| type == 'd') {
			String queryString = "call makeMobileDeposit(?, ?, CURRENT_DATE, ?, ?)" ;
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, account_ID);
			ptmt.setInt(2, transaction.getAmount());
			ptmt.setInt(3, transaction.getAgent_ID());
			ptmt.setInt(4, transaction.getMU_ID());
			
			
			ptmt.executeUpdate();
			System.out.println("Deposit Added Successfully for customer: "+ Integer.toString(account_ID));
			
			
		}
		
	}
	
	public Mobilet getMobilet (int mobileT_ID) throws SQLException {
		String queryString = "select * from mobilet where mobileT_ID= ?" ;
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, mobileT_ID);
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		Mobilet transaction = new Mobilet();
		transaction.setMobileT_ID(mobileT_ID);
		transaction.setAgent_ID(resultSet.getInt("agent_ID"));
		transaction.setAmount(resultSet.getInt("amount"));
		transaction.setDate_of_mobileT(resultSet.getDate("date_of_mobileT"));
		transaction.setDep_with(  resultSet.getString("dep_with").charAt(0));
		return transaction;
	}
	
	public void removeMobilet(int mobileT_ID) throws SQLException {
		String queryString = "DELETE FROM mobilet where mobileT_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, mobileT_ID);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where mobileT_ID = " + Integer.toString(mobileT_ID));
	
	}
	
	public void updateBalance(Mobilet deposit) throws SQLException {
		String queryString = "UPDATE mobilet set amount=?,date_of_mobileT=?,agent_ID=?,dep_with=? where mobileT_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, deposit.getAmount());
		ptmt.setDate(2, deposit.getDate_of_mobileT());
		ptmt.setInt(3, deposit.getAgent_ID());
		ptmt.setString(4, Character.toString(deposit.getDep_with()));
		ptmt.setInt(5, deposit.getMobileT_ID());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where mobileT_ID = " + Integer.toString(deposit.getMobileT_ID()));
	}
		
	
	
	
	public List<Mobilet> getMobiletList() throws SQLException {
		String queryString = "SELECT * FROM mobilet";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<Mobilet> list = new  ArrayList<Mobilet>();
		
		while (resultSet.next()) {
			Mobilet transaction = new Mobilet();
			transaction.setMobileT_ID(resultSet.getInt("mobileT_ID"));
			transaction.setAgent_ID(resultSet.getInt("agent_ID"));
			transaction.setAmount(resultSet.getInt("amount"));
			transaction.setDate_of_mobileT(resultSet.getDate("date_of_mobileT"));
			transaction.setDep_with(  resultSet.getString("dep_with").charAt(0));
			
			
			list.add(transaction);
			
		}
		return list;
	}

}
