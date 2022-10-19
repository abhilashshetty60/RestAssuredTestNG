package prac1.com;

import static io.restassured.RestAssured.given;
import java.time.Instant;
import java.util.HashMap;

import Utils.ConfigLoader;
import io.restassured.response.Response;
import prac2.Base_Api;

public class Token_Endpoint {
	
	   private static String access_token;
	   private static Instant expiry_time;
	   
	public static String Token() {
		   try 
			   {
				if(access_token == null || Instant.now().isAfter(expiry_time))
				 {
					System.out.println("Renewing Token....");
				    Response response = Token_Manager();
				    access_token = response.path("access_token");
			    	int ExpiryTimeInSecs = response.path("expires_in");
				    expiry_time = Instant.now().plusSeconds(ExpiryTimeInSecs);
				 } 
				else 
				 {
					System.out.println("Token Is Good To Use");
				 }
			  }		 
		   catch(Exception e)		   
		       {
			    e.printStackTrace();
				throw new RuntimeException("ABORT!!!! Failed To Get Token");
			   }
            return access_token;
		}
		
    private static Response Token_Manager() {					
					HashMap<String, String> Formparams = new HashMap<String, String> ();
					Formparams.put("client_assertion_type", ConfigLoader.getInstance().getclient_assertion_type());
					Formparams.put("client_assertion", ConfigLoader.getInstance().getclient_assertion());
					Formparams.put("scope", ConfigLoader.getInstance().getscope());
					Formparams.put("grant_type",ConfigLoader.getInstance().getgrant_type());
					Formparams.put("client_id", ConfigLoader.getInstance().getClientId());
					
					HashMap<String, String> Header = new HashMap<String, String> ();
					Header.put("Accept", "application/json");
					Header.put("Content-Type", "application/x-www-form-urlencoded");

 Response response= given(Base_Api.getrequestspecoftoken()).		                    
		                    formParams(Formparams).                           
                            headers(Header).					     					        					       
					when().
					        post(Route.ixauthserver+Route.api+Route.backendservice+Route.token).
					       
					then().spec(Base_Api.getresponsespec()).
					       log().
					       body().			      					       		   
					       extract().
					       response();
				 	
	 if(response.statusCode() !=200) {
        	throw new RuntimeException("ABORT!!!! RenewToken Failed");
        }
            return response;        
		}
}