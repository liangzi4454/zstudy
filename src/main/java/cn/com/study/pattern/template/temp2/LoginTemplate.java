package cn.com.study.pattern.template.temp2;

import cn.com.study.pattern.template.temp1.LoginModel;

public class LoginTemplate {
	/**
	 * 判断登陆是否正确
	 * 
	 * @param lm
	 *            用户填写的登陆数据 LoginModel对象
	 * @param callback
	 *            LoginCallback 对象
	 * @return true表示登陆成功，false表示登陆失败
	 */
	public final boolean login(LoginModel lm, LoginCallback callback) {
		LoginModel dbLm = callback.findLoginUser(lm.getUserId());
		if (dbLm != null) {
			String encrytPwd = callback.encrytPwd(lm.getPassword(), this);
			lm.setPassword(encrytPwd);
			return callback.match(lm, dbLm, this);
		}
		return false;
	}

	/**
	 * 对密码进行加密
	 * 
	 * @param password
	 * @return 加密后的密码
	 */
	public String encryptPwd(String password) {
		return password;
	}

	/**
	 * 判断用户填写的登陆数据是否和数据库中的数据匹配
	 * 
	 * @param lm
	 *            用户填写的登陆数据
	 * @param dbLm
	 *            数据库中的数据
	 * @param template
	 *            LoginTemplate 对象
	 * @return true表示匹配成功，false表示匹配失败
	 */
	public boolean macth(LoginModel lm, LoginModel dbLm) {
		if (lm.getUserId().equals(dbLm.getUserId())
				&& lm.getPassword().equals(dbLm.getPassword())) {
			return true;
		}
		return false;
	}
}
