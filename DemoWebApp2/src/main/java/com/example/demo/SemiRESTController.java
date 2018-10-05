package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class SemiRESTController {

	@Autowired
	CrudRepo cd;
	
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

	@RequestMapping("getAll")
	@ResponseBody
	public String getAll() {
		
		System.out.println("***********getAll()***************");
		Iterable<Allien> aln=cd.findAll();
		for(Allien allAln:aln) {
			System.out.println(allAln);
		}
		
		return cd.findAll().toString();
	}
	
	
	@RequestMapping("findByTech")
	@ResponseBody
	public String findTech(String tech) {
		List<Allien> aln=cd.findByTech(tech);
		System.out.println("***********findTech()***************");
		for(Allien alnList:aln) {
		System.out.println(alnList);
		}
		
		return cd.findByTech(tech).toString();
	}
	@RequestMapping("findBySortedTech")
	@ResponseBody
	public String findBySortedTech(String tech) {
		
		System.out.println("***********findBySortedTech()***************");
		return cd.findByTech(tech).toString();
	}
	@RequestMapping("findById/{id}")
	@ResponseBody
	public String findId(@PathVariable("id") int id) {
		System.out.println("***********findById()***************");
		
		return cd.findById(id).orElse(new Allien()).toString();
	}
	@RequestMapping("findByIdGT")
	@ResponseBody
	public String findIdGT(int id) {
		System.out.println("***********findIdGT()***************");
					
		return cd.findByIdGreaterThan(id).toString();
	}
}

	