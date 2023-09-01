package session11;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoOauth {
    @Test
	public void Oauth2demo() {
		String clientId="Af6ZaIMAoqOuIxowdFXue-DagBIO-16R84vyhxBkAIGynL8IIuTrue3qP3wAOMAZ 52q5V31240sxkoP";
		String clientsecrete="EBWhSkucLCxYHILbnQiAHeG6fpz4cFZ1YH4mNXj16092BdZkSTreiLZW_nгSIVKYylpaQ260VtaJAQd6";
		RequestSpecification reqspeci=RestAssured.given();
		
		reqspeci.baseUri("https://api-m.sandbox.paypal.com");
		reqspeci.basePath("/v1/oauth2/token");
		
		Response res=reqspeci.auth().preemptive().basic(clientId, clientsecrete).param("grant_type", "client_credentials").post();
		res.prettyPrint();
		
		System.out.println("Response code "+res.statusCode());
		System.out.println("Status line "+res.statusLine());
		Assert.assertEquals(res.statusCode(), 401);
	}
}
