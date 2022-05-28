package verifiCationMethods;

import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class HamcrestResp 
{
	@Test
	public void HamcrestResponse()
	{
		when().get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(200L), TimeUnit.SECONDS)  //200L is because 200 in Long data type
		.assertThat().body("[1].projectName", Matchers.equalTo("MT-0452"))
		.log().all();
		
	
		}
}
