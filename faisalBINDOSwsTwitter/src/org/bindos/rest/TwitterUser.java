package org.bindos.rest;

import org.json.simple.parser.JSONParser;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class TwitterUser {
	final static String API_KEY = "XqFfYv10yTHujuG7xWIJIhibC";
	final static String API_SECRET_KEY = "tVe6O4Y6XZj0QseSqPa9NdztFUV8ytykIGAZgykdMaaVqkyfwg";
	final static String TOKEN_KEY = "286183022-utrJWAyRy3ZtAFSyfvC9Pruw96sTO9193vXQ56dJ";
	final static String TOKEN_SECRET_KEY = "yfKN8TqX7Wg4DXjl6C4BhrHCSsKNlLa9aaReJRgXR5bBZ";

	public String getResponse(String url) {
		
		OAuthService service = new ServiceBuilder()
				.provider(TwitterApi.SSL.class)
				.apiKey(API_KEY)
				.apiSecret(API_SECRET_KEY)
				.build();
				
		Token accessToken = new Token(TOKEN_KEY,TOKEN_SECRET_KEY);
		
		OAuthRequest request = new OAuthRequest(Verb.GET,url);
		
		service.signRequest(accessToken, request);
		
		Response response = request.send();
		
		return response.getBody();
	}
	
public String postResponse(String url) {
		
		OAuthService service = new ServiceBuilder()
				.provider(TwitterApi.SSL.class)
				.apiKey(API_KEY)
				.apiSecret(API_SECRET_KEY)
				.build();
				
		Token accessToken = new Token(TOKEN_KEY,TOKEN_SECRET_KEY);
		
		OAuthRequest request = new OAuthRequest(Verb.POST,url);
		
		service.signRequest(accessToken, request);
		
		Response response = request.send();
		
		return response.getBody();
	}


}
