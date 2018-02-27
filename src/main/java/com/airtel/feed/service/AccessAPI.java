package com.airtel.feed.service;


import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * @author ankur.goel
 *
 * @param <T>
 */
public interface AccessAPI<T> {
	
	public ResponseEntity<T> getResponse(String url, HttpMethod method, Class<T> clazz);
}
