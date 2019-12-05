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

import response.AuthenticationResponse;
import util.JwTokenHelper;
import embeddedbankDAO.authService;

@Path("/")
public class homeApiService extends BaseApiService {
	
	@POST
	@Path(value="auth")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorizationService(
			@DefaultValue("") @HeaderParam("MBA_ID") String MBA_ID,
			@DefaultValue("") @HeaderParam("password") String password) throws JSONException, SQLException, ClassNotFoundException, IllegalAccessException {
		
		AuthenticationResponse ar = new AuthenticationResponse();
	    authService auth = new authService();
	    //System.out.println(userName);
	    //System.out.println(password);
		/*
		 * Check whether the userName filed is empty in the message
		 * throw error : "authorized unsuccessfully. username is empty"
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
	@Path("allDevices")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDevices() {
		System.out.println("Method called");
	      JSONObject obj = new JSONObject();
	      

	      try {
	    	  obj.put("hello", "world");
	    	  obj.put("nigga", "world");
	    	  obj.put("bla bla", "world");
	      
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
	public Response mobileDeposit() {
		System.out.println("mobile deposit called");
	      JSONObject obj = new JSONObject();
	      

	      try {
	    	  obj.put("hello", "world");
	    	  obj.put("nigga", "world");
	    	  obj.put("bla bla", "world");
	      
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
