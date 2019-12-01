package response;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AuthenticationResponse {
	
	//private JSONObject auth_response;
	private JSONObject auth_response = new JSONObject();
	public AuthenticationResponse() {
		
	}

	public  Response errorNoMBA_ID() {
		try {
			auth_response.put("error", "authorized unsuccessfully");
			auth_response.put("possible reason", 
					"Mobile Banking Accont ID is empty");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(auth_response)
				.build();
		
	}
	
	public  Response errorNoPASSWORD() {
		
		try {
			auth_response.put("error", "authorized unsuccessfully");
			auth_response.put("possible reason", "password is empty");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(auth_response)
				.build();
		
	}
	
	public  Response success(String privateKey) {
		
		try {
			auth_response.put("success", "authorized successfully");
			auth_response.put("privateKey", privateKey);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(auth_response)
				.build();
		
	}
	
public  Response unsuccess() {
		
		try {
			auth_response.put("error", "authorized unsuccessfully");
			auth_response.put("possible reason", "wrong username or password");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		return Response.ok()
				.type(MediaType.APPLICATION_JSON)
				.entity(auth_response)
				.build();
		
	}

}
