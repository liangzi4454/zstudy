package cn.com.study.jdk.annotation.resource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Resource注解原理
 * @Resource可以标注在字段或属性的setter方法上
 * 
 * 1. 如果指定了name属性, 那么就按name属性的名称装配;
 * 2. 如果没有指定name属性, 那就按照默认的名称查找依赖对象;
 * 3. 如果按默认名称查找不到依赖对象, 那么@Resource注解就会回退到按类型装配;
 * 
 * @author LHY 2016年3月22日 上午9:54:31
 */
@Retention(RetentionPolicy.RUNTIME)
// 指定注解保留的范围 (运行期)
@Target({ ElementType.FIELD, ElementType.METHOD })
// 允许注解标注的位置 (属性, 方法)
public @interface MyResource {
	public String name() default ""; // 提供name属性
}
