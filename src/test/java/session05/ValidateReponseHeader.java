package session05;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateReponseHeader {
@Test
	public void getSingleUser() {
		RequestSpecification resqspe=RestAssured.given();
		
		//specify base uri
		resqspe.baseUri("https://reqres.in");
		resqspe.basePath("/api/users/2");
		//create get request
		Response res=resqspe.get();
		
		//validate response header
		String contenttype=res.header("Content-Type");
		System.out.println(contenttype);
		
		Headers headerList=res.getHeaders();
		for (Header header2 : headerList) {
			System.out.println("Key:- "+header2.getName() +" Values:- "+header2.getValue());
		}
		
		Assert.assertEquals(contenttype, "application/json; charset=utf-8","Header type is mismatched");
	}
}
