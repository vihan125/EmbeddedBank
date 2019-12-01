package resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.Priorities;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.core.util.Priority;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import util.JwTokenHelper;

@Provider
@JsonTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JsTokenFilterNeeded implements ContainerRequestFilter {

	private static final String AUTHORIZATION_SERVICE_PATH = "auth";  
	private static final String PRIVATE_KEY = "privateKey";   
	private JwTokenHelper jwTokenHelper = JwTokenHelper.getInstance();

	
	public ContainerRequest filter(ContainerRequest request) {
		String path = request.getPath();
		//System.out.print(path);
		if(path.equals(AUTHORIZATION_SERVICE_PATH))
			return request;
		
		String privateKeyHeaderValue = request.getHeaderValue(PRIVATE_KEY);
		if( privateKeyHeaderValue == null || privateKeyHeaderValue.isEmpty()){	
			throw new WebApplicationException(
					getUnAuthorizeResponse("private key missing"));
		}
		
		try {
			jwTokenHelper.claimKey(privateKeyHeaderValue);
		}catch(Exception e) {
			if (e instanceof ExpiredJwtException) {
				throw new WebApplicationException(
					getUnAuthorizeResponse("private key is expired"));
			}
			else if(e instanceof MalformedJwtException) {
				throw new WebApplicationException(
					getUnAuthorizeResponse("private key is malformed"));
		}
		}
		
		return request;
		
	}
	
	
	
    private Response getUnAuthorizeResponse(String message) {	
    	JSONObject obj = new JSONObject();
	      try {
	    	  obj.put("return",message);
	      
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
