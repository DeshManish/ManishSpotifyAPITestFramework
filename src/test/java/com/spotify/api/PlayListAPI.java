package com.spotify.api;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlayListAPI {

	public static Response post(Playlist requestPlaylist, String token) {
		
		return given(SpecBuilders.reqSpec())
				
				.header("Authorization", "Bearer "+token)

				.body(requestPlaylist)

				.when()

				.post("/users/312ay5mt3ghqbpjyyp4yqnifrnte/playlists")

				.then()

				.spec(SpecBuilders.resSpec())

				.extract()

				.response();
	}
	
	
	public static Response get(String playlistId, String token)
	{
		return given(SpecBuilders.reqSpec())
		 
		.header("Authorization", "Bearer "+token)
				
		 .when()
		 
		 .get("/playlists/"+playlistId)
		 
		 .then()
		 
		 .spec(SpecBuilders.resSpec())
		 
		 .extract()
		 
		 .response();
		
	}
	
	
	public static Response update(String playlistId, Playlist requestPlaylist, String token)
	{
		return given(SpecBuilders.reqSpec())
			
				.header("Authorization", "Bearer "+token)
				
				.body(requestPlaylist)
				
				 .when()
				 		 
				 .put("/playlists/"+playlistId)
				 
				 .then()
				 
				 .extract()
				 
				 .response();
				
	}
	
	
	

}
