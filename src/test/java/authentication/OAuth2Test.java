package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2Test 
{
	@Test
	public void oauthCoops()
	{
		Response rsp = given()
		.formParam("client_id", "Chickens")
		.formParam("client_secret", "9f4add42e095fff2a368901a25609631")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://chickens.com")
		.post("http://coop.apps.symfonycasts.com/token");
		
		rsp.prettyPrint();	
		
		String token = rsp.jsonPath().get("access_token");
		System.out.println(token+"```````````````````````token``generated````````````==");
		
	
		given()
		.auth()
		.oauth2(token)
		.when()
		.pathParam("U_ID", "3269")
		.post("http://coop.apps.symfonycasts.com/api/{U_ID}/chickens-feed")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
}
