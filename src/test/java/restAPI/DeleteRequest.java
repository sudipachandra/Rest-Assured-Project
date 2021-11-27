package restAPI;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	@Test
	public void deleteCall() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/employees/6");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
	}
	
}
