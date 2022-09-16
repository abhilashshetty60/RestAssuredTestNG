package prac1.com;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AllergyIntolerance {
 
	public static Response response;
@Step 
@Test(priority=1)
@Description("Validation of response and status code")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case1() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		
	           response = Common_Method.get(QuerryParams, Route.AllergyIntolerance);
	                             
	       	Assert.assertEquals(response.path("entry[0].resource.resourceType"), "AllergyIntolerance");
	    	Assert.assertEquals(response.path("entry[0].resource.id"), "cradmo6.59662|58|0A87602C-061A-4335-AA51-15C6AAE60D6B");
	    	Assert.assertEquals(response.path("entry[0].resource.meta.lastUpdated"), "2021-06-25T08:04:11.000+00:00");
	    	Assert.assertEquals(response.path("entry[0].resource.category[0]"), "medication");
	    	Assert.assertEquals(response.path("entry[0].resource.code.text"), "levofloxacin");
	    	Assert.assertEquals(response.path("entry[0].resource.patient.reference"), "Patient/cradmo6.59662");
	    	Assert.assertEquals(response.path("entry[0].resource.onsetDateTime"), "2021-01-01T00:00:00+00:00");
	    	Assert.assertEquals(response.path("entry[0].resource.clinicalStatus.coding[0].code"), "active");       
}
@Step
@Test(priority=2)
@Description("Validation of status code with clinical-status as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case2() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("clinical-status", "http%3A%2F%2Fterminology.hl7.org%2FCodeSystem%2Fallergyintolerance-clinical%7Cactive");
		
	           response = Common_Method.get(QuerryParams, Route.AllergyIntolerance);	      
}
@Step
@Test(priority=3)
@Description("Validation of status code without valid Parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case3() {
		
	HashMap<String, String> QuerryParams = new HashMap<String, String> ();
	QuerryParams.put("null", "null");
	
	           response = Common_Method.get_for_null(QuerryParams, Route.AllergyIntolerance);
	        		   
}
@Step
@Test(priority=4)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case4() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59663");
		
	           response = Common_Method.get(QuerryParams, Route.AllergyIntolerance);
}
@Step
@Test(priority=5)
@Description("Validation of status code with invalid headers/path")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case5() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		
	           response = Common_Method.get_for_invalid(QuerryParams, Route.invalidpath);
}
@Step
@Test(priority=6)
@Description("Validation of status code with different clinical-status code")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case6() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("clinical-status", "http%3A%2F%2Fterminology.hl7.org%2FCodeSystem%2Fallergyintolerance-clinical%7Cresolved");
		
	           response = Common_Method.get(QuerryParams, Route.AllergyIntolerance);
 }
}