package cn.com.study.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import cn.com.study.top.base.TopInit;

/**
 * Serverlet加载时调用
 * 
 * 该类兼容两种调用模式 一种是由<br>
 * {@link ServerletListener#contextInitialized} 调用,<br>
 * 此调用模式需要在web.xml增加listener <br>
 * 另外一种是由继承{@link WebApplicationInitializer#onStartup}的调用<br>
 * 此调用模式支持spring的注解式调用<br>
 * 两种调用模式用{@linkplain #bFlagLoad}参数来防止重复调用
 * 
 */
public class ServerletLoader implements WebApplicationInitializer {

	/**
	 * 是否已加载 该参数标记该初始化操作是否已加载 默认初始化只调用一次
	 */
	private static boolean bFlagLoad = false;

	/**
	 * 初始化类
	 * 
	 * 
	 * @param servletContext
	 */
	public synchronized boolean init(ServletContext servletContext) {

		boolean bFlagSuccess = true;

		if (!bFlagLoad) {

			bFlagLoad = true;

			try {

				servletContext.log("Initializing");

				// servletContext.getContextPath();

				bFlagSuccess = new TopInit().init();

				// InitProcess(servletContext);

				servletContext.log("Initializing finished");

			} catch (RuntimeException ex) {
				bFlagSuccess = false;

				servletContext.log("Error " + ex.getMessage());
			}
		}

		return bFlagSuccess;
	}

	/**
	 * 容器关闭时调用
	 * 
	 * @param servletContext
	 * @return
	 */
	public synchronized boolean destory(ServletContext servletContext) {

		return new TopInit().destory();
	}

	/**
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 *      .ServletContext)
	 */
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		if (!bFlagLoad) {
			if (!init(servletContext)) {
				servletContext.log(this.getClass().getName()
						+ " Error onStartup");

				throw new ServletException("init error");
			}
		}
	}
}
