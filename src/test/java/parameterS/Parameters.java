package parameterS;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Parameters 
{
	@Test
	public void pathParam()
	{
		given().pathParam("proID", "TY_PROJ_811")
		.when()
		.get("http://localhost:8084/projects/{proID}")
		.then()
		.log().all();
	}
	
	
	
	@Test
	public void queryParam()
	{
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.all();	
		
	}
	
	@Test
	public void gitParameter()
	{
		given()
		.pathParam("username", "RajkumarGitHub1")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log()
		.all();
	}
	
	
	
	//query params work auto
	
}