package com.deppatori.mysuperapp.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deppatori.mysuperapp.model.Buah;

@CrossOrigin(origins="https://deppatori.github.io")
//@CrossOrigin(origins="http://localhost:3006")
@RestController
@RequestMapping("/simpledata")
public class SimpleController {

//	@GetMapping
//	public Set<String> index(){
//		Set<String> myStrings = new HashSet<>();
//		myStrings.add("Apel");
//		myStrings.add("Mangga");
//		myStrings.add("Durian");
//		return myStrings;
//	}
//	
	@GetMapping
	public Set<Buah> index(){
		Set<Buah> buahs = new HashSet<>();
		buahs.add(new Buah("Apel"));
		buahs.add(new Buah("Mangga"));
		buahs.add(new Buah("Durian"));
		return buahs;
	}
}
