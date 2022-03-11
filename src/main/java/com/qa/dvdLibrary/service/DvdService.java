package com.qa.dvdLibrary.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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

	public Dvd getByID(Integer dvdID) {
		Optional<Dvd> optionalDvd = this.repo.findById(dvdID);
		if (optionalDvd.isPresent()) {
			return optionalDvd.get();
		} else {
			throw new EntityNotFoundException("Can't find that DVD");
		}
    }

	public Dvd updateDvd(Integer dvdID, Dvd d) {
		Dvd foundDvd = this.getByID(dvdID);
		foundDvd.setTitle(d.getTitle());
		foundDvd.setGenre(d.getGenre());
		foundDvd.setReleaseDate(d.getReleaseDate());
		foundDvd.setRunningTime(d.getRunningTime());
		foundDvd.setBbfcRating(d.getBbfcRating());
		foundDvd.setLeadingLady(d.getLeadingLady());
		foundDvd.setLeadingActor(d.getLeadingActor());
		return this.repo.save(foundDvd);
	}
}
