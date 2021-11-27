package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteCall {
	@Test
	public void deleteCall() {
		
		RestAssured.given()
        .baseUri("http://localhost:7000")
        .when()
        .delete("/employees/17")
        .then()
        .statusCode(200)
        .log()
        .all();
}
}
