package cn.com.study.common.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统各数据常量类
 */
public class GlobalUtil {

	/**
	 * 以下是email配置信息
	 */
	public static final String MAIL_USER = "lianghy@ichsy.com";
	public static final String MAIL_PWD = "liangzi4454";
	public static final String Host_NAME = "smtp.exmail.qq.com";
	public static final boolean MAIL_IFDEBUG = false;
	public static final String MAIL_CONTENT_CHARSET = "text/html;charset=utf-8";
	public static final String MAIL_ADDRESSEE = "1026163977@qq.com";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");

	public static String getMailTitle(String orderCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(sdf.format(new Date()) + "下的" + orderCode + "订单有问题,请核对该订单");
		return sb.toString();
	}

	public static String getMailContent(String content) {
		StringBuffer sb = new StringBuffer();
		sb.append("<div style='width:1024px;height:auto;margin:0px auto;background-color:#66CCFF;font-size:14px;font-family:微软雅黑;border-radius:5px;padding:5px;'><center><h1>");
		sb.append("</h1></center><div style='margin-left:20px;margin-bottom:10px;'><b>您好！</b><br/><br/>");
		sb.append("&nbsp;&nbsp;&nbsp;&nbsp;<b></b>" + content);
		sb.append("</div></div>");
		return sb.toString();
	}

}