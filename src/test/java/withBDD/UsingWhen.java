package withBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingWhen 
{
	@Test
	public void getProject()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON);
		
		
	}
	
	
	@Test
	public void postProject()
	{
		JSONObject job= new JSONObject();
		job.put("createdBy", "abc kumar");
		job.put("projectName", "MT-171");
		job.put("status", "Created");
		job.put("teamSize", 33);
		
		
		
		
		given()
		
		.contentType(ContentType.JSON)
		.body(job)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(201)
		.and()
		.log().all();
		
	}
	
	@Test
	public void putProject()
	{
		JSONObject job= new JSONObject();
		job.put("createdBy", "cba kumar");
		job.put("projectName", "MT-701");
		job.put("status", "Created");
		job.put("teamSize", 30);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(job)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_802")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all()
		.assertThat().statusCode(200);
		
		
		
		
	}
	
	
	@Test
	public void getsingleProject()
	{
		when()
		.get("http://localhost:8084/projects/TY_PROJ_602")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON);
		
		
	}
	
	
	
	
	@Test
	public void patchProject()
	{
		JSONObject job= new JSONObject();
		job.put("createdBy", "XYZ ltd");
		job.put("projectName", "MT-701");
		job.put("teamSize", 420);
		
		given()
		.contentType(ContentType.JSON)
		.body(job)
		.patch("https://reqres.in/api/users/2")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(200)
		.and()
		.log().all();
		
	}
	
	@Test
	public void deleteProject()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_802")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
		
		
	}
}
