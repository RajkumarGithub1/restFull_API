package withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostAndPut 
{
	@Test
	public void Post()
	{
		JSONObject job= new JSONObject();
		job.put("createdBy", "Rajkumaaaar");
		job.put("projectName", "MT-1916");
		job.put("status", "Created");
		job.put("teamSize", 11);
		
		
		RequestSpecification reqsp= RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		
		reqsp.body(job);
		
		Response rsp = reqsp.post("http://localhost:8084/addProject");

		ValidatableResponse valresp = rsp.then();
		valresp.log().all();

		valresp.assertThat().statusCode(201);
		valresp.assertThat().contentType(ContentType.JSON);
	
	
		
	}
	
	@Test
	public void put()
	{
		JSONObject job= new JSONObject();
		job.put("createdBy", "Rajkumar");
		job.put("projectName", "MT-1997");
		job.put("status", "Created");
		job.put("teamSize", 10);
		
		
		RequestSpecification reqsp= RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		
		reqsp.body(job);
		
		Response rsp = reqsp.put("http://localhost:8084/projects/TY_PROJ_602");

		ValidatableResponse valresp = rsp.then();
		valresp.log().all();

		valresp.assertThat().statusCode(200);
		valresp.assertThat().contentType(ContentType.JSON);
	
	}
}
