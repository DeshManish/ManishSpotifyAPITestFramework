package authmanager;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TokenCreator {
	
	
	public static String renewToken()
	{
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "AQBkmOm2n3lwL13AygkP1Q5G5OR6e32ffHn8ObNIR0_M7lEyoWs3BTHvCHMXb5749EgS-nyGprzTHzY-laRzn-Fa_8TAdXmAqEp6vMOntXxGphh4mJsDuMRq6dtIPM8TUZI");
		param.put("client_id", "216fe354a8fd4452acb6fb3261b5f157");
		param.put("client_secret", "d87d32147c764a60ab40623002c13a20");
		
		
		RestAssured.baseURI = "https://accounts.spotify.com";
		
		Response response = given()
		.contentType(ContentType.URLENC)
		
		.formParams(param)
		
		.when()
		
		.post("/api/token")
		
		.then()
		
		.extract()
		
		.response();
		
		if(response.statusCode()!=200)
		{
			throw new RuntimeException("Failed to create the access token");
		}
		
		
		 String token = response.path("access_token");
		 
		 return token;
		
		
	}

}
