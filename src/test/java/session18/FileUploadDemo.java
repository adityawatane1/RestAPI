package session18;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo {
    @Test
	public void uploadFile() {
		//Create File object
    	File fileupload=new File("C:\\Users\\hp\\Desktop\\github.txt");
    	File fileupload2=new File("C:\\Users\\hp\\Desktop\\github.txt");
    	RequestSpecification reqSpecification=RestAssured.given();
    	
    	reqSpecification.baseUri("https://httpbin.org/post");
    	reqSpecification.multiPart("files",fileupload);
    	reqSpecification.multiPart("files",fileupload2);
    	
    	
    	reqSpecification.contentType("multipart/form-data");
    	Response res=reqSpecification.post();
    	
    	res.prettyPrint();
    	Assert.assertEquals(res.statusCode(), 200);
	}
    @Test
    public void uploadImage() {
    	File fileupload=new File("C:\\Users\\hp\\Desktop\\Untitled.png");
RequestSpecification reqSpecification=RestAssured.given();
    	
    	reqSpecification.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
    	reqSpecification.multiPart("file",fileupload);
    	
    	
    	
    	reqSpecification.contentType("multipart/form-data");
    	Response res=reqSpecification.post();
    	
    	res.prettyPrint();
    	Assert.assertEquals(res.statusCode(), 200);
    }
}
