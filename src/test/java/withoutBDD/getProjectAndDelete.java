package withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getProjectAndDelete 
{
	@Test
	public void getAndDelete()
	{
		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_209");

//		Response res = RestAssured.get("http://localhost:8084/projects/TY_PROJ_209");

//		res.prettyPrint();
		ValidatableResponse vri = res.then();
		vri.log().all();
		
		vri.assertThat().statusCode(204);
		vri.assertThat().contentType(ContentType.JSON);
		
		
	}
}
