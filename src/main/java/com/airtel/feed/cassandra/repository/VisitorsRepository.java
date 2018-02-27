package com.airtel.feed.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airtel.feed.model.Visitors;

public interface VisitorsRepository extends CrudRepository<Visitors, String> {
	
	@Query(value="SELECT * FROM visitors WHERE firstname=?0")
	public List<Visitors> findByFirstname(String firstname);

	@Query("SELECT * FROM visitors WHERE age > ?0 ALLOW FILTERING")
	public List<Visitors> findVisitorsHasAgeGreaterThan(int age);
}  