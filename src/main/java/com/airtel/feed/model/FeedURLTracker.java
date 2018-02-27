package com.airtel.feed.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class FeedURLTracker {

	@PrimaryKey
	private Integer id;
	private String  baseAPITokens;
	private Integer  feedStatus;
	private Integer  feedFequencyConsumer;



	public FeedURLTracker(){}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getBaseAPITokens() {
		return baseAPITokens;
	}



	public void setBaseAPITokens(String baseAPITokens) {
		this.baseAPITokens = baseAPITokens;
	}



	public Integer getFeedStatus() {
		return feedStatus;
	}



	public void setFeedStatus(Integer feedStatus) {
		this.feedStatus = feedStatus;
	}



	public Integer getFeedFequencyConsume() {
		return feedFequencyConsumer;
	}



	public void setFeedFequencyConsume(Integer feedFequencyConsume) {
		this.feedFequencyConsumer = feedFequencyConsume;
	}



}
