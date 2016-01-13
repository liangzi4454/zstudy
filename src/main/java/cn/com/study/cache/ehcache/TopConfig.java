package cn.com.study.cache.ehcache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import cn.com.study.application.order.pay.helper.PropertyUtils;

public class TopConfig extends RootCache<String, String> {
	
	public final static TopConfig Instance = new TopConfig();

	public void refresh() {
		//加载配置信息
		try {
			Properties properties = new Properties();
			URL url = PropertyUtils.class.getClassLoader().getResource("META-INF/config/mail.properties");
			FileInputStream fis = new FileInputStream(url.getFile());
			properties.load(fis);
			Iterator<Object> iterator = properties.keySet().iterator();
			for(;iterator.hasNext();) {
				String key = (String)iterator.next();
				String value = properties.getProperty(key);
				this.inElement(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String upOne(String k) {
		return null;
	}

}
