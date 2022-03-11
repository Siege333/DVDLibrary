package com.qa.dvdLibrary.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dvdLibrary.entity.Dvd;

@Repository
public interface DvdRepo extends JpaRepository<Dvd, Integer> {

	public List<Dvd> findDvdByTitle (String title);
	
}