package Utils;

import java.util.Properties;

public class ConfigLoader {

	private final Properties properties;
	private static ConfigLoader configLoader;
	
	private ConfigLoader() {
		
		properties = PropertyUtils.propertyLoader("src/test/resources/Config.Properties");
	}
	
	public static ConfigLoader getInstance() {
		if(configLoader==null) {
			configLoader=new ConfigLoader();
		}
		return configLoader;
	}
	
	public String getgrant_type() {
	 String prop = properties.getProperty("grant_type");
	 if(prop!=null) return prop;
	 else throw new RuntimeException("Property grant_type is not specifis in the config.properties file");
	} 
	
	public String getscope() {
		 String prop = properties.getProperty("scope");
		 if(prop!=null) return prop;
		 else throw new RuntimeException("Property scope is not specifis in the config.properties file");
		}
	
	public String getclient_assertion() {
		 String prop = properties.getProperty("client_assertion");
		 if(prop!=null) return prop;
		 else throw new RuntimeException("Property client_assertion is not specifis in the config.properties file");
		}
	
	public String getclient_assertion_type() {
		 String prop = properties.getProperty("client_assertion_type");
		 if(prop!=null) return prop;
		 else throw new RuntimeException("Property client_assertion_type is not specifis in the config.properties file");
		}
	
	public String getClientId() {
		 String prop = properties.getProperty("client_id");
		 if(prop!=null) return prop;
		 else throw new RuntimeException("Property client_id is not specifis in the config.properties file");
		}
}
