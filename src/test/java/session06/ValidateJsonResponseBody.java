package session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	@Test
	public void userListResponseBody() {

		// get specification referance
		RequestSpecification resspe = RestAssured.given();

		resspe.baseUri("https://reqres.in/");
		resspe.basePath("/api/users?page=2");

		// create get request
		Response response = resspe.get();

		// read response body
		ResponseBody resbody = response.getBody();

		String resString = resbody.asString();
		System.out.println(resString + " response body");

		// check for presence of response body
		Assert.assertEquals(resString.contains("George"), true, " Check for presence of george");
	}

	@Test
	public void userListResponseBody1() {

		// get specification referance
		RequestSpecification resspe = RestAssured.given();

		resspe.baseUri("https://reqres.in/");
		resspe.basePath("/api/users?page=2");

		// create get request
		Response response = resspe.get();

		// read response body
		ResponseBody resbody = response.getBody();
		String resString = resbody.asString();

		// get json path view of response body
		JsonPath jsonpathview = resbody.jsonPath();
		String firstname = jsonpathview.get("data[0].first_name");
		System.out.println("email address " + jsonpathview.get("data[1].avatar"));
		Assert.assertEquals(firstname, "George", "Check for pressence of first name");
	}
}
