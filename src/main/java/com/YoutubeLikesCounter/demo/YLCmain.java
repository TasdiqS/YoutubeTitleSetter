
package com.YoutubeLikesCounter.demo;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatistics;

@SpringBootApplication
public class YLCmain {
	private static final String APPLICATION_NAME = "YourAppName";
	private static final String API_KEY = "API-Key";
	private static final String VIDEO_ID = "VidID";

	public static void main(String[] args) throws IOException, GeneralSecurityException {

		JsonFactory jsonFactory = new JacksonFactory();

		YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, request -> {
			request.setParser(new JsonObjectParser(jsonFactory));
		}).setApplicationName(APPLICATION_NAME).build();

		// Define the new title
		String newTitle = "This Title is set by Java";

		// Retrieve video information and statistics
		YouTube.Videos.List videoListRequest = youtube.videos().list("snippet,statistics").setId(VIDEO_ID)
				.setKey(API_KEY);
		com.google.api.services.youtube.model.VideoListResponse videoListResponse = videoListRequest.execute();
		List<Video> videos = videoListResponse.getItems();

		if (!videos.isEmpty()) {
			Video video = videos.get(0);
			VideoSnippet snippet = video.getSnippet();
			System.out.println(snippet.getTitle().toString());
			snippet.setTitle(newTitle);

			 video.setSnippet(snippet);
			 Video updatedVideo = youtube.videos().update("snippet", video).execute();
			 System.out.println("Video title updated: " +
			 updatedVideo.getSnippet().getTitle());

			// Get the view and comment count
			VideoStatistics stats = video.getStatistics();
			BigInteger viewCount = stats.getViewCount();
			BigInteger commentCount = stats.getCommentCount();

			System.out.println("Number of views: " + viewCount);
			System.out.println("Number of comments: " + commentCount);
		}
		
	}
}
