package cn.com.study.common.property;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author LHY
 */
@SuppressWarnings("all")
public class PropertiesUtils {
	
	/**
	 * 合并properties中的数据到map中去
	 * @param props
	 * @param map
	 */
	public static <K, V> void mergePropertiesIntoMap(Properties props, Map<K, V> map) {
		if (map == null) {
			throw new IllegalArgumentException("Map must not be null");
		}
		if (props != null) {
			for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
				String key = (String) en.nextElement();
				Object value = props.getProperty(key);
				if (value == null) {
					// Potentially a non-String value...
					value = props.get(key);
				}
				map.put((K) key, (V) value);
			}
		}
	}
}
