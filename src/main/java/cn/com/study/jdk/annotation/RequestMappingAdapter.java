package cn.com.study.jdk.annotation;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public final class RequestMappingAdapter {
	public static final void handle(Object iinput) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Field[] fields = iinput.getClass().getDeclaredFields();
		for (Field field : fields) {
			boolean hasAnnotation = field.isAnnotationPresent(RequestMapping.class);
			if (hasAnnotation) {
				field.setAccessible(true);
				StringBuffer buffer = new StringBuffer();
				RequestMapping annotation = field.getAnnotation(RequestMapping.class);
				String name = field.getName();
				
				Object oValue = field.get(iinput);
				boolean bCollection = oValue instanceof Collection;
				// 判断如果是集合则走循环校验集合中的对象
				if (bCollection) {
					Collection collection = (Collection) oValue;
					for (Object object : collection) {
						handle(object);
					}

				} else {
					String value = String.valueOf(oValue);
					boolean required = annotation.required();
					String regex = annotation.regex();
					if(required==true && isEmptyOrNull(value)) {
						System.out.println(name+"字段不能为空");
						throw new IllegalArgumentException(name+"字段不能为空");
					}
					if(!isEmptyOrNull(regex)) {
						if(!regex.startsWith("^") && !regex.endsWith("$")) {
							throw new IllegalArgumentException("请使用正确的正则表达式");
						} else if(!matcher(regex, value)) {
							throw new IllegalArgumentException("输入参数不正确");
						}
					}
					buffer.append(name).append("=").append(value).append(",required").append("=").append(required);
					System.out.println(buffer.toString());
				}
			}
		}
	}
	private static boolean isEmptyOrNull(String value) {
		return StringUtils.isEmpty(value) || value==null || "null".equals(value);
	}
	private static boolean matcher(String regex, String value) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}
