package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PostMethod {
@Test
	public void test03() {
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name", "prachi");
		jsonobject.put("job", "QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonobject.toJSONString()).when().post()
		.then().statusCode(201).log().all();
	}
}
