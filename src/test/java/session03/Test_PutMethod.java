package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {
@Test
	public void test04() {
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name", "Shiteal");
		jsonobject.put("job", "teacher");
		
		RestAssured.baseURI="https://reqres.in/api/users/52";
		RestAssured.given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonobject.toJSONString()).when().put()
		.then().statusCode(200).log().all();
	}
}
