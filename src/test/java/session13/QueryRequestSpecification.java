package session13;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {
    @Test
	public void createUser() {
    	JSONObject data=new JSONObject();
		data.put("name", "aditya");
		data.put("job", "Tester");
    	
    	
    	RequestSpecification resqSpci=RestAssured.given();
		resqSpci.baseUri("https://reqres.in")
		.basePath("/api/users").contentType(ContentType.JSON)
		.body(data.toJSONString());
		
		//query details from request specification
		QueryableRequestSpecification qureyreq=SpecificationQuerier.query(resqSpci);
		
		//get base uri
		String retrivebaseuri=qureyreq.getBaseUri();
		System.out.println("base URI: "+retrivebaseuri);
		
		//get base path
				String retrivebasepath=qureyreq.getBasePath();
				System.out.println("base Path: "+retrivebasepath);
				
				//get base body
				String retrivebody=qureyreq.getBody();
				System.out.println("base body: "+retrivebody);
				
				//get request header
				Headers allheader=qureyreq.getHeaders();
				for (Header h : allheader) {
					System.out.println(h.getName()+"==>"+h.getValue());
				}
	}
}
