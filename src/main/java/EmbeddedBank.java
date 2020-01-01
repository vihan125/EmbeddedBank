import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ResourceConfig;

import DAO.AccountDAO;
import DAO.AccountTypeDAO;
import DAO.DepositDAO;
import DAO.MobileTDAO;
import impl_dao.SqlAccountDAO;
import impl_dao.SqlAccountTypeDAO;
import impl_dao.SqlDepositDAO;
import impl_dao.SqlMobileTDAO;
import model2.Account;
import model2.AccountType;
import model2.Deposit;
import model2.Mobilet;
import resource.MyResourceConfig;
//import util.authService;


public class EmbeddedBank {

	public static void main(String[] args) throws SQLException {
		
		int agent_ID = 123;
	    int amount = 3000;
	    int account_ID = 1;
	    int MU_ID = 1;
	    AccountDAO check_balance_Manager = new 	SqlAccountDAO();
		Account user = check_balance_Manager.getAccount(account_ID);
	    
		MobileTDAO accountManager = new SqlMobileTDAO();
		Mobilet at = new Mobilet();
		at.setAgent_ID(agent_ID);
		at.setAmount(amount);
		at.setDep_with('D');
		at.setMU_ID(MU_ID);
		
		long balance = user.getBalance(); 
		System.out.println(balance);
	    
		accountManager.addMobilet(at, 'D', account_ID);
		
		user = check_balance_Manager.getAccount(account_ID);
		balance = user.getBalance(); 
		
	    
	    System.out.println(balance);
		
		/*
		 *  Checking deposit functionality
		 * 
		 * */
//		DepositDAO accountManager = new SqlDepositDAO();
//		Deposit at = new Deposit();
//		at.setAmount(500);
//		accountManager.addDeposit(at, 5);
//		
//		Deposit at2 =  accountManager.getDeposit(4);
//		System.out.println(at2.toString());
//		
//		accountManager.removeDeposit(11);
//		List<Deposit> bla3 = accountManager.getDepositList();
//		
//		for(Deposit acc: bla3) {
//			System.out.println(acc);
//		}
//		
		
		
		/*
		 *  Checking Account type functionality
		 * 
		 * */
//		AccountTypeDAO accountManager = new SqlAccountTypeDAO();
//		AccountType at = new AccountType(12,12,"Function generated");
//		
//		accountManager.addAccountType(at);
//		AccountType at2 =  accountManager.getAccountType(1);
//		System.out.println(at2.toString());
//		
//		accountManager.removeAccountType(5);
//		List<AccountType> bla3 = accountManager.getAccountTypeList();
//		
//		for(AccountType acc: bla3) {
//			System.out.println(acc);
//		}
		
		
		
		/*
		 *  Checking account functionality
		 * 
		 * */
//		
//		AccountDAO accountManager2 = new SqlAccountDAO();
//		Account bla = new Account(5,97000, at2);
//	    accountManager2.addAccount(bla);
//		Account bla2 = accountManager2.getAccount(3);
//		bla.setBalance(9999);
//		accountManager2.updateBalance(bla2);
//		List<Account> bla3 = accountManager2.getAccountList();
//		
//		for(Account acc: bla3) {
//			System.out.println(acc);
//		}
		
		
        ResourceConfig resourceConfig = new MyResourceConfig();
        try {
        	
            GrizzlyServerFactory.createHttpServer(URI.create("http://localhost:6973"), resourceConfig);   
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();


        }
       

	}
}
