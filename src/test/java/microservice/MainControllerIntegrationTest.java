package microservice;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MainControllerIntegrationTest {

	private static final Integer ARTICLE = 100;
	private static final Integer STOCK = 1;
	public String URL1 = "http://localhost:8080/demo/addArticle?article="+ARTICLE+"&stock="+STOCK;
	public String URL2 = "http://localhost:8080/demo/getArticle";
	public static String output_for_add = "Stock succesfuly saved for article = "+ARTICLE;
	public static String output_for_get = "[{\"id\":1,\"stock\":"+STOCK+",\"article\":"+ARTICLE+"}]";
	@Test
	public void testAddAdrticleWithStock() {
		final Response response =  RestAssured.given()
				.contentType(ContentType.JSON)
				.get(URL1)
				.then()
				.extract()
				.response();
	    System.out.println (response.asString());		
		assertTrue(response.asString().equals(output_for_add));
	}
	
	@Test
	public void testGetAllArticlesfromDatabase() {
		final Response response =  RestAssured.given()
				.contentType(ContentType.JSON)
				.get(URL2)
				.then()
				.extract()
				.response();
	    System.out.println (response.asString());		
		assertTrue(response.asString().equals(output_for_get));
	}
}
