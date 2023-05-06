package crm.stepdefinitions;

import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExamples {
	
	@Test
	public void testGet()
	{
		baseURI = "https://reqres.in/api/";
		
		given().
			get("users?page=2").
		then().
			statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George", "Rachel")).
		and().body("data[0].email", equalTo("michael.lawson@reqres.in")).
		and().body("data[3].last_name", equalTo("Fields")).
		and().body("data[1].id", equalTo(8)).log().all();
		
	}
	
	@Test
	public void testPost()
	{
		Map<String,Object> m = new HashMap<String,Object>();
//		m.put("name", "Sachin");
//		m.put("job", "Software Engineer");
//		baseURI = "https://reqres.in/api/";
		JSONObject request = new JSONObject();
		request.put("name", "Sachin");
		request.put("job", "Software Engineer");
		
		given().
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").then().statusCode(201);
	}

}
