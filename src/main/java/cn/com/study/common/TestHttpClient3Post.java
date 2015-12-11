package cn.com.study.common;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 测试模拟request post发送短信
 * @author LHY
 * 2015年12月11日 下午4:28:26
 */
public class TestHttpClient3Post {

	// private static Logger logger = Logger.getLogger("myLogger");

	public static void main(String[] args) throws Exception {
//		test1();
		test2();
	}
	public static void test1() throws Exception {
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";
		
//		String[] a = {"18612363312","18901701776", "18610436326", "18801330933", "13522283810", "15901357003"};
		String[] a = {"15010514454"};
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i=0; i<a.length; i++) {
			String date = format.format(new Date());
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new NameValuePair("sn", "SDK-BBX-010-23350"));
			params.add(new NameValuePair("pwd", MD5Util.MD5("SDK-BBX-010-23350"+"53@f6bb@")));
			params.add(new NameValuePair("mobile", a[i]));
			params.add(new NameValuePair("content", URLEncoder.encode("测试：您的注册验证码为123456,发送时间为:"+date+"[惠家有]", "UTF-8")));
			params.add(new NameValuePair("ext", ""));
			params.add(new NameValuePair("stime", ""));
			params.add(new NameValuePair("rrid", ""));
			params.add(new NameValuePair("msgfmt", ""));
			String result = TestHttpClient3Post.request(url, params.toArray(new NameValuePair[params.size()]));
			System.out.println(result);
		}
	}
	public static void test2() {
		String url = "https://a1.easemob.com/ihesen-appid/testappdemo/users";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new NameValuePair("username", "LHY"));
		params.add(new NameValuePair("password", "LHY"));
		String result = TestHttpClient3Post.request(url, params.toArray(new NameValuePair[params.size()]));
		System.out.println(result);
	}
	public static String request(String url, NameValuePair[] params) {
		String result = null;
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestBody(params);
		int statusCode = 0;
		try {
			statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				result = postMethod.getResponseBodyAsString();
				return result;
			} 
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		postMethod.releaseConnection();
		return result;

	}
	
	public static final String ADD_URL = "https://a1.easemob.com/ihesen-appid/testappdemo/users";
	
	
}
