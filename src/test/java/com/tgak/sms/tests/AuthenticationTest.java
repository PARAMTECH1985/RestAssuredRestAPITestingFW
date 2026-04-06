package com.tgak.sms.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tgak.sms.utils.AuthenticationToken;

import static io.restassured.RestAssured.*;
import io.qameta.allure.restassured.AllureRestAssured;

public class AuthenticationTest {
	public AuthenticationToken authenticationToken;
	public String token;
	 @BeforeClass
	    public void setUp() {
	        // Initialize once for this class
		authenticationToken = new AuthenticationToken("mode", "12345678");
		token = authenticationToken.getAuthToken(authenticationToken);
	    }
	@Test(groups = { "authentication" })
	public void getAuthenticationGetTestUser() {
		
		given().filter(new AllureRestAssured()).header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token).when().get("http://34.68.7.223:8083/api/test/user").then()
				.statusCode(200);
	}

	@Test(groups = { "authentication" })
	public void getAuthenticationGetTestAll() {
//		AuthenticationToken authenticationToken = new AuthenticationToken("mode", "12345678");
//		String token = authenticationToken.getAuthToken(authenticationToken);
		given().filter(new AllureRestAssured()).header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token).when().get("http://34.68.7.223:8083/api/test/all").then()
				.statusCode(200);
	}

	//@Test(groups = { "authentication" })
	public void getAuthenticationGetTestMod() {
//		AuthenticationToken authenticationToken = new AuthenticationToken("mode", "12345678");
//		String token = authenticationToken.getAuthToken(authenticationToken);
		given().filter(new AllureRestAssured()).header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token).when().get("http://34.68.7.223:8083/api/test/mode").then()
				.statusCode(200);
	}

	//@Test(groups = { "authentication" })
	public void getAuthenticationGetTestAdmin() {
//		AuthenticationToken authenticationToken = new AuthenticationToken("mode", "12345678");
//		String token = authenticationToken.getAuthToken(authenticationToken);
		given().filter(new AllureRestAssured()).header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token).when().get("http://34.68.7.223:8083/api/test/admin").then()
				.statusCode(200);
	}

//    @Test(groups = {"regression"})
//    public void createUserTest() {
//        given()
//            .filter(new AllureRestAssured())
//            .body("{\"name\":\"Rinkoo\",\"job\":\"QA Lead\"}")
//        .when()
//            .post("https://reqres.in/api/users")
//        .then()
//            .statusCode(201);
//    }
}