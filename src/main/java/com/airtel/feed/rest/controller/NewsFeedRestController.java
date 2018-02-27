package com.airtel.feed.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.feed.cassandra.repository.NewsFeedTextsRepository;
import com.airtel.feed.cassandra.repository.NewsFeedVideoRepository;
import com.airtel.feed.dto.ResultDTO;
import com.airtel.feed.service.NewsFeedService;
import com.airtel.feed.utils.APIConstants;
import com.airtel.feed.utils.APIConstants.FEEDTYPE;

/**
 * @author rachit
 *
 */
 
@RestController
@RequestMapping(value = "/newsfeed")
public class NewsFeedRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsFeedRestController.class);
	 
	
	@Autowired
	NewsFeedService newsFeedService;
	
	
	NewsFeedTextsRepository newsFeedTextsRepository;
	
	NewsFeedVideoRepository  newsFeedVideoRepository;
	 
	@RequestMapping(value = "/getproviderfeed", method = RequestMethod.GET)
    public ResponseEntity<ResultDTO>  getProviderFeed(@RequestParam(required = true, value = "feedName") String feedName)
	{
		try{
			newsFeedService.pullFeed(feedName);
			
			
			
			
			return new ResponseEntity<ResultDTO>(new ResultDTO(APIConstants.SUCCESS,APIConstants.RECORD_FOUND), HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Error: " + e.toString());
			return new ResponseEntity<ResultDTO>(new ResultDTO(APIConstants.FAIL,APIConstants.EXCEPTION_OCCURED), HttpStatus.OK);
		}
    }
	
	
	@RequestMapping(value = "/getfeed", method = RequestMethod.GET)
    public ResponseEntity<ResultDTO>  getFeed(@RequestParam(required = true, value = "feedType") String type)
	{
		int feedTypeId =-1;
		try{
			if(FEEDTYPE.TEXT_TYPE.equals(type)){
				feedTypeId=FEEDTYPE.TEXT_TYPE.ordinal();
				return new ResponseEntity<ResultDTO>(new ResultDTO(APIConstants.SUCCESS,APIConstants.RECORD_FOUND,newsFeedTextsRepository.findNewsTextFeedID(feedTypeId )), HttpStatus.OK);
			}
			else if(FEEDTYPE.VEDIO_TYPE.equals(type)){
				feedTypeId=FEEDTYPE.VEDIO_TYPE.ordinal();
				return new ResponseEntity<ResultDTO>(new ResultDTO(APIConstants.SUCCESS,APIConstants.RECORD_FOUND,newsFeedVideoRepository.findNewsTextFeedID(feedTypeId )), HttpStatus.OK);
			}
			 
			return new ResponseEntity<ResultDTO>(new ResultDTO(APIConstants.FAIL,APIConstants.RECORD_NOT_FOUND), HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Error: " + e.toString());
			return new ResponseEntity<ResultDTO>(new ResultDTO(APIConstants.FAIL,APIConstants.EXCEPTION_OCCURED), HttpStatus.OK);
		}
    }

		
}
