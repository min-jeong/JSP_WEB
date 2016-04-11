package com.ktds.jmj;

public class LoginBizImpl implements LoginBiz {
	
	private LoginDAO loginDAO;
	
	/**
	 * setter만 만들어준다.
	 * @param loginDAO
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public boolean login() {
		return loginDAO.login();
	}
	
	
}
