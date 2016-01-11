package cn.com.study.application.order.pay.helper;

/**
 * 使用支付种类选择
 * @author LHY
 * 2015年12月4日 上午9:53:33
 */
public enum UseType {
	/** PC 网页支付*/
	web,
	/** IOS和Android应用程序支付*/
	mobile,
	/** IOS和Android内置浏览器支付 */
	wap,
	/** 暂时没用 */
	wapnet;
}
