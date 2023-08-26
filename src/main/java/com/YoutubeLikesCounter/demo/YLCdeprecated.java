package com.YoutubeLikesCounter.demo;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Videos;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoStatistics;

public class YLCdeprecated {
	public static void main(String[] args) throws GeneralSecurityException, IOException {

		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		// Build the API client
		YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, request -> {
			request.setParser(new JsonObjectParser(jsonFactory));
		}).setApplicationName("youtube Like counter").build();

		// Define the video id parameter
		String videoId = "VidID";

		// Define the API key
		String API_KEY = "API key";

		// Define the API request for retrieving the video statistics
		Videos.List request = youtube.videos().list("statistics");
		request.setId(videoId);
		request.setKey(API_KEY);

		VideoListResponse response = request.execute();
		System.out.println("request executed");

		// Get the view and comment count
		VideoStatistics stats = response.getItems().get(0).getStatistics();
		BigInteger viewCount = stats.getViewCount();
		BigInteger commentCount = stats.getCommentCount();

		System.out.println("Number of views: " + viewCount);
		System.out.println("Number of comments: " + commentCount);
	}
	/*getting number of views and comments printed on console*/
}
