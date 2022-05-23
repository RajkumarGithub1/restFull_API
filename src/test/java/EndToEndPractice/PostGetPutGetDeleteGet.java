package EndToEndPractice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.POJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PostGetPutGetDeleteGet 
{
	@Test
	public void post()
	{
		POJO p=new POJO("sraa56aaaasv", "Srav6aas2633d2nnn", "created", 9);
		
		 Response rsp = given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject");
		 rsp.then().assertThat().statusCode(201);

		 String id = rsp.jsonPath().get("projectId");
		 String pn = rsp.jsonPath().get("projectName");
		 
//		 Response rsp2 = given()
//		 .pathParam("proId", id)
//		 
//		 rsp2.then().assertThat().contentType(ContentType.JSON);
//		 
//		 String pName=rsp2.jsonPath().get("projectName");
//		 
//		 Assert.assertEquals(pName, pn);
//		 
//		 System.out.println("Get method passs");
		 
		 
//		 ``````````````````````
		POJO p2=new POJO("sr5v23789", "Srava427n27891n", "created", 9);

		 Response rsp3 = given()
		 .contentType(ContentType.JSON)
		 .body(p2)
		 .pathParam("proIed", id)
		 .when()
		 .put("http://localhost:8084/projects/{proIed}");
		 
		 
		 String pn2=rsp3.jsonPath().get("projectName");
		 
		 String pn3 = 
			given()
			.pathParam("proIeed", id)
			
		 .get("http://localhost:8084/projects/{proIeed}")
		 .jsonPath().get("projectName");
		 
		 Assert.assertEquals(pn2, pn3);
		 System.out.println("Update Passss");
		 
		
		
		
	}
}
