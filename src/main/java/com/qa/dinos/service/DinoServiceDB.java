package com.qa.dinos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dinos.domain.Dinosaur;
import com.qa.dinos.repo.DinoRepo;

@Service
public class DinoServiceDB implements DinoService {

	private DinoRepo repo;

	@Autowired
	public DinoServiceDB(DinoRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Dinosaur createDinosaur(Dinosaur dino) {
		Dinosaur created = this.repo.save(dino); // INSERT INTO DINOSAUR...
		return created;
	}

	public String testMeTestMe() {
		return "CAN YOU SEE WHAT THE JH IS COOKING?";
	}

	@Override
	public List<Dinosaur> getAllDinos() {
		return this.repo.findAll(); // SELECT * FROM DINO...
	}

	@Override
	public Dinosaur getDino(Integer id) {
		Optional<Dinosaur> found = this.repo.findById(id); // SELECT * FROM DINO... WHERE ID=
		return found.get();
	}

	@Override
	public List<Dinosaur> getAllDinosByType(String type) {
		List<Dinosaur> found = this.repo.findByTypeIgnoreCase(type);
		return found;
	}

	@Override
	public Dinosaur replaceDino(Integer id, Dinosaur newDino) {
		Dinosaur existing = this.repo.findById(id).get();

		existing.setDiet(newDino.getDiet());
		existing.setHeight(newDino.getHeight());
		existing.setNumTeeth(newDino.getNumTeeth());
		existing.setType(newDino.getType());

		Dinosaur updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public void removeDino(Integer id) {
		this.repo.deleteById(id); // DELETE FROM DINOSAUR WHERE ID=
	}

}
