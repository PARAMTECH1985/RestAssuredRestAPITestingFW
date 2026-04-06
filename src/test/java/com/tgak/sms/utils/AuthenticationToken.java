package com.tgak.sms.utils;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class AuthenticationToken {
	public String userName;
	public String password;

	public AuthenticationToken(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthToken(AuthenticationToken authenticationToken) {
		// 1. Define the login credentials (can be a JSON string, Map, or POJO)
//		Map<String, Object> payload = new HashMap<>();
//		payload.put("username", authenticationToken.getUserName());
//		payload.put("password", authenticationToken.getPassword());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", authenticationToken.getUserName());
		jsonObject.put("password", authenticationToken.getPassword());
		System.out.println(jsonObject);
		ObjectMapper mapper = new ObjectMapper();
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		System.out.println(jsonPayload.toString());
		Response response = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin");
		// 3. Extract the token from the response body
		System.out.println(response.getStatusCode());
		String token = response.jsonPath().getString("accessToken");
		System.out.println(token);
		return token;
	}
	public static void main(String str[]) {
		AuthenticationToken authenticationToken = new AuthenticationToken("mode", "12345678");
		String token = authenticationToken.getAuthToken(authenticationToken);
		System.out.println(token);
	}

}
