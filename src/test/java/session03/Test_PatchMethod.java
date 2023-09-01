package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchMethod {
@Test
	public void test05() {
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name", "niraj");
		jsonobject.put("job", "tester");
		
		RestAssured.baseURI="https://reqres.in/api/users/52";
		RestAssured.given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonobject.toJSONString()).when().patch()
		.then().statusCode(200).log().all();
	}
}
