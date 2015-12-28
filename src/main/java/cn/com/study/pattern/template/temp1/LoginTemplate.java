package cn.com.study.pattern.template.temp1;

public abstract class LoginTemplate {
	public abstract LoginModel findLoginUser(String userId);
	
	public String encryptPwd(String password) {
		return password;
	}
	
	public boolean match(LoginModel m1, LoginModel m2) {
		if(m1.getUserId().equals(m2.getUserId()) && m1.getPassword().equals(m2.getPassword())) {
			return true;
		}
		return false;
	}

	public final boolean login(LoginModel lm) {
		LoginModel dblm = this.findLoginUser(lm.getUserId());
        if(dblm != null){
             String encryPwd = this.encryptPwd(lm.getPassword());
             lm.setPassword(encryPwd);
             return this.match(lm, dblm);
        }
        return false;
	}
}
