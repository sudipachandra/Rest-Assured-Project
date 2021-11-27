package RestAPIChaining;

import org.testng.annotations.Test;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	String ResponseBody;
	String ResponseId;
@Test
	public void test1() {
		//get call
	RestAssured.baseURI="http://localhost:7000";
	RequestSpecification getRequest = RestAssured.given();
	Response GetResponse = getRequest.get("/employees");
	ResponseBody = GetResponse.getBody().asString();
	System.out.println(ResponseBody);
	//post call
	RequestSpecification postRequest = RestAssured.given();
	JSONObject jobj = new JSONObject();
	jobj.put("name","Chris");
	jobj.put("salary","4000");
	
	Response postResponse = postRequest.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jobj.toString())
			.post("/employees/create");
  ResponseBody = postResponse.getBody().asString();
	System.out.println(ResponseBody);
	JsonPath jpath = postResponse.jsonPath();
	//List<Integer> ids = jpath.get("id");
	ResponseId = jpath.get("id").toString();
	System.out.println("ID coming from response is: "+ResponseId);
	//Put Call
	RequestSpecification putRequest = RestAssured.given();
	
	jobj.put("name","Chris1");
	jobj.put("salary","4000");
	
	Response putResponse = postRequest.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jobj.toString())
			.put("/employees/"+ResponseId);
  ResponseBody = putResponse.getBody().asString();
	System.out.println(ResponseBody);
	//Delete call
	RequestSpecification deleteRequest = RestAssured.given();
	Response deleteResponse = deleteRequest.delete("/employees/"+ResponseId);
	String ResponseBody = deleteResponse.getBody().asString();
	System.out.println(ResponseBody);
	
	}
}
