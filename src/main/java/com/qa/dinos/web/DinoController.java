package com.qa.dinos.web;

import java.util.ArrayList;
import java.util.List;

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

	@PostMapping("/create")
	public Dinosaur createDinosaur(@RequestBody Dinosaur dino) {
		this.dinos.add(dino);
		Dinosaur created = this.dinos.get(this.dinos.size() - 1);
		return created;
	}

	@GetMapping("/getAll")
	public List<Dinosaur> getAllDinos() {
		return this.dinos;
	}

	@GetMapping("/get/{id}")
	public Dinosaur getDino(@PathVariable Integer id) {
		System.out.println("ID: " + id);
		return null;
	}

	@PutMapping("/replace/{id}")
	public Dinosaur replaceDino(@PathVariable Integer id, @RequestBody Dinosaur newDino) {
		System.out.println("ID: " + id);
		System.out.println("DINO: " + newDino);

		return null;
	}

	@DeleteMapping("/remove/{id}")
	public void removeDino(@PathVariable Integer id) {
		System.out.println("ID: " + id);
	}
}
