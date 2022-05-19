package practice1;

import generic.POJO;
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

public class EndToEndscenario
{
	@Test
	public void endtoendScenario() throws SQLException
	{
		POJO p=new POJO("sravya020 ", "Sravya0208", "created", 10);
		
		
		Response rsp =
				given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject");
		
//		rsp.then()
//		.assertThat().statusCode(201)
//		.assertThat().contentType(ContentType.JSON)
//		.log().all();
		
		String proID = rsp.jsonPath().get("projectId");
		System.out.println(proID+"----id");
		
		
		
		Response rsp1 = given()
		.pathParam("projectID", proID)
		
		.when().get("http://localhost:8084/projects/{projectID}");
		
		String prName = rsp1.jsonPath().get("projectName");
		
		System.out.println(prName);
		
		rsp1.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		
		
//		Data Verification from database
//		```````````````````````````````
		
		System.out.println(":------------------------------------------------------:");
		Connection con=null;
		try {
			// register the Driver
			Driver dref= new Driver();
			DriverManager.registerDriver(dref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
			//Create a statement
			Statement stmt = con.createStatement();
		
			//Execute the query
			ResultSet result = stmt.executeQuery("select * from project where project_name='"+prName+"'");
			
			while (result.next())
			{
				String projecID = result.getString(1);
				Assert.assertEquals(projecID, proID);
				System.out.println("Database Verified, Both are matched");
				
			}
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			finally 
			{
			//close the connection
			con.close();
			}
	}
}
