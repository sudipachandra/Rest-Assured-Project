package restAPIXML;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLRequest {
	@Test
	public void test1() {
		RestAssured.given()
		           .baseUri("https://chercher.tech/sample/api/books.xml")
		           
		           .when()
		           .get()
		           .then()
		           .statusCode(200)
		           .log()
		           .body();
	}
	@Test
	public void test2() {
		
		Response response = RestAssured.given()
		           .baseUri("https://chercher.tech/sample/api/books.xml")
		           .when()
		           .get();
		String Books = response.then().extract().xmlPath().getString("bookstore.book.title");
		System.out.println(Books);
		
	}
	
	@Test
	public void test3() {
		
		Response response = RestAssured.given()
		           .baseUri("https://chercher.tech/sample/api/books.xml")
		           .when()
		           .get();
		
		NodeChildrenImpl Books = response.then().extract().path("bookstore.book.title");
		
		String actTitle = Books.get(1).toString();
		String expTitle = "Harry Potter";
		
		System.out.println("the actual title is: " + actTitle);
		Assert.assertEquals(actTitle, expTitle);
		
	}
	
}

