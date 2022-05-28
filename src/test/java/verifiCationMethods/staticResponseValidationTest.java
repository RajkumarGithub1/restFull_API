package verifiCationMethods;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class staticResponseValidationTest 
{
	@Test
	public void staticResponse()
	{
		String expData="MT_2";
		
		Response rs = when().get("http://localhost:8084/projects");
		String actData = rs.jsonPath().get("[0].projectName");
		
		Assert.assertEquals(actData, expData);
		
	}
	
	
	@Test
	public void dynamicResponse()
	{
		String expData="def";
		
		List<String> actData=when().get("http://localhost:8084/projects").jsonPath().get("projectName");
		
		for(String s: actData)
		{
			if(s.equals(expData))
			{
				System.out.println("Found`````````````Success");
				break;
				
			}
			
		}
		
		
			
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
