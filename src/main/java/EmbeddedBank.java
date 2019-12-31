import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ResourceConfig;

import DAO.AccountDAO;
import DAO.AccountTypeDAO;
import impl_dao.SqlAccountDAO;
import impl_dao.SqlAccountTypeDAO;
import model2.Account;
import model2.AccountType;
import resource.MyResourceConfig;
//import util.authService;


public class EmbeddedBank {

	public static void main(String[] args) throws SQLException {
		
		
		AccountTypeDAO accountManager = new SqlAccountTypeDAO();
		//AccountType at = new AccountType(12,12,"Function generated");
		
		//accountManager.addAccountType(at);
		AccountType at2 =  accountManager.getAccountType(1);
		System.out.println(at2.toString());
		
		AccountDAO accountManager2 = new SqlAccountDAO();
		Account bla = new Account(5,97000, at2);
	    accountManager2.addAccount(bla);
		Account bla2 = accountManager2.getAccount(3);
		bla.setBalance(9999);
		accountManager2.updateBalance(bla2);
		List<Account> bla3 = accountManager2.getAccountList();
		
		for(Account acc: bla3) {
			System.out.println(acc);
		}
		
		
        ResourceConfig resourceConfig = new MyResourceConfig();
        try {
        	
            GrizzlyServerFactory.createHttpServer(URI.create("http://localhost:6973"), resourceConfig);   
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();


        }
       

	}
}
