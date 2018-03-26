package microservice;



import org.apache.http.HttpStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;



public class MainControllerSanityTest {
	
	public String URL = "http://localhost:8080/demo/getArticle";

	
	@Test
	public void testCorrectHttpStatusReturned() {
	     
		RestAssured.given()
	       .contentType(ContentType.JSON)
	       .get(URL)
	       .then()
	              .statusCode(HttpStatus.SC_OK);
	}
	       
		@Test
		public void testCorrectHttpMethodNotAllowedPUT()	{
	       RestAssured.given()
	       .contentType(ContentType.JSON)
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
	       .post(URL)
	       .then()
	              .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
	}
		
		@Test
		public void testResponse() {
			final Response response =  RestAssured.given()
					.contentType(ContentType.JSON)
					.get(URL)
					.then()
					.extract()
					.response();
		    Assert.assertEquals(response.asString().length(), 2);
		}


}
