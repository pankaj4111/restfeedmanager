package com.airtel.feed;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.airtel.feed.cassandra.repository.NewsFeedTextsRepository;
import com.airtel.feed.cassandra.repository.NewsFeedVideoRepository;
import com.airtel.feed.cassandra.repository.VisitorsRepository;
import com.airtel.feed.model.NewsTextFeed;
import com.airtel.feed.model.Visitors;
import com.airtel.feed.service.NewsFeedService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.airtel"}) 
public class NewsFeedTrackersApp implements CommandLineRunner{
 
	@Autowired
	NewsFeedTextsRepository newsFeedTextsRepository;

	@Autowired 
	NewsFeedVideoRepository newsFeedVideoRepository; 
	 
	@Autowired
	VisitorsRepository visitorsRepository;
	@Autowired
	NewsFeedService newsFeedService; 

	public static void main(String[] args) {
		SpringApplication.run(NewsFeedTrackersApp.class, args);
	}

	@Override 
	public void run(String... args) throws Exception { 
		
		newsFeedService.pullFeed("text/text_en");  
		//saveFeedDummyData();
	}


	public void saveFeedDummyData(){
		System.out.println("===================Save Feed  Data to Cassandra System===================");
		NewsTextFeed feedItem1 = new NewsTextFeed("Viral Video,Pakistan","ndtv", "latest", "Says Man Filmed Taking Big Cat Out For A Drive", new Long(897),1);
		NewsTextFeed feedItem2 = new NewsTextFeed("Viral Video,Pakistan","ndtv", "latest", "Doo Taking Big Cat Out For B Drive", new Long(987),1);
		UUID pid1 = UUID.randomUUID();
	    UUID pid2 = UUID.randomUUID();
	    
	    feedItem1.setId(pid1);
	    feedItem2.setId(pid2); 
		//String keywords, String title,
		//Long creationTime, Integer feedTypeId, Long fileSize,
	//	Long duration, String videoBitrate, Long framesPerSecond 
		
		//NewsVideoFeed feedItem4 = new NewsVideoFeed("Viral Video,Pakistan", "Doo Taking Big Cat Out For B Drive", new Long(987),1,new Long(200),"test", new Long(987)); 
		
		newsFeedTextsRepository.save(feedItem1);
		newsFeedTextsRepository.save(feedItem2);
		
		//saveData();
	} 
	
	
	
	public void clearData(){
		visitorsRepository.deleteAll();
	}
	 
	public void saveData(){
		System.out.println("===================Save Visitors to Cassandra===================");
		Visitors cust_1 = new Visitors(11, "Peter", "Smith", 20);
		Visitors cust_2 = new Visitors(12, "Mary", "Taylor", 25);
		Visitors cust_3 = new Visitors(13, "Peter", "Brown", 30);
		Visitors cust_4 = new Visitors(14, "Lauren", "Taylor", 20);
        Visitors cust_5 = new Visitors(15, "Lauren", "Flores", 45);
        Visitors cust_6 = new Visitors(16, "Peter", "Williams", 20);
  
        // save customers to ElasticSearch
        visitorsRepository.save(cust_1); 
        visitorsRepository.save(cust_2);
        visitorsRepository.save(cust_3);
        visitorsRepository.save(cust_4);
        visitorsRepository.save(cust_5);
        visitorsRepository.save(cust_6); 
        
    	System.out.println("===================Save Visitors to Cassandra======ENDing=============");
	}
	
	public void lookup(){
		System.out.println("===================Lookup Visitors from Cassandra by Firstname===================");
		List<Visitors> peters = visitorsRepository.findByFirstname("Peter");
		peters.forEach(System.out::println);

		System.out.println("===================Lookup Visitors from Cassandra by Age===================");
		List<Visitors> custsAgeGreaterThan25 = visitorsRepository.findVisitorsHasAgeGreaterThan(25); 
		custsAgeGreaterThan25.forEach(System.out::println);
	}

}
