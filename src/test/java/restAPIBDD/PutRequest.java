package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	@Test
	public void putCall() {
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("name","john");
		jsonMap.put("salary","90000");
		
		RestAssured.given()
        .baseUri("http://localhost:7000")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(jsonMap)
        .when()
        .put("/employees/17")
        .then()
        .statusCode(200)
	    .body("name",Matchers.equalTo("john"))
	    .body("salary",Matchers.equalTo("90000"))

        .log()
        .body();
	}
}
