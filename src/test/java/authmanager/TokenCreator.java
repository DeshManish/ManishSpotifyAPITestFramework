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
		param.put("refresh_token", "refresh token-nyGprzTHzY-laRzn-Fa_8TAdXmAqEp6vMOntXxGphh4mJsDuMRq6dtIPM8TUZI");
		param.put("client_id", "enter cient id");
		param.put("client_secret", "enter client secret ");
		
		
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
