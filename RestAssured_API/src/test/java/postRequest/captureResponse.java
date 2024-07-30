package postRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class captureResponse {

	String id;
	
	@Test(priority=2)
	public void getSingle()
	{
		io.restassured.response.Response res= given()  // Currently not used for Get API
		.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/persons/");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
	}
}
