package com.qa.dinos.service;

import java.util.List;

import com.qa.dinos.domain.Dinosaur;

public interface DinoService {

	Dinosaur createDinosaur(Dinosaur dino);

	List<Dinosaur> getAllDinos();

	Dinosaur getDino(Integer id);

	Dinosaur replaceDino(Integer id, Dinosaur newDino);

	void removeDino(Integer id);
}
