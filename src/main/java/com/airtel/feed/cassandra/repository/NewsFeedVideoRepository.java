package com.airtel.feed.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airtel.feed.model.NewsTextFeed;
import com.airtel.feed.model.NewsVideoFeed;

public interface NewsFeedVideoRepository extends CrudRepository<NewsVideoFeed, String> {
	
	@Query(value="SELECT * FROM NewsVideoFeed WHERE title=?0")
	public List<NewsTextFeed> findByTitle(String title);
 
	@Query("SELECT * FROM NewsVideoFeed WHERE feedTypeId > ?0 ALLOW FILTERING")
	public List<NewsVideoFeed> findNewsTextFeedID(int feedTypeId);  
} 