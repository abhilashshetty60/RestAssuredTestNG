package prac1.com;

import static io.restassured.RestAssured.given;
import java.util.Map;
import io.restassured.response.Response;
import prac2.Base_Api;

public class Common_Method {

	public static Response get(Map<String, String> payload, String Basepath, int statuscode) {        
		return 
			given().
		        spec(Base_Api.getrequestspec()).	        
                queryParams(payload).
                auth().oauth2(Token_Endpoint.Token()).		        		       
            when().
                get(Basepath).        
            then().
                spec(Base_Api.getresponsespec()).
                log().ifError().
                assertThat().
                statusCode(statuscode).	   		      
                extract().
                response();     
	}
	
/*	
	  // For invalid parameters
	public static Response get_for_invalid(Map<String, String> payload, String Basepath) {        
		return 
			given().
		        spec(Base_Api.getrequestspec()).	        
                queryParams(payload).
                auth().oauth2(Token_Endpoint.Token()).		        		       
            when().
                get(Basepath).        
            then().
                spec(Base_Api.getresponsespec()).
                log().body().
                assertThat().
                statusCode(404).	   		      
                extract().
                response();
	}
	  //For no parameters
	public static Response get_for_null(Map<String, String> payload, String Basepath) {        
		return 
			given().
		        spec(Base_Api.getrequestspec()).	        
                queryParams(payload).
                auth().oauth2(Token_Endpoint.Token()).		        		        		       
            when().
                get(Basepath).        
            then().
                spec(Base_Api.getresponsespec()).
                log().body().
                assertThat().
                statusCode(400).	   		      
                extract().
                response();
	}

	public static Response get_for_musthave(Map<String, String> payload, String Basepath) {        
		return 
			given().
		        spec(Base_Api.getrequestspec()).        
                queryParams(payload).
                auth().oauth2(Token_Endpoint.Token()).		        		       
            when().
                get(Basepath).        
            then().
                spec(Base_Api.getresponsespec()).
                log().body().
                assertThat().
                statusCode(500).	   		      
                extract().
                response();
	}
	*/
}