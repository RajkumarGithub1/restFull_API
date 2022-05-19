package withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class patchProject 
{
	@Test
	public void patchmethod()
	{
		JSONObject job= new JSONObject();
		job.put("createdBy", "Raj Kumarr");
		job.put("projectName", "MT-9");
		job.put("teamSize", 9);
		
		
		
		RequestSpecification reqsp= RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		
		reqsp.body(job);
		
		Response rsp = reqsp.patch("https://reqres.in/api/users/2");
//				.patch("http://localhost:8084/projects/TY_PROJ_602");

		
		
		
		ValidatableResponse valresp = rsp.then();
		valresp.log().all();

		valresp.assertThat().statusCode(200);
		valresp.assertThat().contentType(ContentType.JSON);
	
		
		
	}
}
