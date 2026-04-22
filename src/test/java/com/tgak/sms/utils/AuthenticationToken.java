package com.tgak.sms.utils;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

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
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", authenticationToken.getUserName());
		jsonObject.put("password", authenticationToken.getPassword());
		System.out.println(jsonObject);
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		System.out.println(jsonPayload.toString());
		String jwtToken = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin").then().statusCode(200) // Verify successful login
				.extract().path("accessToken"); // Extracts the value of the 'token' field from JSON response
		return jwtToken;
	}

	public String getAuthTokenMethod1(AuthenticationToken authenticationToken) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", authenticationToken.getUserName());
		jsonObject.put("password", authenticationToken.getPassword());
		System.out.println(jsonObject);
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		System.out.println(jsonPayload.toString());
		Response response = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin");
		System.out.println(response.getStatusCode());
		String token = response.jsonPath().getString("accessToken");
		System.out.println(token);
		return token;
	}

	public String getAuthTokenMethod2(AuthenticationToken authenticationToken) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", authenticationToken.getUserName());
		jsonObject.put("password", authenticationToken.getPassword());
		System.out.println(jsonObject);
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		System.out.println(jsonPayload.toString());
		Response response = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin").then().statusCode(200).extract().response();
		String token = response.jsonPath().getString("accessToken");
		System.out.println(token);
		return token;
	}

	public String getAuthTokenMethod3(AuthenticationToken authenticationToken) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", authenticationToken.getUserName());
		jsonObject.put("password", authenticationToken.getPassword());
		System.out.println(jsonObject);
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		System.out.println(jsonPayload.toString());
		String token = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin").then().statusCode(200).extract().response().jsonPath()
				.getString("accessToken");
		return token;
	}

	public void getAuthenticationDetailsAPICall(AuthenticationToken authenticationToken) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", authenticationToken.getUserName());
		jsonObject.put("password", authenticationToken.getPassword());
		System.out.println(jsonObject);
		String jsonPayload = "";
		jsonPayload = jsonObject.toString();
		String statusLine = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin").then().statusCode(200).extract().response()
				.getStatusLine();
		System.out.println(statusLine);
		ResponseBody response = given().header("Content-Type", "application/json").body(jsonPayload).when()
				.post("http://34.68.7.223:8083/api/auth/signin").then().statusCode(200).extract().response().getBody();
		System.out.println(response.asString());
	}

	public static void main(String str[]) {
		AuthenticationToken authenticationToken = new AuthenticationToken("mode", "12345678");
		authenticationToken.getAuthenticationDetailsAPICall(authenticationToken);
	}
}
