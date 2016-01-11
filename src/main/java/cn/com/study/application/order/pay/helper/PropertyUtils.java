package cn.com.study.application.order.pay.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {
	public static Map<String, String> loadProperties(String prefix) {
		Map<String, String> loadMap = new HashMap<String, String>();
		try {
			Properties properties = new Properties();
			URL url = PropertyUtils.class.getClassLoader().getResource("META-INF/zapsrnpr/config/payment.properties");
			FileInputStream fis = new FileInputStream(url.getFile());
			properties.load(fis);
			Iterator<Object> iterator = properties.keySet().iterator();
			for(;iterator.hasNext();) {
				String key = (String)iterator.next();
				if(key.startsWith(prefix)) {
					String value = properties.getProperty(key);
					loadMap.put(key, value);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loadMap;
	}
}
