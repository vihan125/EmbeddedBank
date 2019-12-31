package util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class databaseConnection {
	
	private static databaseConnection  dbConncection= null;
	private static Connection con = null;
	
	private databaseConnection() {	
	}
	
    public static databaseConnection getInstance() {
        if (dbConncection == null)
        	dbConncection = new databaseConnection();
        return dbConncection;
    }
	
    public static Connection connect() {
    	
    	try{  
    		Class.forName("com.mysql.cj.jdbc.Driver");  
    		con=DriverManager.getConnection(
    				"jdbc:mysql://localhost:3306/embeddedbank",
    				"root","r00t@1997");  

    	 }catch(Exception e){ 
    		System.out.println(e);
    	
    	} 
    	return con;
    }
    
    public static EntityManager getEntityManager() {
    	EntityManager entityManager =Persistence.createEntityManagerFactory(
				"embeddedBank").createEntityManager();
    	return entityManager;
    }
    
}
