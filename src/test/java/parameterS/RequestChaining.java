package parameterS;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class RequestChaining 
{
	@Test
	public void postandGet()
	{
		HashMap h=new HashMap();
		h.put("createdBy", "rrrrrrrr");
		h.put("projectName", "Sravyaaaaaaaaa");
		h.put("status", "Created");
		h.put("teamSize", 19);
		
		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(h)
		
		.when()
		.post("http://localhost:8084/addProject");
		rsps.then().assertThat().statusCode(201).log().all();
		
		String pID = rsps.jsonPath().get("projectId");
		System.out.println(pID);
		
		given()
		.pathParam("proId", pID)
		
		.when()
		.get("http://localhost:8084/projects/{proId}")
		
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
		
		
		
		
		
	}
}
