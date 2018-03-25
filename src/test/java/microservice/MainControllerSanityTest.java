package microservice;



import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MainControllerSanityTest {
	
	public String URL = "http://localhost:8080/demo/getArticle";

	
	@Test
	public void testCorrectHttpStatusReturned() {
	     
		RestAssured.given()
	       .contentType(ContentType.JSON)
	      // .body(input)
	       .get(URL)
	       .then()
	              .statusCode(HttpStatus.SC_OK);
	}
	       
		@Test
		public void testCorrectHttpMethodNotAllowedPUT()	{
	       RestAssured.given()
	       .contentType(ContentType.JSON)
	       //.body(input)
	       .put(URL)
	       .then()
	       		.statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
		}
		
		@Test
		public void testCorrectHttpMethodNotAllowedDELETE() {
			
		       RestAssured.given()
		       .contentType(ContentType.JSON)
		       .delete(URL)
		       .then()
		              .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
		       
		}

		@Test
		public void testCorrectHttpMethodNotAllowedPOST() {
	       
	       RestAssured.given()
	       .contentType(ContentType.JSON)
	    //   .body(input)
	       .post(URL)
	       .then()
	              .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
	}
		
		@Test
		public void testResponse() {
			final Response response =  RestAssured.given()
					.contentType(ContentType.JSON)
					//.body(input01)
					.get(URL)
					.then()
					.extract()
					.response();
		    System.out.println (response.asString().length());		
		    System.out.println(response.getStatusCode());
		   // AssertTrue(response.asString().length() != 2);
		    Assert.assertEquals(response.asString().length(), 4);
		}


}
