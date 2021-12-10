package com.qa.dinos.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dinos.domain.Dinosaur;

// boots the entire context - random port to avoid collisions (two apps running on the same)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
@Sql(scripts = { "classpath:dino-schema.sql",
		"classpath:dino-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class DinoControllerIntegrationTest {

	@Autowired // pulls the MockMVC object from the context
	private MockMvc mvc; // class that perform the request (kind of a postman equivalent)

	@Autowired
	private ObjectMapper mapper; // java <-> JSON converter that Spring uses

	@Test
	void testCreate() throws Exception {
		Dinosaur testDino = new Dinosaur(null, "Carnivorous", 300, "T-Rex", 200);
		String testDinoAsJSON = this.mapper.writeValueAsString(testDino);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testDinoAsJSON);

		Dinosaur testCreatedDino = new Dinosaur(2, "Carnivorous", 300, "T-Rex", 200);
		String testCreatedDinoAsJSON = this.mapper.writeValueAsString(testCreatedDino);
		ResultMatcher checkStatus = status().isCreated(); // is status 201 - created
		ResultMatcher checkBody = content().json(testCreatedDinoAsJSON); // does the body match my testCreatedDinoAsJSON

		// sends request - checks the status - checks the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testCreate2() throws Exception {
		Dinosaur testDino = new Dinosaur(null, "Carnivorous", 300, "T-Rex", 200);
		String testDinoAsJSON = this.mapper.writeValueAsString(testDino);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testDinoAsJSON);

		Dinosaur testCreatedDino = new Dinosaur(2, "Carnivorous", 300, "T-Rex", 200);
		String testCreatedDinoAsJSON = this.mapper.writeValueAsString(testCreatedDino);
		ResultMatcher checkStatus = status().isCreated(); // is status 201 - created
		ResultMatcher checkBody = content().json(testCreatedDinoAsJSON); // does the body match my testCreatedDinoAsJSON

		// sends request - checks the status - checks the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");

		List<Dinosaur> testDinos = List.of(new Dinosaur(1, "Carnivorous", 200, "Spinosaurus", 300));
		String json = this.mapper.writeValueAsString(testDinos);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
}
