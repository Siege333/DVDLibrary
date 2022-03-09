package com.qa.dvdLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dvdLibrary.entity.Dvd;
import com.qa.dvdLibrary.service.DvdService;

@RestController
public class Controller {
	
	private DvdService service; //link to service class
	
	@Autowired
	public Controller(DvdService service) {
	this.service = service;
	}

	// This is the Create function to add data to a database
	@PostMapping("/create")
	public ResponseEntity <Dvd> createDVD(@RequestBody Dvd dvd) {
		return new ResponseEntity<Dvd>(this.service.createDvd(dvd), HttpStatus.CREATED);
		
	}
	
}
