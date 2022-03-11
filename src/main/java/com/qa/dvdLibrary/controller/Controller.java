package com.qa.dvdLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
    // This is the Read all function to read all the entries in the database
	@GetMapping("/readAll")
	public ResponseEntity <List<Dvd>> readAll() {
		return new ResponseEntity<List<Dvd>>(this.service.readAllDvds(), HttpStatus.FOUND);
	}
	
	//This is the ReadById function to find entries by their ID
	@GetMapping("/getByID/{dvdID}")
	public ResponseEntity<Dvd> getByID(@PathVariable Integer dvdID) {
		return new ResponseEntity<Dvd>(this.service.getByID(dvdID), HttpStatus.FOUND);
	}
	
	//This is the Update function to alter an entry already in the database
	@PutMapping("/updateDVD/{dvdID}")
	public ResponseEntity<Dvd> updateDvd(@PathVariable Integer dvdID, @RequestBody Dvd dvd) {
		return new ResponseEntity<Dvd>(this.service.updateDvd(dvdID, dvd), HttpStatus.ACCEPTED);
	}

	//This is the Delete function to remove entries from the database
		@DeleteMapping("/delete/{dvdID}")
		public ResponseEntity<Boolean> deleteById(@PathVariable Integer dvdID) {
			boolean hasDeleted = this.service.deleteDvd(dvdID);
			if (hasDeleted) {
				return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.GONE);
			} else {
				return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.NOT_IMPLEMENTED);
		    }
	    }
}
