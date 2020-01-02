package apiService;


import java.sql.Date;
import java.sql.SQLException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import DAO.AccountDAO;
import DAO.AccountTypeDAO;
import DAO.DepositDAO;
import DAO.FixedDepositDAO;
import DAO.MobileTDAO;
import DAO.WithdrawlDAO;
import impl_dao.SqlAccountDAO;
import impl_dao.SqlAccountTypeDAO;
import impl_dao.SqlDepositDAO;
import impl_dao.SqlFixedDepositDAO;
import impl_dao.SqlMobileTDAO;
import impl_dao.SqlWithdrawlDAO;
import model.Account;
import model.AccountType;
import model.Deposit;
import model.FixedDeposit;
import model.Mobilet;
import model.User;
import model.Withdrawl;
import model.viewAccountModel;
import response.AuthenticationResponse;
import util.AddAccount;
import util.AddUser;
import util.CheckDeal;
import util.JwTokenHelper;
import util.viewAccount;

@Path("/")
public class homeApiService extends BaseApiService {
	
	@POST
	@Path(value="auth")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorizationService(
			@DefaultValue("") @HeaderParam("MU_ID") String MU_ID,
			@DefaultValue("") @HeaderParam("password") String password) throws JSONException, SQLException, ClassNotFoundException, IllegalAccessException {
		
		AuthenticationResponse ar = new AuthenticationResponse();
	    util.authService auth = new util.authService();
	    
		/*
		 * Check whether the userName filed is empty in the message
		 * throw error : "authorized unsuccessfully. user name is empty"
		 */
		if(MU_ID.isEmpty() || MU_ID == "") {
			return ar.errorNoMBA_ID();
		}
		
		/*
		 * Check whether the Password filed is empty in the message
		 * throw error : "authorized unsuccessfully. password is empty"
		 */
		else if(password.isEmpty() || password == null) {
			return ar.errorNoPASSWORD();
		}
		
		/*
		 * Check whether the userName and Password is correct 
		 * throw error : "authorized unsuccessfully. password incorrect"
		 */
		int MU_ID_return = auth.validateUsingFunction(MU_ID, password);
		//System.out.println(customer_ID);
		
		if( MU_ID_return == 0) {
			return ar.unsuccess();
		}
		
		
		/*
		 * Successful connection
		 * return - private key
		 */
		String privateKey = JwTokenHelper.getInstance().generatePrivateKey(MU_ID,password);      
		return ar.success(privateKey);
	}
	
	
	@GET
	@Path("ping")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDevices() {
	      JSONObject obj = new JSONObject();
	      

	      try {
	    	  obj.put("status", "server alive");
	      
	      	} catch (JSONException e) {
			
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	} 
  
	
	
	@POST
	@Path("mDeposit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mobileDeposit(
			@DefaultValue("") @HeaderParam("amount") String amount_arg,
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("MU_ID") String MU_ID_arg)  {
		//System.out.println("mobile deposit called");
	     JSONObject obj = new JSONObject();
	     
			/*
			 *  call mobile deposit functionality
			 * 
			 * */
	    int amount = Integer.parseInt(amount_arg);
	    int account_ID = Integer.parseInt(account_ID_arg);
	    int MU_ID = Integer.parseInt(MU_ID_arg);
	    
	    
		MobileTDAO accountManager = new SqlMobileTDAO();
		Mobilet at = new Mobilet();
		at.setAmount(amount);
		at.setDep_with('D');
		at.setMU_ID(MU_ID);
		
		try {
			accountManager.addMobilet(at, 'D', account_ID);
			
			AccountDAO check_balance_Manager = new 	SqlAccountDAO();
			Account user = check_balance_Manager.getAccount(account_ID);
		    long balance = user.getBalance(); 
		    
		    CheckDeal checker = new CheckDeal();
		    boolean isMatch = checker.ischeckDeal(MU_ID, account_ID);
		    
		    if(isMatch) {
		    	 try {
			    	 obj.put("report", "successful transaction");
			    	 obj.put("account_ID", Integer.toString(account_ID));
			    	 obj.put("balance", Long.toString(balance));
			    	 
			      
			     }catch (JSONException e) {
					
			      	 e.printStackTrace();
			     }
		    } else {
		    	
		    	check_balance_Manager = new SqlAccountDAO();
		    	
		    	user.setBalance(user.getBalance() - 50);
		    	check_balance_Manager.updateBalance(user);
		    	
		    	check_balance_Manager = new SqlAccountDAO();
				user = check_balance_Manager.getAccount(account_ID);
				balance = user.getBalance();
		    	try {
			    	 obj.put("report", "successful transaction");
			    	 obj.put("account_ID", Integer.toString(account_ID));
			    	 obj.put("balance", Long.toString(balance));
			    	 obj.put("deduction", "service charge of Rs.50");
			      
			     }catch (JSONException e) {
					
			      	 e.printStackTrace();
			     }
		    	
		    	
		    }

		    
			
		    
		}
		catch (SQLException e1) {
			
			e1.printStackTrace();
		     try {
		    	 obj.put("report", "unsuccessful transaction. please try again");
		 		      
		     }catch (JSONException e) {
				
		      	// TODO Auto-generated catch block
		      	 e.printStackTrace();
		     }
		}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
			
	}
	
	
	
	

	@POST
	@Path("mWithdrawal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mobileWithdrawl(
			@DefaultValue("") @HeaderParam("amount") String amount_arg,
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("MU_ID") String MU_ID_arg)  {
		//System.out.println("mobile deposit called");
	     JSONObject obj = new JSONObject();
	     
			/*
			 *  call mobile deposit functionality
			 * 
			 * */
	    int amount = Integer.parseInt(amount_arg);
	    int account_ID = Integer.parseInt(account_ID_arg);
	    int MU_ID = Integer.parseInt(MU_ID_arg);
	    
	    
		MobileTDAO accountManager = new SqlMobileTDAO();
		Mobilet at = new Mobilet();
		at.setAmount(amount);
		at.setDep_with('W');
		at.setMU_ID(MU_ID);
		
		try {
			accountManager.addMobilet(at, 'W', account_ID);
			
			AccountDAO check_balance_Manager = new 	SqlAccountDAO();
			Account user = check_balance_Manager.getAccount(account_ID);
		    long balance = user.getBalance(); 
		    
		    CheckDeal checker = new CheckDeal();
		    boolean isMatch = checker.ischeckDeal(MU_ID, account_ID);
		    

		    if(isMatch) {
		    	 try {
			    	 obj.put("report", "successful transaction");
			    	 obj.put("account_ID", Integer.toString(account_ID));
			    	 obj.put("balance", Long.toString(balance));
			    	 
			      
			     }catch (JSONException e) {
					
			      	 e.printStackTrace();
			     }
		    } else {
		    	
		    	check_balance_Manager = new SqlAccountDAO();
		    	
		    	user.setBalance(user.getBalance() - 50);
		    	check_balance_Manager.updateBalance(user);
		    	
		    	check_balance_Manager = new SqlAccountDAO();
				user = check_balance_Manager.getAccount(account_ID);
				balance = user.getBalance();
		    	try {
			    	 obj.put("report", "successful transaction");
			    	 obj.put("account_ID", Integer.toString(account_ID));
			    	 obj.put("balance", Long.toString(balance));
			    	 obj.put("deduction", "service charge of Rs.50");
			      
			     }catch (JSONException e) {
					
			      	 e.printStackTrace();
			     }
		    	
		    	
		    }
			
		    
		}
		catch (SQLException e1) {
			
			e1.printStackTrace();
		     try {
		    	 obj.put("report", "unsuccessful transaction. please try again");
		
		     }catch (JSONException e) {
				
		      	 e.printStackTrace();
		     }
		}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
			
		

	}
	
	@POST
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccount(
			@DefaultValue("") @HeaderParam("customer_ID") String customer_ID_arg) throws SQLException {
	      JSONObject obj = new JSONObject();
	      
	      int customer_ID = Integer.parseInt(customer_ID_arg);
	      viewAccount result_manager = new viewAccount();
	      viewAccountModel result = result_manager.getAccount(customer_ID);
	      
	      try {
	    	  obj.put("cutomer_ID", Integer.toString(result.getCustomer_ID()));
	    	  obj.put("first name", result.getFirst_name());
	    	  obj.put("last name", result.getLast_name());
	    	  obj.put("email", result.getEmail());
	    	  obj.put("account type", result.getName());
	    	  obj.put("balance", Integer.toString(result.getBalance()));
	      
	      	} catch (JSONException e) {
			
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	} 
	
	
	@POST
	@Path("addUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(
			@DefaultValue("") @HeaderParam("email") String email,
			@DefaultValue("") @HeaderParam("date_of_birth_arg") String date_of_birth_arg,
			@DefaultValue("") @HeaderParam("first_name") String first_name,
			@DefaultValue("") @HeaderParam("last_name") String last_name) 
					throws SQLException {
		
	      JSONObject obj = new JSONObject();
	      
	      Date date_of_birth = Date.valueOf(date_of_birth_arg);
	      
	      AddUser user_add_manager = new AddUser();
	      User user = user_add_manager.addUser(email, date_of_birth, first_name, last_name);
	      
	      try {
	    	  obj.put("status", "Successfully added a new user to the system");
	    	  obj.put("customer_ID", Integer.toString(user.getCustomer_ID()));
	    	  obj.put("first name", first_name);
	    	  obj.put("last name", last_name);
	    	  obj.put("email", email);
	    	  obj.put("date of birth",date_of_birth_arg);

	      
	      	} catch (JSONException e) {
			
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	} 
	
	
	
	@POST
	@Path("addAccount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(
			@DefaultValue("") @HeaderParam("customer_ID") String user_ID_arg,
			@DefaultValue("") @HeaderParam("account_type") String account_type_arg,
			@DefaultValue("") @HeaderParam("initial_deposit") String initial_deposit_arg,
			@DefaultValue("") @HeaderParam("date_created") String date_created_arg) 
					throws SQLException {
		
	      JSONObject obj = new JSONObject();
	      
	      Date date_created = Date.valueOf(date_created_arg);
	      int user_ID = Integer.parseInt(user_ID_arg);
	      int account_type = Integer.parseInt(account_type_arg);
	      int initial_deposit = Integer.parseInt(initial_deposit_arg);
	    		  
	      AddAccount account_manager = new AddAccount();
	      account_manager.add_account(user_ID, account_type, initial_deposit, date_created);
	      
	      AccountTypeDAO atdao = new SqlAccountTypeDAO();
	      AccountType act = atdao.getAccountType(account_type);
	      
	      try {
	    	  obj.put("status", "Successfully added a new account to the system");
	    	  obj.put("customer_ID", user_ID);
	    	  obj.put("account_type", act.toString());
	    	  obj.put("date_created", date_created);
	    	  obj.put("initial_deposit", initial_deposit);

	      
	      	} catch (JSONException e) {
			
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	} 
	
	
	
	@POST
	@Path("addDeposit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDeposit(
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("amount") String amount_arg,
			@DefaultValue("") @HeaderParam("date_of_deposit") String date_of_deposit_arg) 
					throws SQLException {
		
	      JSONObject obj = new JSONObject();
	      
	      Date date_of_deposit = Date.valueOf(date_of_deposit_arg);
	      int account_ID = Integer.parseInt(account_ID_arg);
	      int amount = Integer.parseInt(amount_arg);
	    		  
	      Deposit dep = new Deposit(amount, date_of_deposit );
	      DepositDAO depositManager = new SqlDepositDAO();
	      depositManager.addDeposit(dep, account_ID);
	      
	      AccountDAO check_balance_Manager = new 	SqlAccountDAO();
	      Account user = check_balance_Manager.getAccount(account_ID);
		  long balance = user.getBalance(); 
		    
	      try {
	    	  obj.put("status", "Successfully deposited amount of " + amount_arg + " to account id :" + account_ID_arg);
	    	  obj.put("balance", Long.toString( balance));

	      
	      	} catch (JSONException e) {
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	} 
	
	
	@POST
	@Path("addWithdrawal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addWithdrawal(
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("amount") String amount_arg,
			@DefaultValue("") @HeaderParam("date_of_deposit") String date_of_deposit_arg) 
					throws SQLException {
		
	      JSONObject obj = new JSONObject();
	      
	      Date date_of_deposit = Date.valueOf(date_of_deposit_arg);
	      int account_ID = Integer.parseInt(account_ID_arg);
	      int amount = Integer.parseInt(amount_arg);
	    		  
	      Withdrawl withdrawl = new Withdrawl(amount, date_of_deposit );
	      WithdrawlDAO depositManager = new SqlWithdrawlDAO();
	      depositManager.addWithdrawl(withdrawl, account_ID);
	      
	      AccountDAO check_balance_Manager = new 	SqlAccountDAO();
	      Account user = check_balance_Manager.getAccount(account_ID);
		  long balance = user.getBalance(); 
		    
	      try {
	    	  obj.put("status", "Successfully withdrawn amount of " + amount_arg + " to account id :" + account_ID_arg);
	    	  obj.put("balance", Long.toString( balance));

	      
	      	} catch (JSONException e) {
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	} 
	
	
	@POST
	@Path("mobileRefresh")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mobileRefresh(
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg) 
					throws SQLException {
		
	      JSONObject obj = new JSONObject();
	      int account_ID = Integer.parseInt(account_ID_arg);
	      
	      AccountDAO check_balance_Manager = new 	SqlAccountDAO();
	      Account user = check_balance_Manager.getAccount(account_ID);
		  long balance = user.getBalance(); 
		  System.out.println("balance of account: " + account_ID_arg + " is " + Long.toString(balance));  
	      try {
	    	  obj.put("balance", Long.toString( balance));

	      
	      	} catch (JSONException e) {
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	}
	
	
	@POST
	@Path("addFixedDeposit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFixedDeposit(
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("FD_type_ID") String FD_type_ID_arg) 
					throws SQLException {
		
	      JSONObject obj = new JSONObject();
	      int account_ID = Integer.parseInt(account_ID_arg);
	      int FD_type_ID = Integer.parseInt(FD_type_ID_arg);
	      
	      FixedDeposit fd = new FixedDeposit(account_ID,FD_type_ID);
	      FixedDepositDAO fd_manager = new SqlFixedDepositDAO();
	      fd_manager.addFixedDeposit(fd);
	       
		  System.out.println("New fixed deposit created");  
	      try {
	    	  obj.put("status","Successfully created new fixed deposit");
	    	  obj.put("account_ID",account_ID_arg);
	    	  obj.put("FD_type_ID",FD_type_ID_arg);
	    	  
	      	} catch (JSONException e) {
	      		// TODO Auto-generated catch block
	      		e.printStackTrace();
	      	}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(obj)
				.build();
	}
}
