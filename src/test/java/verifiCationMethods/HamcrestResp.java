package verifiCationMethods;

import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HamcrestResp 
{
	@Test
	public void HamcrestResponse()
	{
		when().get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(2L), TimeUnit.SECONDS)
		.assertThat().body("[1].projectName", Matchers.equalTo("MT-0452"))
		.log().all();
		
	
		}
}
