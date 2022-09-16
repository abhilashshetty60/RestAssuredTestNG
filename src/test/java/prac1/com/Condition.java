package prac1.com;

import java.util.HashMap;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class Condition {

	public static Response response;
	 
@Test(priority=1)
@Description("Validation of response and status code")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case1() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
	                             
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
@Description("Validation of status code and clinical-status as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case2() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("clinical-status", "active");		
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=3)
@Description("Validation of status code and category as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case3() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("category", "problem-list-item");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=4)
@Description("Validation of status code and code as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case4() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("code", "http://snomed.info/sct%7C366.34");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=5)
@Description("Validation of status code and onset-date as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case5() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("onset-date", "ge2012-11-14");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=6)
@Description("Validation of status code without valid Parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case6() {
		
	HashMap<String, String> QuerryParams = new HashMap<String, String> ();
	QuerryParams.put("null", "null");
	
	           response = Common_Method.get_for_null(QuerryParams, Route.Condition);	        		   
}

@Test(priority=7)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case7() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59663");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=8)
@Description("Validation of status code with invalid headers/path")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case8() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		
	           response = Common_Method.get_for_invalid(QuerryParams, Route.invalidpath);
}

@Test(priority=9)
@Description("Validation of status code with different clinical-status as a parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case9() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("clinical-status", "resolved");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=10)
@Description("Validation of status code with different category as a parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case10() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("category", "health-concern");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
}

@Test(priority=11)
@Description("Validation of status code with different code as a parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case11() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("code", "http://snomed.info/sct%7CE66.01");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);
 }

@Test(priority=12)
@Description("Validation of status code with different onset-date as a parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case12() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("onset-date", "ge2000-11-14");
		
	           response = Common_Method.get(QuerryParams, Route.Condition);	
 }
}