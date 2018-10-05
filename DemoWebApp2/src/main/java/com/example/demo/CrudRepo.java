package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CrudRepo extends CrudRepository<Allien,Integer> {

	public List<Allien> findByTech(String tech);
	List<Allien> findByIdGreaterThan(int id);
	
	@Query("from Allien where tech=?1 order by name")
 List<Allien> findBySortedTech(String tech);
	
}

