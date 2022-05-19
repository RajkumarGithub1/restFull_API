package withBDD;

import org.testng.annotations.Test;

import generic.POJO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

public class Diff_WaysOfCreatingProject 
{
	@Test
	public void createfromHashMap()
	{
		HashMap h=new HashMap();
		h.put("createdBy", "abcdefg");
		h.put("projectName", "MT-0012");
		h.put("status", "Created");
		h.put("teamSize", 1);
		
		given()
		.contentType(ContentType.JSON)
		.body(h)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().log().all();
		
		
	}
	
	
	@Test
	public void createfromJSONFile()
	{
		File f=new File("./file.json");
		
				given()
				.contentType(ContentType.JSON)
				.body(f)
				.when()
				.post("http://localhost:8084/addProject")
				.then()
				.assertThat().statusCode(201)
				.and()
				.assertThat().log().all();
					
				
	}

	
	
	
	@Test
	public void createfromPOJO()
	{
		POJO p1=new POJO("Rajkumare4er", "LatestProjecthero", "created", 15);

		given()
		.contentType(ContentType.JSON)
		.body(p1)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().log().all()
		.and()
		.assertThat().statusCode(201);
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
