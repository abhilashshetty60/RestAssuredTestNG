package prac1.com;

import java.util.HashMap;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class MedicationRequest {
	
	public static Response response;
	 
@Test(priority=1)
@Description("Validation of response and status code")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case1() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
	                             
	/*       	Assert.assertEquals(response.path("entry[0].resource.resourceType"), "AllergyIntolerance");
	    	Assert.assertEquals(response.path("entry[0].resource.id"), "cradmo6.59662|58|0A87602C-061A-4335-AA51-15C6AAE60D6B");
	    	Assert.assertEquals(response.path("entry[0].resource.meta.lastUpdated"), "2021-06-25T08:04:11.000+00:00");
	    	Assert.assertEquals(response.path("entry[0].resource.category[0]"), "medication");
	    	Assert.assertEquals(response.path("entry[0].resource.code.text"), "levofloxacin");
	    	Assert.assertEquals(response.path("entry[0].resource.patient.reference"), "Patient/cradmo6.59662");
	    	Assert.assertEquals(response.path("entry[0].resource.onsetDateTime"), "2021-01-01T00:00:00+00:00");
	    	Assert.assertEquals(response.path("entry[0].resource.clinicalStatus.coding[0].code"), "active");       */
}

@Test(priority=2)
@Description("Validation of status code and status as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case2() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		QuerryParams.put("status", "completed");		
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
}

@Test(priority=3)
@Description("Validation of status code and encounter as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case3() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		QuerryParams.put("encounter", "Encounter/416%7C62728%7C6E321B3A-6E45-446C-A866-42A303BF6335");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
}

@Test(priority=4)
@Description("Validation of status code and authoredon as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case4() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		QuerryParams.put("authoredon", "ge2018-03-14");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
}

@Test(priority=5)
@Description("Validation of status code without valid Parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case5() {
		
	HashMap<String, String> QuerryParams = new HashMap<String, String> ();
	QuerryParams.put("null", "null");
	
	           response = Common_Method.get_for_null(QuerryParams, Route.MedicationRequest);	        		   
}

@Test(priority=6)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case6() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59663");
		QuerryParams.put("intent", "order");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
}

@Test(priority=7)
@Description("Validation of status code with invalid headers/path")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case7() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		
	           response = Common_Method.get_for_invalid(QuerryParams, Route.invalidpath);
}

@Test(priority=8)
@Description("Validation of status code with different status")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case8() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		QuerryParams.put("status", "stopped");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
}

@Test(priority=9)
@Description("Validation of status code with different encounter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case9() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		QuerryParams.put("encounter", "Encounter/416%7C62728%7CF1BB9F63-C26A-49DA-8669-DE1B722FE842");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
}

@Test(priority=10)
@Description("Validation of status code with different date/authoredon")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case10() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		QuerryParams.put("authoredon", "ge2000-03-14");
		
	           response = Common_Method.get(QuerryParams, Route.MedicationRequest);
 }

@Test(priority=11)
@Description("Validation of status code with different date/authoredon")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case11() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "plan");
		QuerryParams.put("authoredon", "ge2000-03-14");
		
	           response = Common_Method.get_for_musthave(QuerryParams, Route.MedicationRequest);
 }
}