package impl_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.MobileUnitDAO;
import model.MobileUnit;
import util.databaseConnection;

public class SqlMobileUnitDAO implements MobileUnitDAO {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null;

	
	public SqlMobileUnitDAO() {
		this.connection = databaseConnection.connect();
	}
	
	
	//insert into mobile_unit(agent_ID,balance) values ('123','50000');
	
	public void addMobileUnit(MobileUnit mu) throws SQLException {
		
		String queryString = "insert into mobile_unit(balance,password) values (?,?)" ;
		ptmt = connection.prepareStatement(queryString);
		
		ptmt.setInt(2, mu.getBalance());
		ptmt.setString(2, mu.getPassword());
		
		ptmt.executeUpdate();
		System.out.println("Mobile unit created: "+ mu.toString());
		
	}
	
	public MobileUnit getMobileUnit (int muId) throws SQLException {
		String queryString = "SELECT * FROM mobile_unit where MU_ID=?";
		
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, muId);
		
		resultSet = ptmt.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		
		MobileUnit mu = new MobileUnit();
		
		mu.setBalance(resultSet.getInt("balance"));
		mu.setMuId(resultSet.getInt("MU_ID"));
		mu.setPassword(resultSet.getString("password"));
		return mu;
		
	}
	
	public void updateBalance(MobileUnit mu) throws SQLException {
		String queryString = "UPDATE mobile_unit set balance=?,password=? where MU_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, mu.getBalance());
		ptmt.setInt(3, mu.getMuId());
		ptmt.setString(3, mu.getPassword());
		
		ptmt.executeUpdate();
		System.out.println("Data Updated Successfully where MU_ID = " + Integer.toString(mu.getMuId()));
	}
		
	
	public void removeMobileUnit(int muId) throws SQLException {

		String queryString = "DELETE FROM mobile_unit where MU_ID=?";
		ptmt = connection.prepareStatement(queryString);
		ptmt.setInt(1, muId);
		ptmt.executeUpdate();
		
		System.out.println("Data Deleted Successfully where MU_ID = " + Integer.toString(muId));
	
	}
		
	
	
	
	public List<MobileUnit> getMobileUnitList() throws SQLException {
		String queryString = "SELECT * FROM mobile_unit";
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		
		List<MobileUnit> list = new  ArrayList<MobileUnit>();
		MobileUnit mu;
		
		while (resultSet.next()) {
			int MU_ID = resultSet.getInt("MU_ID");
			int balance = resultSet.getInt("balance");
			String password = resultSet.getString("password");
			mu = new  MobileUnit(MU_ID, balance, password);
	
			list.add(mu);
			
		}
		return list;
	}


	

}
