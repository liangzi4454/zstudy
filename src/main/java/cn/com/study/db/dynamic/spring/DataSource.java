package cn.com.study.db.dynamic.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	
	String name() default DataSource.master;

	public static String master = "dataSource1";

	public static String slave1 = "dataSource2";

	public static String slave2 = "dataSource3";
}
