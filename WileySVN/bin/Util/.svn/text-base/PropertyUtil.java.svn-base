package Util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
public static Map<String,String> getPropAsHashMap(String strFile){
	
	Map<String,String> map = null;
	
	try{
		Properties prop = new Properties();
		map=new HashMap();
		prop.load(new FileInputStream(strFile));
		map = new HashMap<String, String>();
		for (String key : prop.stringPropertyNames()) {
			map.put(key, prop.getProperty(key));
		}
	}
	catch(Exception e){}
	
	return map;
}
}
