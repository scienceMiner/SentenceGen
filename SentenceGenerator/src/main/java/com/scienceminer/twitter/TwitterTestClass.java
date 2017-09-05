package com.scienceminer.twitter;


import java.util.List;
import java.util.stream.Collectors;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterTestClass {

	
	public String createTweet(String tweet) throws TwitterException {
	   // Twitter twitter = getTwitterinstance();
	    Twitter twitter = TwitterFactory.getSingleton();
	    Status status = twitter.updateStatus(tweet);
	    return status.getText();
	}
	
	public List<String> getTimeLine() throws TwitterException {
		 Twitter twitter = TwitterFactory.getSingleton();
		    
	    return twitter.getHomeTimeline().stream()
	      .map(item -> item.getText())
	      .collect(Collectors.toList());
	}
	
	
	public static List<String> searchtweets() throws TwitterException {
		  
		 Twitter twitter = TwitterFactory.getSingleton();
		// Query query = new Query(" collopy");
		 Query query = new Query(" nomura ");
	    QueryResult result = twitter.search(query);
	     
	    return result.getTweets().stream()
	      .map(item -> item.getUser() + " \n\n" + item.getText())
	      .collect(Collectors.toList());
	}
	
	
	public static void main(String[] args)
	{
		
		
		TwitterTestClass tweeter = new TwitterTestClass();
		
		try {
			// tweeter.createTweet("Why are there so few folds in my brain? I can't think deep enough");
			// NEW TO ADD RESOURCES TO .gitignore
			
			List<String> tweets = tweeter.getTimeLine();
			int current = 0;
			
			for (String tweet : tweets)
			{
				System.out.println(current++ + " " + tweet);
			}
			
			System.out.println("");
			
			tweets = tweeter.searchtweets();
			current = 0;
			
			for (String tweet : tweets)
			{
				System.out.println(current++ + " " + tweet + "\n");
			}
			
			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
