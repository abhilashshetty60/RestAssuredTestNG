package prac2;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import prac1.com.Route;

public class Base_Api {
	
	public static RequestSpecification getrequestspec() {		
	return new RequestSpecBuilder().
			      //setBaseUri(System.getProperty("BASE_URI")).				
			      setBaseUri(Route.BaseURI_FHIRAPI).
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
			      //setBaseUri(System.getProperty("AUTH_BASE_URI")).				
			      setBaseUri(Route.BaseURI_Auth).
			      addFilter(new AllureRestAssured()).			      
			      setContentType(ContentType.URLENC). 
			      build();						
	}
}