package embeddedbankDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class authService {
	
	
	public authService() 
	{
		
	}
	
	public int validateUnsuccessfull(String MBA_ID, String password){
		EntityManager entityManager = databaseConnection.getEntityManager();

		Query q = entityManager.createNativeQuery(
				"select c.customer_ID from mobile_banking_account c where c.MBA_ID=? and c.password=?");
		q.setParameter(1, MBA_ID);	
		q.setParameter(2, password);
		List<?> accountList = q.getResultList();
		if(accountList.isEmpty()) {
			    System.out.println("Bad Credentials");
				return 0;
			}
			else {
				System.out.println("login successfull.");
				return (Integer) accountList.get(0);
			}
		}
		
		
		
		
	}
	


