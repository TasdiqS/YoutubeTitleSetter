package com.YoutubeLikesCounter.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Videos;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatistics;

@SpringBootApplication
public class YoutubeLikeCounterApplication {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		SpringApplication.run(YoutubeLikeCounterApplication.class, args);
		System.out.println("starting checkpoint 1");

		// Use the Google client library to create an HTTP transport and JSON factory
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		
		System.out.println("starting checkpoint 2");
		// Build the API client
//	    YouTube youtube = new YouTube.Builder(httpTransport, jsonFactory, new HttpRequestInitializer() {
//	        public void initialize(HttpRequest request) throws IOException {
//	        }
//	    }).setApplicationName("youtube-cmdline-view-and-comments-updater").build();
//	    System.out.println("starting checkpoint 3");

		GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("/demo/youtubelikescount-5c32b9e5ce80.json"))
				.createScoped(Collections.singletonList("https://www.googleapis.com/auth/youtube"));
		System.out.println("starting checkpoint 2.5");
		YouTube youtube = new YouTube.Builder(httpTransport, jsonFactory, credential)
				.setApplicationName("youtube-cmdline-view-and-comments-updater").build();
		System.out.println("starting checkpoint 3");

		// Define the video id parameter
		String videoId = "i";

		// Define the API request for retrieving the video statistics
		Videos.List request = youtube.videos().list("statistics");
		System.out.println("starting checkpoint 4");
		request.setId(videoId);
		VideoListResponse response = request.execute();
		System.out.println("starting checkpoint 5");

		// Get the view and comment count
//		VideoStatistics stats = response.getItems().get(0).getStatistics();
//		BigInteger viewCount = stats.getViewCount();
//		BigInteger commentCount = stats.getCommentCount();

//		String title = "This video has "+viewCount+" Number of views and "+commentCount+" number of comments";
		String title = "Thes is title";
		System.out.println(title);
	    // Define the new title with the view and comment count
		
	    // Define the new title with the view and comment count
//	    String newTitle = "This video has " + viewCount + " views and " + commentCount + " comments";
		String newTitle = "title set by java";
	    // Create a new instance of the Video model class
	    Video video = new Video();
	    video.setId(videoId);

	    // Set the video's new title
	    VideoSnippet snippet = new VideoSnippet();
	    snippet.setTitle(newTitle);
	    video.setSnippet(snippet);

	    // Define the API request for updating the video
	    Videos.Update updateRequest = youtube.videos().update("snippet", video);

		Video videoResponse = updateRequest.execute();
		
		System.out.println(videoResponse);

	    System.out.println("program ended successfulle");

	}

}
