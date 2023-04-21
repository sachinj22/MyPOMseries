package crm.stepdefinitions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restassured_test {
	
	@Test
	public void test1()
	{	
		Response response;
		response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("The reponse is "+response.getStatusCode());
		System.out.println("The time is "+response.getTime());
		System.out.println("body "+response.getBody().asString());
	}

}
