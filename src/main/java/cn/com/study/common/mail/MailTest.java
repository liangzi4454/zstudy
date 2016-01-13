package cn.com.study.common.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Test;

public class MailTest {
	@Test
	public void testSend() {
		MailSender mail = new MailSender(GlobalUtil.Host_NAME,GlobalUtil.MAIL_USER, GlobalUtil.MAIL_PWD);
		Mail content = new Mail();
		content.setSubject(GlobalUtil.getMailTitle("订单异常"));
		content.setContent(GlobalUtil.getMailContent("订单编号为：OS123有异常,请校验核对!"));
		try {
			mail.send("1026163977@qq.com", content);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
