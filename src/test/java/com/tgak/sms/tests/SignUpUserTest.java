package com.tgak.sms.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tgak.sms.utils.AuthenticationToken;
import com.tgak.sms.utils.SignupUserPayloadHelper;

import static io.restassured.RestAssured.*;
import io.qameta.allure.restassured.AllureRestAssured;

public class SignUpUserTest {
	public SignupUserPayloadHelper signupUserPayloadHelper;
	public String payload;

	@BeforeClass
	public void setUp() {
		// Initialize once for this class
		signupUserPayloadHelper = new SignupUserPayloadHelper("kushwah.rinkoo@yahoo1.com", "123456780", "kushwah1");
		payload = signupUserPayloadHelper.getPayloadForSignupUser(signupUserPayloadHelper);
	}

	@Test(groups = { "signUpUser" })
	public void signUpUserTest() {
		given().filter(new AllureRestAssured()).header("Content-Type", "application/json").body(payload)
				.post("http://34.68.7.223:8083/api/auth/signup")
				.then().statusCode(200);
	}
}