package com.qa.dinos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.qa.dinos.domain.Dinosaur;

public class DinoService {

	private List<Dinosaur> dinos = new ArrayList<>();

	public Dinosaur createDinosaur(Dinosaur dino) {
		this.dinos.add(dino);
		Dinosaur created = this.dinos.get(this.dinos.size() - 1);
		return created;
	}

	public List<Dinosaur> getAllDinos() {
		return this.dinos;
	}

	public Dinosaur getDino(Integer id) {
		return this.dinos.get(id);
	}

	public Dinosaur replaceDino(Integer id, Dinosaur newDino) {
		Dinosaur found = this.dinos.set(id, newDino);

		return found;
	}

	public void removeDino(@PathVariable Integer id) {
		this.dinos.remove(id.intValue());
	}
}
