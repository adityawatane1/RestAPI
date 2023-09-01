package session08;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	@Test
	public void basicAuth() {
		RequestSpecification requestSpeci = RestAssured.given();

		requestSpeci.baseUri("https://postman-echo.com");
		requestSpeci.basePath("/basic-auth");

		Response res = requestSpeci.auth().basic("postman", "password").get();
		System.out.println("Response Status Line " + res.statusLine());
		System.out.println("Response body: " + res.asString());
	}

	@Test
	public void digestAuth() {
		RequestSpecification requestSpeci = RestAssured.given();

		requestSpeci.baseUri("https://httpbin.org");
		requestSpeci.basePath("/digest-auth/undefined/prachi/prachi");

		Response res=requestSpeci.auth().digest("prachi", "prachi").get();

		Assert.assertEquals(res.statusCode(), 200,"check for status code");
		System.out.println("Response Status Line " + res.statusLine());
		System.out.println("Response body: " + res.asString());
	}
}
