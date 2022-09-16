package prac1.com;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;


public class BaseTest {
 
	@BeforeMethod
	public void beforemethod(Method m) {
		System.out.println("STARTING TEST "+ m.getName());
		System.out.println("THREAD ID "+Thread.currentThread().getId());		
	}
}