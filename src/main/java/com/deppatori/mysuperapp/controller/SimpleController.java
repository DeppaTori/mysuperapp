package com.deppatori.mysuperapp.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpledata")
public class SimpleController {

	@GetMapping
	public Set<String> index(){
		Set<String> myStrings = new HashSet<>();
		myStrings.add("Apel");
		myStrings.add("Mangga");
		myStrings.add("Durian");
		return myStrings;
	}
	
}
