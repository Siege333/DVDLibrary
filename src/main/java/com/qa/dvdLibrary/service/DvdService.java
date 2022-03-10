package com.qa.dvdLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dvdLibrary.entity.Dvd;
import com.qa.dvdLibrary.repo.DvdRepo;

@Service
public class DvdService {
	
	private DvdRepo repo;
	
	@Autowired
	public DvdService(DvdRepo repo) {
		this.repo = repo;
	}
	
	public Dvd createDvd(Dvd d) {
		return this.repo.save(d);
	}

	public List<Dvd> readAllDvds() {
		return this.repo.findAll();
	}
}
