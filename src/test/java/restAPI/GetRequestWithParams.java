package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {
@Test
	public void getCall() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response response = request.param("id","1").get("/employees");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		//verify the response code
		int resCode = response.getStatusCode();
		AssertJUnit.assertEquals(resCode,200);
		//verify the Headers
		String responseHeader = response.header("Content-Type");
		System.out.println("Response Header :"  + responseHeader);
		System.out.println("All Haeder : " + response.getHeaders());
		AssertJUnit.assertEquals(responseHeader, "application/json; charset=utf-8");
		//verify response body
		AssertJUnit.assertTrue(ResponseBody.contains("Pankaj"));
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("name");
		AssertJUnit.assertEquals(names.get(0),"Pankaj");
		
	}
	
}
