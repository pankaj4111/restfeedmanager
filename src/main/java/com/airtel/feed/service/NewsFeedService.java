package com.airtel.feed.service;

import java.util.List;

public interface NewsFeedService {
/**
 * 
 * @param urlshodName
 * @return res result list
 */
public List<String> pullFeed(String urlshodName);
}
