package session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GetMethod {
	@Test
	public void test01() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response code: " + res.getStatusCode());
		System.out.println("Response body " + res.getBody().asString());
		System.out.println("Response Time " + res.getTime());
		System.out.println("Response Header " + res.getHeader("Content-Type"));

		int expectedStatuscode = 200;
		int stutuscode = res.getStatusCode();
		Assert.assertEquals(expectedStatuscode, stutuscode);
	}
	
     @Test
	public void test02() {
    	 //given,when,then
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
		
	}
}
