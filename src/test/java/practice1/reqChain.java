package practice1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class reqChain 
{
	@Test
	public void delete()
	{
		Response rsp = given()
		.get("http://localhost:8084/projects");
		
		String id = rsp.jsonPath().get("[1].projectId");
		
		given()
		.pathParam("proID", id)
		.when()
		.delete("http://localhost:8084/projects/{proID}");
		
		
		
	}
}
