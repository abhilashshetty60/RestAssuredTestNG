package prac1.com;

import java.util.HashMap;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class Patient {

	public static Response response;
	 
@Test(priority=1)
@Description("Validation of response and status code")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case1() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("_id", "cradmo6.59662");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
	                             
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
@Description("Validation of status code and identifier as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case2() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("identifier:", "http%3A%2F%2Fterminology.hl7.org%2FCodeSystem%2Fv2-0203%7CMR%7C61277941");		
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=3)
@Description("Validation of status code and name as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case3() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("name", "Peggy,Thomas");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=4)
@Description("Validation of status code and birthdate, name as filtering parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case4() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("birthdate", "1952-04-08");
		QuerryParams.put("name", "Peggy,Thomas");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=5)
@Description("Validation of status code and birthdate, family as filtering parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case5() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("birthdate", "1952-04-08");
		QuerryParams.put("family", "Thomas");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=6)
@Description("Validation of status code without valid Parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case6() {
		
	HashMap<String, String> QuerryParams = new HashMap<String, String> ();
	QuerryParams.put("null", "null");
	
	           response = Common_Method.get_for_null(QuerryParams, Route.Patient);	        		   
}

@Test(priority=7)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case7() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("_id", "cradmo6.59663");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=8)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case8() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("identifier:", "http%3A%2F%2Fterminology.hl7.org%2FCodeSystem%2Fv2-0203%7CMR%7C61277942");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=9)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case9() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("name:", "Pegy,Thmas");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=10)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case10() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("name:", "Peggy,Thomas");
		QuerryParams.put("birthdate:", "08-04-1952");
		
	           response = Common_Method.get_for_null(QuerryParams, Route.Patient);
}

@Test(priority=11)
@Description("Validation of status code with invalid parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case11() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("family:", "Thmas");
		QuerryParams.put("birthdate:", "1952-04-08");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=12)
@Description("Validation of status code with invalid headers/path")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case12() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("patient", "cradmo6.59662");
		QuerryParams.put("intent", "order");
		
	           response = Common_Method.get_for_invalid(QuerryParams, Route.invalidpath);
 }

@Test(priority=13)
@Description("Validation of status code with different identifier as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case13() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("identifier:", "http%3A%2F%2Fterminology.hl7.org%2FCodeSystem%2Fv2-0203%7CSS%7C61277941");		
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=14)
@Description("Validation of status code with different namr as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case14() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("name:", "Ericson");		
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=15)
@Description("Validation of status code with different name and birthdate as a filtering parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case15() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("name:", "Ericson");
		QuerryParams.put("birthdate:", "1997-04-08");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
}

@Test(priority=16)
@Description("Validation of status code with different familyname and birthdate as a filtering parameters")
@Severity(SeverityLevel.NORMAL)
	public static void  Test_Case16() {
		
		HashMap<String, String> QuerryParams = new HashMap<String, String> ();
		QuerryParams.put("family:", "Ericson");
		QuerryParams.put("birthdate:", "1997-04-08");
		
	           response = Common_Method.get(QuerryParams, Route.Patient);
 }
}