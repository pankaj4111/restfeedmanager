package com.airtel.feed.model;

import java.math.BigInteger;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class NewsVideoFeed {
	
	@PrimaryKey
	private Integer id;
	private String  keywords;
	private String  title;
	private Long  creationTime; 
	private Integer feedTypeId;
	private Long  fileSize;
	private Long  duration;
	private String  videoBitrate;
	private Long  framesPerSecond;
	
	
	public NewsVideoFeed(){}


	public Integer getId() {
		return id;
	} 


	public void setId(Integer id) {
		this.id = id;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
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


	public Long getFileSize() {
		return fileSize;
	}


	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}


	public Long getDuration() {
		return duration;
	}


	public void setDuration(Long duration) {
		this.duration = duration;
	}


	public String getVideoBitrate() {
		return videoBitrate;
	}


	public void setVideoBitrate(String videoBitrate) {
		this.videoBitrate = videoBitrate;
	}


	public Long getFramesPerSecond() {
		return framesPerSecond;
	}


	public void setFramesPerSecond(Long framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
	}


	public NewsVideoFeed(String keywords, String title,
			Long creationTime, Integer feedTypeId, Long fileSize,
			Long duration, String videoBitrate, Long framesPerSecond) {
		super();
		this.keywords = keywords;
		this.title = title;
		this.creationTime = creationTime;
		this.feedTypeId = feedTypeId;
		this.fileSize = fileSize;
		this.duration = duration;
		this.videoBitrate = videoBitrate;
		this.framesPerSecond = framesPerSecond;
	}

	

	
}
