package com.airtel.feed.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airtel.feed.model.NewsTextFeed;

public interface NewsFeedTextsRepository extends CrudRepository<NewsTextFeed, String> {
	
	@Query(value="SELECT * FROM NewsTextFeed WHERE title=?0")
	public List<NewsTextFeed> findByTitle(String title);
 
	@Query("SELECT * FROM NewsTextFeed WHERE feedTypeId > ?0 ALLOW FILTERING")
	public List<NewsTextFeed> findNewsTextFeedID(int feedTypeId);  
}