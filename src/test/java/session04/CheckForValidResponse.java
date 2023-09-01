package session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
    @Test
	public void getSingleUser() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		//get request specification of request
		RequestSpecification reqspeci=RestAssured.given();
		
		//call get method
		Response res=reqspeci.get();
		
		//get response code
		int statuscode=res.getStatusCode();
		
		//validate actual stuatus code with expected
		Assert.assertEquals(statuscode, 200,"correct status code received");
		
		
		String statusLine=res.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","Incorrect status code received");
	}
    @Test
public void getSingleUserUsingvalidatableResponse() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		//get request specification of request
		RequestSpecification reqspeci=RestAssured.given();
		
		//call get method
		Response res=reqspeci.get();
		
		ValidatableResponse valid= res.then();
		
		//status code
		valid.statusCode(200);
		
		//status line
		valid.statusLine("HTTP/1.1 200 OK");
		
	}
   @Test 
public void getSingleUser_BDDStyle() {
		
		RestAssured.given().
		
		when().
		    get("https://reqres.in/api/users/2").
	
		then().
		  statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		  .log().all();
		
	}
}
