package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RESTController {

	@Autowired
	RESTCrudRepo cd;// we have JpaCrudReposotory Interface
	
	@RequestMapping("home")
	public String home() {
		System.out.println("*************Hi i am called*************");
		return "home";
	}
	
	@RequestMapping("save")
	public ModelAndView addAlien(Allien obj) {
		System.out.println("*************addAlien() called*************");
		ModelAndView mv=new ModelAndView("home");
		System.out.println(obj);
		cd.save(obj);
		mv.addObject("obj", obj);
		return mv;
	}

	@PostMapping(path="/allien", consumes= {"application/json"})// we can't send data by form-data in postman
	public Allien allien(@RequestBody Allien obj ) {
		System.out.println("*************Save alien() called*************,and data is:"+obj);
		
		cd.save(obj);
		return cd.save(obj);
	}
	@PostMapping(path="/allien1")// data can be send  by form-data in postman
	public Allien allien1(Allien obj ) {
		System.out.println("*************Save alien() called*************,and data is:"+obj);
		
		cd.save(obj);
		return cd.save(obj);
	}
	
	@GetMapping(path="/alliens", produces="application/json" )
	public Iterable<Allien> getAll() {
		
		System.out.println("***********getAll()***************");
		Iterable<Allien> aln=cd.findAll();
		for(Allien allAln:aln) {
			System.out.println(allAln);
		}
		
		return cd.findAll();
	}
	
	
	@RequestMapping("findByTech")
	public List<Allien> findTech(String tech) {
		List<Allien> aln=cd.findByTech(tech);
		System.out.println("***********findTech()***************");
		for(Allien alnList:aln) {
		System.out.println(alnList);
		}
		return cd.findByTech(tech);
	}
	
	@RequestMapping("findBySortedTech")
	public List<Allien> findBySortedTech(String tech) {
		
		System.out.println("***********findBySortedTech()***************");
		return cd.findByTech(tech);
	}
	
	@RequestMapping("findById/{id}")
	public Allien findId(@PathVariable("id") int id) {
		System.out.println("***********findById()***************");
		
		return cd.findById(id).orElse(new Allien());
	}
	
	@RequestMapping("findByIdGT/{id}")
	public List<Allien> findIdGT(@PathVariable("id") int id) {
		System.out.println("***********findIdGT()***************");
					
		return cd.findByIdGreaterThan(id);
	}
}