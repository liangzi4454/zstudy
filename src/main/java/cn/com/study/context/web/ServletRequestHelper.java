package cn.com.study.context.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author LHY
 * 获取ServletRequest对象
 */
public class ServletRequestHelper {
	
	public static ServletRequestHelper create() {
		return new ServletRequestHelper();
	}

	private HttpServletRequest request = null;
	/**
	 * 获取HttpRequest
	 * 
	 * @return
	 */
	public HttpServletRequest getHttpRequest() {
		if (request == null) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		}
		return request;
	}
}
