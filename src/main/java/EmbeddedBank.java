import java.net.URI;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ResourceConfig;


import resource.MyResourceConfig;
//import util.authService;


public class EmbeddedBank {

	public static void main(String[] args) {
		
        ResourceConfig resourceConfig = new MyResourceConfig();
        //authService n = new authService();
        try {
        	
            GrizzlyServerFactory.createHttpServer(URI.create("http://localhost:6973"), resourceConfig);   
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();


        }
       

	}
}
