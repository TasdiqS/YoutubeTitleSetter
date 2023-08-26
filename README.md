Repository Description: YouTube Video Title Setter (Java)

Description:
This repository hosts a Java project focused on interacting with the YouTube API to retrieve and set video titles for YouTube videos. The project is designed to simplify the process of fetching video titles and updating them programmatically. It can be used as a foundation for applications that require automated video title management on YouTube.

## Issue: Exception When Setting YouTube Video Title via Code

When attempting to set the title of a YouTube video through code in the [YLCmain](https://github.com/TasdiqS/YoutubeTitleSetter/blob/main/src/main/java/com/YoutubeLikesCounter/demo/YLCmain.java) file, I encountered an exception that resulted in a `500 Internal Server Error`. I am able to get the metadata of video but unable to set video title programmatically The error message and stack trace are in the [file](https://github.com/TasdiqS/YoutubeTitleSetter/blob/main/error.txt) on the main branch. 


Features:
- Utilizes the YouTube API to access video metadata.
- Provides methods to retrieve and update video titles seamlessly.
- Demonstrates proper API authentication and usage.
- Offers a clear Java codebase that can be extended for more complex interactions.

How to Use:
1. Clone the repository to your local machine using Git.
2. Set up your YouTube API credentials following the provided instructions.
   Sign in to Google Cloud Console -> Create a New Project -> Enable the YouTube Data API -> Create an API Key
4. Explore the Java codebase to understand the API interaction logic.
5. Customize the code to suit your specific use case, such as scheduled title updates.
6. Contribute by submitting pull requests for improvements or bug fixes.

Dependencies:
- Java Development Kit (JDK) 8 or higher.
- YouTube API credentials (API key or OAuth token).
- Relevant Java libraries for API interaction (specified in the project).

Contributions:
Contributions to enhance the functionality, optimize code, or improve documentation are welcome. Please follow the contribution guidelines outlined in the repository.

Note:
This project serves as an educational resource and a starting point for YouTube API integration. Be mindful of YouTube's terms of service and API usage policies when deploying applications that involve bulk changes to video titles.

Repository Status: Active
Maintainer: [TasdiqS]
