package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonObject {
@Test
	public void PostCall() {
	RestAssured.baseURI="http://localhost:7000";
	RequestSpecification request = RestAssured.given();
	JSONObject jobj = new JSONObject();
	jobj.put("name","sriyansh");
	jobj.put("salary","4000");
	
	Response response = request.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jobj.toString())
			.post("/employees/create");
	String ResponseBody = response.getBody().asString();
	System.out.println(ResponseBody);
	int ResCode = response.getStatusCode();
	AssertJUnit.assertEquals(ResCode,201);
	}
	
}
