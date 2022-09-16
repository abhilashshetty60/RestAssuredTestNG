package prac2;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Base_Api {
	
	public static RequestSpecification getrequestspec() {		
	return new RequestSpecBuilder().				
			      setBaseUri("https://test-fhirapi.development.arcadiaanalytics.com/fhir").
			      addFilter(new AllureRestAssured()).			      
			      setContentType(ContentType.JSON).
			      build();						
	}
	
	public static ResponseSpecification getresponsespec() {				
    return new ResponseSpecBuilder().				
		       expectContentType(ContentType.JSON).
		       build();		      
	}
	
	public static RequestSpecification getrequestspecoftoken() {		
	return new RequestSpecBuilder().				
			      setBaseUri("https://authserver.development.arcadiaanalytics.com").
			      addFilter(new AllureRestAssured()).			      
			      setContentType(ContentType.URLENC). 
			      build();						
	}
}