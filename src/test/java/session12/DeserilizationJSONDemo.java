package session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserilizationJSONDemo {
    @Test
	public void createUser() {
		RequestSpecification resspeci=RestAssured.given();
		resspeci.baseUri("https://reqres.in");
		resspeci.basePath("/api/users");
		
		//create Request body
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "aditya");
		jsondata.put("job", "QA");
		
		//perform post request
		Response res=resspeci.contentType(ContentType.JSON).
		body(jsondata.toJSONString()).post();
		
		ResponseBody resbody=res.getBody();
		
		//deserialize response body i.e json response body to class object
		JSONPostRequestResponse resclass=resbody.as(JSONPostRequestResponse.class);
		Assert.assertEquals(resclass.name, "aditya","check for name");
		Assert.assertEquals(resclass.job, "QA","check for job");
	}
}
