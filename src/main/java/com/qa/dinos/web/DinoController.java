package com.qa.dinos.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dinos.domain.Dinosaur;

@RestController // tells Spring this is a controller
				// REST compliant
public class DinoController {

	private List<Dinosaur> dinos = new ArrayList<>();

	@GetMapping("/hello") // endpoint
	public String hello() {
		return "Hello, World!";
	}

	@PostMapping("/create") // 201 - Created
	public ResponseEntity<Dinosaur> createDinosaur(@RequestBody Dinosaur dino) {
		this.dinos.add(dino);
		Dinosaur created = this.dinos.get(this.dinos.size() - 1);
		ResponseEntity<Dinosaur> response = new ResponseEntity<Dinosaur>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll") // 200
	public ResponseEntity<List<Dinosaur>> getAllDinos() {
		return ResponseEntity.ok(this.dinos);
	}

	@GetMapping("/get/{id}") // 200
	public Dinosaur getDino(@PathVariable Integer id) {
		return this.dinos.get(id);
	}

	@PutMapping("/replace/{id}") // 202 - Accepted
	public ResponseEntity<Dinosaur> replaceDino(@PathVariable Integer id, @RequestBody Dinosaur newDino) {
		Dinosaur body = this.dinos.set(id, newDino);

		ResponseEntity<Dinosaur> response = new ResponseEntity<Dinosaur>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<?> removeDino(@PathVariable Integer id) {
		this.dinos.remove(id.intValue());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
