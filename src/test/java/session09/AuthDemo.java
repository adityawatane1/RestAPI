package session09;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthDemo {
    @Test
	public void bearertoken() {
		RequestSpecification resquestSpecifi=RestAssured.given();
		
		resquestSpecifi.baseUri("https://gorest.co.in");
		resquestSpecifi.basePath("/public/v2/users");
		
		JSONObject payload=new JSONObject();
		payload.put("name","prachi");
		payload.put("gender", "female");
		payload.put("email", "parchi@gmail.com");
		payload.put("status", "active");
		
		String AuthToken="Bearer 9952094eae780059201300360068d36a836fb576634370775abfdb5d6178b0cf";
		
		resquestSpecifi.header("Authorization",AuthToken).contentType(ContentType.JSON).body(payload.toJSONString());
		Response res=resquestSpecifi.post();
		
		Assert.assertEquals(res.statusCode(), 201,"check for status code");
		System.out.println("Response Status Line " + res.statusLine());
		System.out.println("Response body: " + res.asString());
	}
}
