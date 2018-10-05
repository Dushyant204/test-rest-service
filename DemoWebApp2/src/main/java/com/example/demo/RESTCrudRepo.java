package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RESTCrudRepo extends JpaRepository<Allien,Integer> {

	public List<Allien> findByTech(String tech);
	List<Allien> findByIdGreaterThan(int id);
	
	@Query("from Allien where tech=?1 order by name")
	List<Allien> findBySortedTech(String tech);
	
}