package apiService;


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
import DAO.MobileTDAO;
import impl_dao.SqlAccountDAO;
import impl_dao.SqlMobileTDAO;
import model2.Account;
import model2.Mobilet;
import response.AuthenticationResponse;
import util.JwTokenHelper;

@Path("/")
public class homeApiService extends BaseApiService {
	
	@POST
	@Path(value="auth")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorizationService(
			@DefaultValue("") @HeaderParam("MBA_ID") String MBA_ID,
			@DefaultValue("") @HeaderParam("password") String password) throws JSONException, SQLException, ClassNotFoundException, IllegalAccessException {
		
		AuthenticationResponse ar = new AuthenticationResponse();
	    util.authService auth = new util.authService();
	    
		/*
		 * Check whether the userName filed is empty in the message
		 * throw error : "authorized unsuccessfully. user name is empty"
		 */
		if(MBA_ID.isEmpty() || MBA_ID == "") {
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
		int customer_ID = auth.validateUsingFunction(MBA_ID, password);
		//System.out.println(customer_ID);
		
		if( customer_ID == 0) {
			return ar.unsuccess();
		}
		
		
		/*
		 * Successful connection
		 * return - private key
		 */
		String privateKey = JwTokenHelper.getInstance().generatePrivateKey(MBA_ID,password);      
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
			@DefaultValue("") @HeaderParam("agent_ID") String agent_ID_arg,
			@DefaultValue("") @HeaderParam("amount") String amount_arg,
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("MU_ID") String MU_ID_arg)  {
		//System.out.println("mobile deposit called");
	     JSONObject obj = new JSONObject();
	     
			/*
			 *  call mobile deposit functionality
			 * 
			 * */
	 	System.out.println(Integer.parseInt((agent_ID_arg)));
	 	System.out.println(Integer.parseInt((amount_arg)));
	 	System.out.println(Integer.parseInt((account_ID_arg)));
	 	System.out.println(Integer.parseInt((MU_ID_arg)));
	    int agent_ID = Integer.parseInt(agent_ID_arg);
	    int amount = Integer.parseInt(amount_arg);
	    int account_ID = Integer.parseInt(account_ID_arg);
	    int MU_ID = Integer.parseInt(MU_ID_arg);
	    
	    
		MobileTDAO accountManager = new SqlMobileTDAO();
		Mobilet at = new Mobilet();
		at.setAgent_ID(agent_ID);
		at.setAmount(amount);
		at.setDep_with('D');
		at.setMU_ID(MU_ID);
		
		try {
			accountManager.addMobilet(at, 'D', account_ID);
			
			AccountDAO check_balance_Manager = new 	SqlAccountDAO();
			Account user = check_balance_Manager.getAccount(account_ID);
		    long balance = user.getBalance(); 
		    

		     try {
		    	 obj.put("report", "successful transaction");
		    	 obj.put("account_ID", Integer.toString(account_ID));
		    	 obj.put("balance", Long.toString(balance));
		    	 
		      
		     }catch (JSONException e) {
				
		      	 e.printStackTrace();
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
			@DefaultValue("") @HeaderParam("agent_ID") String agent_ID_arg,
			@DefaultValue("") @HeaderParam("amount") String amount_arg,
			@DefaultValue("") @HeaderParam("account_ID") String account_ID_arg,
			@DefaultValue("") @HeaderParam("MU_ID") String MU_ID_arg)  {
		//System.out.println("mobile deposit called");
	     JSONObject obj = new JSONObject();
	     
			/*
			 *  call mobile deposit functionality
			 * 
			 * */
	 	System.out.println(Integer.parseInt((agent_ID_arg)));
	 	System.out.println(Integer.parseInt((amount_arg)));
	 	System.out.println(Integer.parseInt((account_ID_arg)));
	 	System.out.println(Integer.parseInt((MU_ID_arg)));
	    int agent_ID = Integer.parseInt(agent_ID_arg);
	    int amount = Integer.parseInt(amount_arg);
	    int account_ID = Integer.parseInt(account_ID_arg);
	    int MU_ID = Integer.parseInt(MU_ID_arg);
	    
	    
		MobileTDAO accountManager = new SqlMobileTDAO();
		Mobilet at = new Mobilet();
		at.setAgent_ID(agent_ID);
		at.setAmount(amount);
		at.setDep_with('W');
		at.setMU_ID(MU_ID);
		
		try {
			accountManager.addMobilet(at, 'W', account_ID);
			
			AccountDAO check_balance_Manager = new 	SqlAccountDAO();
			Account user = check_balance_Manager.getAccount(account_ID);
		    long balance = user.getBalance(); 
		    

		     try {
		    	 obj.put("report", "successful transaction");
		    	 obj.put("account_ID", Integer.toString(account_ID));
		    	 obj.put("balance", Long.toString(balance));
		    	 
		      
		     }catch (JSONException e) {
				
		      	// TODO Auto-generated catch block
		      	 e.printStackTrace();
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
}
