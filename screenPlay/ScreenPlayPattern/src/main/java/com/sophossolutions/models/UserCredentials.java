package com.sophossolutions.models;

public class UserCredentials {

	private String strUser;
	private String strPassword;

	public UserCredentials(String strUser, String strPassword) {
		super();
		this.strUser = strUser;
		this.strPassword = strPassword;
	}

	public String getStrUser() {
		return strUser;
	}

	public void setStrUser(String strUser) {
		this.strUser = strUser;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return strUser+" "+strPassword;
	}

}
