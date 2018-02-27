/*package com.airtel.feed;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.airtel.feed.service.NewsFeedService;
import com.airtel.feed.serviceImpl.NewsFeedServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsFeedTrackerAppTests 
{
	

String baseURL="https://s3-ap-southeast-1.amazonaws.com/test.bsbportal/hiring/feeds/";
	@Autowired 
	private NewsFeedService newsFeedService;


	@TestConfiguration
	static class ServicesConfigContextTest {

		@Bean
		public NewsFeedService NewsFeedService() {
			return new NewsFeedServiceImpl();
		}

	}


	@Test
	public void verifyMaxPassAllow() {

		List result=newsFeedService.pullFeed("text/text_en"); 
		assertEquals(Boolean.TRUE, result.size()>0);    
		System.out.println("End of verifyMaxPassAllow.");
	}  




	
}
*/