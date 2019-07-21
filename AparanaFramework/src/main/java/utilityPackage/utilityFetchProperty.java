package utilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utilityFetchProperty {
	public static Object fetchpropertvalue(String key) throws IOException
	{
	FileInputStream file=new FileInputStream("./config/config.properties");
	 Properties property=new Properties();
	 property.load(file);
	 
	 return property.get(key);
	 
	
	}
	public static String fetchlocatorvalue(String key) throws IOException
	{
	FileInputStream file=new FileInputStream("./config/elements.properties");
	 Properties property=new Properties();
	 property.load(file);
	 
	 return property.get(key).toString();
	 
	
	}
}
