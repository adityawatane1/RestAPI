package session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIKey {
    @Test
	public void getWhetherDatabyCity() {
		//create request specification
		RequestSpecification resSpeci=RestAssured.given();
		resSpeci.baseUri("https://home.openweathermap.org/");
		resSpeci.basePath("/data/2.5/weather");
		resSpeci.queryParam("q", "delhi").queryParam("ammid","b1961f5ca0c6ccbb160192fd0c0a1d2d");
		Response res=resSpeci.get();
		
		Assert.assertEquals(res.statusCode(), 200,"check for status code");
		System.out.println("Response Status Line " + res.statusLine());
		System.out.println("Response body: " + res.asString());
		
	}
}
