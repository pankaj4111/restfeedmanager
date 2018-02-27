package com.airtel.feed.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airtel.feed.dto.ResultDTO;
import com.airtel.feed.service.AccessAPI;
import com.airtel.feed.service.NewsFeedService;

@Service 
public class NewsFeedServiceImpl implements NewsFeedService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsFeedServiceImpl.class);

	@Value("${api.base.url}")
	private String baseAPIUrl;
 
	@Autowired 
	private AccessAPI<ResultDTO> event;
	
	
	@Override
	public List<String> pullFeed(String urlshodName) {

		LOGGER.info(" Inside getCityStateWise for stateCode : " + urlshodName);
		List<String> feedData = new ArrayList<String>();
		String url = baseAPIUrl + "" + urlshodName+".json";
		ResponseEntity<ResultDTO> response = event.getResponse(url, HttpMethod.GET, ResultDTO.class);
		if (response != null) {
			ResultDTO resultData = (response.getBody());
			feedData = (List<String>) resultData.getResponseData(); 
		}
		return feedData;
	
		
	}


	
}
