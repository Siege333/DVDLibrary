package com.qa.dvdLibrary.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dvdLibrary.entity.Dvd;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:dvd-schema.sql", "classpath:dvd-data.sql"}, 
     executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class DvdControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void createDvdTest() throws Exception {
		//Given
		Dvd newDvd = new Dvd("Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro");
		String newDvdJSON = this.mapper.writeValueAsString(newDvd);
		
		Dvd dvdSaved = new Dvd(4, "Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro");
		String dvdSavedJSON = this.mapper.writeValueAsString(dvdSaved);
		//when
		RequestBuilder request = post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newDvdJSON);
		
		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(dvdSavedJSON);
		
		//then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}
	
	@Test
	void readAllDvdsTest() throws Exception {
		List<Dvd> dvds = new ArrayList<>();
		dvds.add(new Dvd(1, "Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro"));
		dvds.add(new Dvd(2, "Twelve Monkeys", "Sci-Fi", 1995, 124, "15", "Medeleine Stowe", "Bruce Willis"));
		dvds.add(new Dvd(3, "Hannibal", "Horror", 2001, 126, "18", "Julianne Moore", "Anthony Hopkins"));
	
		String savedDvdsJSON = this.mapper.writeValueAsString(dvds);
		
		RequestBuilder request = get("/readAll");
		
		ResultMatcher responseStatus = status().isFound();
		ResultMatcher responseContent = content().json(savedDvdsJSON);
		
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}
	
	@Test
	void getByIDTest() throws Exception {
		Dvd dvdSaved = new Dvd(1, "Stardust", "Romance", 2007, 122, "PG", "Claire Danes", "Robert De Niro");
		String dvdSavedJSON = this.mapper.writeValueAsString(dvdSaved);
	
	    RequestBuilder request = get("/getByID/1");
	    
	    ResultMatcher responseStatus = status().isFound();
		ResultMatcher responseContent = content().json(dvdSavedJSON);
		
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}
}
