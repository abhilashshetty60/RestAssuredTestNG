package prac1.com;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class Immunization {

public static Response response;
	
@Test(priority=1)
@Description("Validation of response and status code")
@Severity(SeverityLevel.BLOCKER)

public static void  Test_Case1() {
	
	HashMap<String, String> QueryParams = new HashMap<String, String> ();
	QueryParams.put("patient", "cradmo6.59662");
	
           response = Common_Method.get(QueryParams, Route.Immunization);
           
	       	Assert.assertEquals(response.path("entry[0].resource.resourceType"), "Immunization");
	    	Assert.assertEquals(response.path("entry[0].resource.id"), "cradmo6.59662|127|285502");
	    	Assert.assertEquals(response.path("entry[0].resource.meta.lastUpdated"), "2021-06-25T08:04:11.000+00:00");
	    	Assert.assertEquals(response.path("entry[0].resource.status"), "completed");
	    	Assert.assertEquals(response.path("entry[0].resource.vaccineCode.coding[0].code"), "140");
	    	Assert.assertEquals(response.path("entry[0].resource.patient.reference"), "Patient/cradmo6.59662");
	    	Assert.assertEquals(response.path("entry[0].resource.occurrenceDateTime"), "2017-11-20T00:00:00+00:00");
	    	Assert.assertEquals(response.path("entry[0].resource.manufacturer.reference"), "Organization/UNK"); 
	//Assert.assertEquals(response.path("entry[0].resource.vaccineCode.coding[0].code"), res.path("data.person.immunization[0].cvx_code"));
}
 
@Test(priority=2)
@Description("Validation of status code without valid Parameters")
@Severity(SeverityLevel.NORMAL)
 public static void Test_Case2() {
		
	HashMap<String, String> QuerryParams = new HashMap<String, String> ();
	QuerryParams.put("null", "null");
	
	           response = Common_Method.get_for_null(QuerryParams, Route.Immunization);
 }

@Test(priority=3)
@Description("Validation of status code with invalid headers")
@Severity(SeverityLevel.NORMAL)
public static void Test_Case3() {
	
	HashMap<String, String> QueryParams = new HashMap<String, String> ();
	QueryParams.put("patient", "cradmo6.59663");
	
           response = Common_Method.get(QueryParams, Route.Immunization);
           //Assert.assertEquals(response.path("entry[]"), null);
}

@Test(priority=4)
@Description("Validation of status code with invalid headers/basepath")
@Severity(SeverityLevel.NORMAL)
public static void Test_Case4() {
	
	HashMap<String, String> QueryParams = new HashMap<String, String> ();
	QueryParams.put("patient", "cradmo6.59662");
	
           response = Common_Method.get_for_invalid(QueryParams, Route.Immunization);	
}

@Test(priority=5)
@Description("Validation of status code with date as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
public static void Test_Case5() {
	
	HashMap<String, String> QueryParams = new HashMap<String, String> ();
	QueryParams.put("patient", "cradmo6.59662");
	QueryParams.put("date", "ge2017-11-20");
	
          response = Common_Method.get(QueryParams, Route.Immunization);
} 

@Test(priority=6)
@Description("Validation of status code with status as a filtering parameter")
@Severity(SeverityLevel.NORMAL)
public static void Test_Case6() {
	
	HashMap<String, String> QueryParams = new HashMap<String, String> ();
	QueryParams.put("patient", "cradmo6.59662");
	QueryParams.put("status", "completed");
	
        response =  Common_Method.get(QueryParams, Route.Immunization);                                         
 }

@Test(priority=7)
@Description("Validation of status code with status value")
@Severity(SeverityLevel.NORMAL)
public static void Test_Case7() {
	
	HashMap<String, String> QueryParams = new HashMap<String, String> ();
	QueryParams.put("patient", "cradmo6.59662");
	QueryParams.put("status", "not-done");
	
        response = Common_Method.get(QueryParams, Route.Immunization);                                        
 }
}