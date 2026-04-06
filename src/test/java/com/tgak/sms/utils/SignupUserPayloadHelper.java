package com.tgak.sms.utils;

import org.json.JSONObject;

public class SignupUserPayloadHelper {
	public String emailId;

	public SignupUserPayloadHelper(String emailId, String password, String userName) {

		this.emailId = emailId;
		this.password = password;
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String password;
	public String userName;

	public String getPayloadForSignupUser(SignupUserPayloadHelper signupUserPayloadHelper) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", signupUserPayloadHelper.getEmailId());
		jsonObject.put("password", signupUserPayloadHelper.getPassword());
		jsonObject.put("username", signupUserPayloadHelper.getUserName());
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		return jsonPayload;

	}

}
