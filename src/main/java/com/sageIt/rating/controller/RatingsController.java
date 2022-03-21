package com.sageIt.rating.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sageIt.rating.model.Rating;
import com.sageIt.rating.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		System.out.println("RatingsController ::: getRating() started");
		HashMap<String, Rating> ratingList = initializeRatings();
		return ratingList.get(movieId);
	}

	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		System.out.println("RatingsController ::: getUserRating() started");
		HashMap<String, Rating> ratingList = initializeRatings();
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatings(ratingList.values());
		return userRating;
	}
	
	private HashMap<String, Rating> initializeRatings(){
		HashMap<String, Rating> ratings = new HashMap<String, Rating>();
		ratings.put("123", new Rating("123", 4));
		ratings.put("5678", new Rating("5678", 3));
		ratings.put("4321", new Rating("4321", 5));
		return ratings;
	}

}
