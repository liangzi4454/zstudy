package cn.com.study.pattern.template.temp2;

import cn.com.study.pattern.template.temp1.LoginModel;

public abstract class AbstractLoginCallback implements LoginCallback {

	
	public LoginModel findLoginUser(String userId) {
		return null;
	}

	
	public String encrytPwd(String password, LoginTemplate template) {
		return null;
	}

	
	public boolean match(LoginModel lm, LoginModel dbLm, LoginTemplate template) {
		return false;
	}

}
