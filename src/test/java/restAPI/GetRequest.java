package restAPI;

import org.testng.annotations.Test;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
@Test
	public void GetCall() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/employees");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("name");
		System.out.println(names);
		for(int i = 0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
		
	}
}
