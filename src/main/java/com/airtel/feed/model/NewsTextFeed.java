package com.airtel.feed.model;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class NewsTextFeed {
	
	@PrimaryKey
	private UUID id;
	private String  keywords;
	private String  provider;
	private String  category;
	private String  title;
	private Long  creationTime; 
	private Integer feedTypeId;
	
	
	public NewsTextFeed(){}

	

	public NewsTextFeed(String keywords, String provider, String category,
			String title, Long creationTime, Integer feedTypeId) {
		super();
		this.keywords = keywords;
		this.provider = provider;
		this.category = category;
		this.title = title;
		this.creationTime = creationTime;
		this.feedTypeId = feedTypeId;
	}  






	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	} 



	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Long getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Long creationTime) { 
		this.creationTime = creationTime;
	}


	public Integer getFeedTypeId() {
		return feedTypeId;
	}


	public void setFeedTypeId(Integer feedTypeId) {
		this.feedTypeId = feedTypeId;
	}
	
	
	 
	
}
