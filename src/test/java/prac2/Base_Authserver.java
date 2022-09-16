package prac2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Base_Authserver {
			
  public static RequestSpecification getrequestspec() {
		                        		       
  return new RequestSpecBuilder().				
		            setBaseUri("https://authserver.development.arcadiaanalytics.com").
		            addHeader("Accept","application/json").
		            addHeader("Content-Type", "application/x-www-form-urlencoded").
		            addFormParam("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer").
				      //addFormParam("client_assertion", "eyJhbGciOiJSUzM4NCIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBcmNhZGlhIiwiaXNzIjoiZ3REYzM1YWVXa3NId3RSdGVKd2g2VzQxSSIsInN1YiI6Imd0RGMzNWFlV2tzSHd0UnRlSndoNlc0MUkiLCJqdGkiOiJkNjIyYWU1MC01NmM4LTQ0NjMtOTIwYS00OTEyMzg1NWQ5MGYiLCJpYXQiOjE2NjExNTMyODAsImV4cCI6MTY2MTM1MzI4MH0.YtUXsak3IK6X75IxY6JEbgzpMOnxfJoz5Wvq7vMY3p7DNNHZIgJ4M8lJ2SGhv5FgcBTtmi0599qf8VvIqXUJFUKgT0wE97ggP343ogqpfIMoiWRi-pzWgVEobFpjBPXvXUyXMtW0OEeB_FNHoLzmNVm6X1IT7yK-ydDXeDz7mv0KHD5mC6Ry_8mupspB3MJ2OYVblTR8bl54qq-3APatTBtdLch1udjXXmNaIaypjuLT4hsO023KRpxcK3_m2pnMJR8k28YyqSCWvtuU3sNTVW4jZghjMtNvEKEvnmQXgZETE21bwI4E-WYIr9ZxQnopGrwTxyhsrerf3uRUiJlSag").
		        	addFormParam("scope", "system/AllergyIntolerance.read,system/Patient.read,system/Encounter.read,system/Condition.read,system/Observation.read,system/ServiceRequest.read,system/MedicationRequest.read,system/Procedure.read,system/Immunization.read").
			        addFormParam("grant_type", "client_credentials").
			        //addFormParam("client_id", "3Z5CA7PnFRqjAswKJOZo7B77e").   
				    setContentType(ContentType.URLENC). 
		            //log(LogDetail.ALL).
		            build();			

	}
		
   public static ResponseSpecification getresponsespec() {
		 		
   return new ResponseSpecBuilder().				
			        expectStatusCode(200).
			        expectContentType(ContentType.JSON).
			        //log(LogDetail.ALL).
			        build();				      

	}
}
