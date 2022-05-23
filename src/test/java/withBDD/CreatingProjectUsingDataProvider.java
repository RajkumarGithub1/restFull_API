package withBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLib.POJO;
import io.restassured.http.ContentType;

public class CreatingProjectUsingDataProvider 
{
	@Test(dataProvider = "getMultpleData")
	public void createProjectfromDataProvider(String createdBy, String projectName, String status, int teamSize)
	{
		POJO p=new POJO(createdBy, projectName, status, teamSize);

		given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().log().all()
		.and()
		.assertThat().statusCode(201);
	}
	
	
	@DataProvider
	public Object getMultpleData()
	{
		Object[][] ob=new Object[2][4];
		
		
		ob[0][0]="Sravyaaaaa";
		ob[0][1]="New MTt";
		ob[0][2]="created";
		ob[0][3]=5;
		
		ob[1][0]="Sravyaaaaaaas";
		ob[1][1]="New MTTTTTt";
		ob[1][2]="created";
		ob[1][3]=5;
		
		
		return ob;
		
		
	}
	
}
