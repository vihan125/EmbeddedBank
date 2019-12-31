package impl_dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.FixedDepositDAO;
import model2.FixedDeposit;
import util.databaseConnection;

/**
 * DepositDAO interface can be used to access the account details, 
 * including listing, adding, updating, removing deposits and 
 * updating deposit amount.
 */
public class SqlFixedDepositDAO implements FixedDepositDAO{
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlFixedDepositDAO() {
		this.connection = databaseConnection.connect();
	}
	
	public void addFixedDeposit(FixedDeposit fd) throws SQLException {
		String queryString = "insert into fixed_deposit(account_ID,FD_type_ID) values (?,?)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(1, fd.getAccount());
		ptmt.setInt(2, fd.getFdType());
		
		ptmt.executeUpdate();
		System.out.println("Data Added Successfully");
		
	}
	
	public FixedDeposit getFixedDeposit (int fdId) throws SQLException {
		String queryString = "SELECT * FROM fixed_deposit where FD_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, fdId);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		FixedDeposit fd = new FixedDeposit(fdId, resultSet.getInt("account_ID"),
				resultSet.getInt("FD_type_ID"));
		return fd;
	}
	
	
	
	public void removeFixedDeposit(int fd) throws SQLException {
		String queryString = "DELETE FROM fixed_deposit where FD_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, fd);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where FD_ID = " + Integer.toString(fd));
	
	}
	
	public void updateFixedDeposit(FixedDeposit fd) throws SQLException {
		String queryString = "UPDATE fixed_deposit set account_ID=?,FD_type_ID=? where FD_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, fd.getAccount());
		ptmt.setInt(2, fd.getFdType());
		ptmt.setInt(3,fd.getFdId());
		
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where FD_ID = " + Integer.toString(fd.getFdId()));
	}
	
	public List<FixedDeposit> getDepositList() throws SQLException {
		String queryString = "SELECT * FROM fixed_deposit";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<FixedDeposit> list = new  ArrayList<FixedDeposit>();
		FixedDeposit fd;
		
		while (resultSet.next()) {
			
			
			int FD_ID = resultSet.getInt("FD_ID");
			int account_ID = resultSet.getInt("account_ID");
			int FD_type_ID = resultSet.getInt("FD_type_ID");
			
			
			fd = new FixedDeposit(FD_ID, account_ID,FD_type_ID);
	
			list.add(fd);
			
		}
		return list;
	}

}
