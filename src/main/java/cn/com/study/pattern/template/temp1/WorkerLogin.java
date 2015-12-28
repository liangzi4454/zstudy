package cn.com.study.pattern.template.temp1;

public class WorkerLogin extends LoginTemplate {

	
	public LoginModel findLoginUser(String userId) {
		 LoginModel lm = new LoginModel();
         lm.setUserId(userId);
         lm.setPassword("workerpwd");
         return lm;
	}

	
	public String encryptPwd(String password) {
		return password;
	}
	
}
