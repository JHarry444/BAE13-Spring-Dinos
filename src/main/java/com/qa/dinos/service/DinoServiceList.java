package com.qa.dinos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dinos.domain.Dinosaur;

@Service
public class DinoServiceList implements DinoService {

	private List<Dinosaur> dinos = new ArrayList<>();

	@Override
	public Dinosaur createDinosaur(Dinosaur dino) {
		this.dinos.add(dino);
		Dinosaur created = this.dinos.get(this.dinos.size() - 1);
		return created;
	}

	@Override
	public List<Dinosaur> getAllDinos() {
		return this.dinos;
	}

	@Override
	public Dinosaur getDino(Integer id) {
		return this.dinos.get(id);
	}

	@Override
	public List<Dinosaur> getAllDinosByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dinosaur replaceDino(Integer id, Dinosaur newDino) {
		Dinosaur found = this.dinos.set(id, newDino);

		return found;
	}

	@Override
	public void removeDino(Integer id) {
		this.dinos.remove(id.intValue());
	}
}
