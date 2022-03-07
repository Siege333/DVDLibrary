package com.qa.dvdLibrary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dvdLibrary.entity.Dvd;

@Repository
public interface DvdRepo extends JpaRepository<Dvd, Integer> {

}