package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonFile {
	@Test
	public void PostCall() throws IOException {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
		String jsonBody = ReadJson("data.json");
		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonBody)
				.post("/employees/create");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		int ResCode = response.getStatusCode();
		AssertJUnit.assertEquals(ResCode,201);
		}
public String ReadJson(String FilePath) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(FilePath)));
		
	}
		
}
