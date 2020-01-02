package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class authService {
	
	public authService() throws ClassNotFoundException, IllegalAccessException 
	{
	}
	
//	public int validate(String MBA_ID, String password){
//		EntityManager entityManager = databaseConnection.getEntityManager();
//
//		Query q = entityManager.createNativeQuery(
//				"select c.customer_ID from mobile_unit c where c.MBA_ID=? and c.password=?");
//		q.setParameter(1, MBA_ID);	
//		q.setParameter(2, password);
//		List<?> accountList = q.getResultList();
//		if(accountList.isEmpty()) {
//			    System.out.println("Bad Credentials");
//				return 0;
//			}
//			else {
//				System.out.println("login successfull.");
//				return (Integer) accountList.get(0);
//			}
//		}
		
	
	public int validateUsingFunction(String MU_ID, String password) throws SQLException{
		
		//EntityManager entityManager = databaseConnection.getEntityManager();
		//Query q = entityManager.createNativeQuery("select c from getAccout(?,?);");
		
		Connection conn = databaseConnection.connect();
	  
	    //Preparing a CallableStatement to call a function
		//CallableStatement cstmt = conn.prepareCall("{? = call getAccount(?,?)}");
	    CallableStatement cstmt = conn.prepareCall("{? = call getMA(?,?)}");
	    
	    //Registering the out parameter of the function (return type)
	     cstmt.registerOutParameter(1, Types.INTEGER);
	     
	     //Setting the input parameters of the function
	     cstmt.setString(2, MU_ID);
	     cstmt.setString(3, password);
	     
	     //Executing the statement
	     cstmt.execute();
	     Integer MU_ID_return = (Integer) cstmt.getObject(1);
	     //System.out.print("Customer"+ account_ID);
	     if(MU_ID_return == null) { 
	    	 System.out.println("Error loging in device ");
	    	 return 0;
	     }
	     else {
	    	 System.out.println("Succefully login by :" +  MU_ID_return.intValue());
	    	 return MU_ID_return.intValue();
	     
	     }
		
	}
	
}

