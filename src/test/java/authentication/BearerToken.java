package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		
		given()
		.auth()
		.oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
		
	}
}
