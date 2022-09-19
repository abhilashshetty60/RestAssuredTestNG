package prac1.com;

import static io.restassured.RestAssured.given;
import java.time.Instant;
import java.util.HashMap;
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
					Formparams.put("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer");
					Formparams.put("client_assertion", "eyJhbGciOiJSUzM4NCIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBcmNhZGlhIiwiaXNzIjoiM1o1Q0E3UG5GUnFqQXN3S0pPWm83Qjc3ZSIsInN1YiI6IjNaNUNBN1BuRlJxakFzd0tKT1pvN0I3N2UiLCJqdGkiOiI0ZmE2OGQ1Mi01MGRiLTQyMTQtYWJhMC00ZWY0NDA2NGQyMGEiLCJpYXQiOjE2NjI5NTc0NTYsImV4cCI6MTY2Mzk1NzQ1Nn0.G1JpdZvc-RKd817lV6hui-sVCgRAFRnq4kDVdFlDhXfyVvTrIhEV_8v1cM-5WqnhH7ZbJpM8slTv9lD-i2zWYgwgJ1g_ml22ZX2nKf_uBB9wmnq_X2ze3Ld_PkNFc1_bSGr--Gr-a0BZ0v_uL2eEjBgQYWI18WXDRCZkMgKbKpXA_77p5EjKL-dneDhRa4_76--jyynoh14bfuFl-23dcjgQHJ56uIsIVVNJU7e9N7IXODF4kteZk-uaTKJfOnl2urkNt-L0NHjyM_QTeh_vQ84L3JCZ-G5oqGX44mdB5VAhCUqpvq3_jx5oQ5Lj75RnZ45zNIvPuIuIjJU9aBbfzQ");
					Formparams.put("scope", "system/AllergyIntolerance.read,system/CarePlan.read,system/CareTeam.read,system/Claim.read,system/ClaimResponse.read,system/Condition.read,system/Coverage.read,system/Device.read,system/DiagnosticReport.read,system/DocumentReference.read,system/Encounter.read,system/Endpoint.read,system/ExplanationOfBenefit.read,system/FamilyMemberHistory.read,system/Goal.read,system/Group.read,system/HealthcareService.read,system/Immunization.read,system/InsurancePlan.read,system/Location.read,system/MedicationAdministration.read,system/MedicationDispense.read,system/MedicationKnowledge.read,system/MedicationRequest.read,system/Medication.read,system/MedicationStatement.read,system/Observation.read,system/OrganizationAffiliation.read,system/Organization.read,system/Patient.read,system/Practitioner.read,system/PractitionerRole.read,system/Procedure.read,system/Provenance.read,system/RelatedPerson.read,system/ServiceRequest.read,system/*.read,system/*.*");
					Formparams.put("grant_type", "client_credentials");
					Formparams.put("client_id", "3Z5CA7PnFRqjAswKJOZo7B77e");
					
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