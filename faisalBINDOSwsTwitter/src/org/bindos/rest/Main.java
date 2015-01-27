package org.bindos.rest;

import java.net.URLEncoder;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.*;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

		TwitterUser twitter_user = new TwitterUser();
		/*------------------------Question 1 -----------------------*/

		String url1 = "https://api.twitter.com/1.1/account/verify_credentials.json";
		String reponse1 = twitter_user.getResponse(url1);

		JSONParser parser1 = new JSONParser();
		Object objetNormal1 = parser1.parse(reponse1);

		JSONObject jsonObject1 = (JSONObject) objetNormal1;

		System.out
				.println("****************Question 1************************");
		System.out.println(jsonObject1.get("id_str"));
		System.out.println(jsonObject1.get("name"));
		System.out.println(jsonObject1.get("screen_name"));
		System.out.println(jsonObject1.get("followers_count"));
		System.out.println(jsonObject1.get("friends_count"));
		System.out.println(jsonObject1.get("created_at"));
		System.out.println(jsonObject1.get("time_zone"));
		System.out
				.println("**************************************************");

		/*------------------------Question 2 -----------------------*/

		String url2 = "https://api.twitter.com/1.1/followers/list.json";
		String reponse2 = twitter_user.getResponse(url2);

		JSONParser parser2 = new JSONParser();
		Object objetNormal2 = parser2.parse(reponse2);

		JSONObject jsonObject2 = (JSONObject) objetNormal2;
		JSONArray array2 = (JSONArray) jsonObject2.get("users");

		System.out
				.println("****************Question 2************************");
		for (int i = 0; i < array2.size(); i++) {
			JSONObject arrayObject = (JSONObject) array2.get(i);
			System.out.println(array2.size());
			System.out.println("=====>follower " + i);
			System.out.println(arrayObject.get("name"));
			System.out.println(arrayObject.get("screen_name"));
			System.out.println(arrayObject.get("followers_count"));
			System.out.println(arrayObject.get("friends_count"));
			System.out.println(arrayObject.get("created_at"));
			System.out.println(arrayObject.get("time_zone"));
		}
		System.out
				.println("**************************************************");

		/*------------------------Question 3 -----------------------*/

		String url3 = "https://api.twitter.com/1.1/friends/list.json";
		String reponse3 = twitter_user.getResponse(url3);

		JSONParser parser3 = new JSONParser();
		Object objetNormal3 = parser3.parse(reponse3);

		JSONObject jsonObject3 = (JSONObject) objetNormal3;
		JSONArray array3 = (JSONArray) jsonObject3.get("users");

		int followersnumber = 0;

		Double average;

		// System.out.println("liste friends "+array3.size());

		for (int i = 0; i < array3.size(); i++) {

			JSONObject arrayObjectlist = (JSONObject) array3.get(i);
			followersnumber = followersnumber
					+ Integer.parseInt(arrayObjectlist.get("followers_count")
							.toString());

		}
		average = (double) (followersnumber / array3.size());
		System.out
				.println("****************Question 3************************");
		System.out.println("average of followers : " + average);
		System.out
				.println("**************************************************");

		/*------------------------Question 4 -----------------------*/
		Date d = new Date();
		String url4 = "https://api.twitter.com/1.1/statuses/update.json?status="
				+ URLEncoder.encode("HELLO TWITTER " + d.toString());
		String reponse4 = twitter_user.postResponse(url4);
		System.out
				.println("****************Question 4************************");
		//The factory instance is re-useable and thread safe.
	    //Twitter twitter = TwitterFactory.getSingleton();
	   // Status status = twitter.updateStatus(latestStatus);
	    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}
}
