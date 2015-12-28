package cn.com.study.pattern.template.temp1;

public class ClientTest {
	public static void main(String[] args) {
		LoginModel lm = new LoginModel();
		lm.setUserId("admin");
		lm.setPassword("workerpwd");

		LoginTemplate lt = new WorkerLogin();
		LoginTemplate lt2 = new NormalLogin();

		boolean flag = lt.login(lm);
		System.out.println("可以登陆工作平台=" + flag);
		boolean flag2 = lt2.login(lm);
		System.out.println("可以普通人员登陆=" + flag2);
	}
}
