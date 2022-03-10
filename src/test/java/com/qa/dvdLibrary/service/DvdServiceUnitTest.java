package com.qa.dvdLibrary.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.dvdLibrary.entity.Dvd;
import com.qa.dvdLibrary.repo.DvdRepo;

@SpringBootTest
public class DvdServiceUnitTest {

	@Autowired
	private DvdService service;
	
	@MockBean
	private DvdRepo repo;
	
	
	@Test
	void createDVDTest() {
		//Given
		Dvd dvdToSave = new Dvd("Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro");
		Dvd dvdSaved = new Dvd("Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro");
		//When
		Mockito.when(this.repo.save(dvdToSave)).thenReturn(dvdSaved);
		//Then
		assertThat(this.service.createDvd(dvdToSave)).isEqualTo(dvdSaved);
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Dvd.class));
	}
	
	@Test
	void readAllDvdsTest() {
		List<Dvd> savedDvds = new ArrayList<>();
		
		savedDvds.add(new Dvd(1, "Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro"));
		savedDvds.add(new Dvd(2, "Twelve Monkeys", "Sci-Fi", 1995, 124, "15", "Medeleine Stowe", "Bruce Willis"));
		savedDvds.add(new Dvd(3, "Hannibal", "Horror", 2001, 126, "18", "Julianne Moore", "Anthony Hopkins"));
		
		Mockito.when(this.repo.findAll()).thenReturn(savedDvds);
		
		assertThat(this.service.readAllDvds()).isEqualTo(savedDvds);
		
		Mockito.verify(this.repo, Mockito.atMostOnce()).findAll();
	}
	
}
