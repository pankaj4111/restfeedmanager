package com.airtel.feed.serviceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.airtel.feed.service.AccessAPI;

@Service 
public class AccessAPIImpl<T> implements AccessAPI<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccessAPIImpl.class);

	/*@Autowired
	private RestTemplate restTemplate;*/

	
	@Autowired
	   private RestTemplateBuilder restTemplate; 
	

	@Override
	public ResponseEntity<T> getResponse(String url, HttpMethod method, Class<T> clazz) {
		ResponseEntity<T> response = null;
		try {
			LOGGER.info("URL:" + url);
			LOGGER.info("Method:" + method.name());
			HttpEntity<String> entity;
			entity = new HttpEntity<>("parameters");
			response = restTemplate.build().exchange(url, method, entity, clazz);
		} catch (HttpStatusCodeException ex) {
			int statusCode = ex.getStatusCode().value();
			LOGGER.error("statusCode: " + statusCode);
			LOGGER.error("Exception: " + ex); 
		}
		return response;
	}

}
