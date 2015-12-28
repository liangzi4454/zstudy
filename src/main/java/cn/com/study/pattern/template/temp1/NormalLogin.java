package cn.com.study.pattern.template.temp1;

public class NormalLogin extends LoginTemplate {

	
	public LoginModel findLoginUser(String userId) {
		 LoginModel lm = new LoginModel();
         lm.setUserId(userId);
         lm.setPassword("testpwd");
         return lm;
	}

}
