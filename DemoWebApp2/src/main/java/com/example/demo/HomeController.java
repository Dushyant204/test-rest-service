package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class HomeController {
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
	public ModelAndView getAll() {
		ModelAndView mv =new ModelAndView("home");
		System.out.println("***********getAll()***************");
		Iterable<Allien> aln=cd.findAll();
		for(Allien allAln:aln) {
			System.out.println(allAln);
		}
		
		return mv;
	}
	
	
	@RequestMapping("findByTech")
	public ModelAndView findTech(String tech) {
		ModelAndView mv=new ModelAndView("home");
		List<Allien> aln=cd.findByTech(tech);
		System.out.println("***********findTech()***************");
		for(Allien alnList:aln) {
		System.out.println(alnList);
		}
		mv.addObject("obj", aln);
		return mv;
	}
	@RequestMapping("findBySortedTech")
	public ModelAndView findBySortedTech(String tech) {
		ModelAndView mv=new ModelAndView("home");
		List<Allien> aln=cd.findByTech(tech);
		System.out.println("***********findBySortedTech()***************");
		for(Allien alnList:aln) {
		System.out.println(alnList);
		}
		mv.addObject("obj", aln);
		return mv;
	}
	@RequestMapping("findById")
	public ModelAndView findId(int id) {
		ModelAndView mv=new ModelAndView("home");
		Allien aln=cd.findById(id).orElse(new Allien());
		System.out.println("***********findById()***************");
		System.out.println(aln);
		mv.addObject("obj", aln);
		return mv;
	}
	@RequestMapping("findByIdGT")
	public ModelAndView findIdGT(int id) {
		System.out.println("***********findIdGT()***************");
		
		ModelAndView mv=new ModelAndView("home");
		List<Allien> aln=cd.findByIdGreaterThan(id);
		for(Allien alnList:aln) {
			System.out.println(alnList);
			}
		System.out.println(aln);
		mv.addObject("obj", aln);
		return mv;
	}
}

	