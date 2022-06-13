package EndToEndPractice;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericLib.BaseAPIclass;
import genericLib.DatabaseUtils;
import genericLib.EndPoints;
import genericLib.JavaUtil;
import genericLib.POJO;

public class EndToEndscenario extends BaseAPIclass
{

	
	
	@Test
	public void endtoendScenario() throws Throwable 
	{
		baseURI="http://localhost";
		port=8084;
		
		JavaUtil jut=new JavaUtil();
		
		
		POJO p=new POJO("sravya020 ", "Sd"+jut.getrandomNumber()+"", "created", 10);
		
		
		System.out.println(EndPoints.createProject);
		Response rsp = 
				given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post(EndPoints.createProject);
		
		
		String proID = rsp.jsonPath().get("projectId");
		System.out.println(proID+"----id");
		
		
		
		Response rsp1 = given()
		.pathParam("projectID", proID)
		
		.when().get(EndPoints.getAllProjects+"{projectID}");
		
		String prName = rsp1.jsonPath().get("projectName");
		
		System.out.println(prName);
		
		rsp1.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
			
		
		ResultSet result = dutil.executeQueryInStatement("select * from project where project_name='"+prName+"'");
		
		
			while (result.next())
			{
				String projecID = result.getString(1);
				Assert.assertEquals(projecID, proID);
				System.out.println("Database Verified, Both are matched");
				
			}
 
	}
}
