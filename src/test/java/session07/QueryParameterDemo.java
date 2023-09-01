package session07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {
@Test
	public void filterData() {
		//get request specification for given request
		RequestSpecification resSpecification=RestAssured.given();
		
		//specify url
		resSpecification.baseUri("https://reqres.in");
		resSpecification.basePath("/api/users");
		resSpecification.queryParam("page", 2).queryParam("id", 10);
		
		//perform get request
		Response res=resSpecification.get();
		
		//read response body print response body
		String resbodystring=res.getBody().asString();
		System.out.println("Response Body "+resbodystring);
		
		JsonPath jsonpathview=res.jsonPath();
		
		//get the firstname
		String firstName=jsonpathview.get("data.first_name");
		Assert.assertEquals(firstName, "Byron","verify first name");
	}
}
