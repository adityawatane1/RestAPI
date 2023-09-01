import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class A {
    @Test
	public void create() {
		RequestSpecification reqspeci=RestAssured.given();
		reqspeci.baseUri("https://reqres.in");
		reqspeci.basePath("/api/users");
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "aditya");
		jsondata.put("job", "tester");
		Response res=reqspeci.body(jsondata.toJSONString()).contentType(ContentType.JSON).post();
		System.out.println(res.statusCode());
		System.out.println(res.statusLine());
		System.out.println(res.asPrettyString());
	}
    @Test
    public void createUser() {
    	RestAssured.baseURI="https://reqres.in/api/users";
    	
    	HashMap h=new HashMap();
    	h.put("name", "aditya");
    	h.put("job", "tester");
    	Response res=RestAssured.given().body(h).header("Content-Type","application/json").when().
        post();
    	System.out.println(res.asPrettyString());
    	System.out.println(res.statusCode());
    	
    }
}
