package com.qa.dinos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dinos.domain.Dinosaur;

@Repository
public interface DinoRepo extends JpaRepository<Dinosaur, Integer> {

	// Spring will auto-generate all of the basic CRUD functionality

	List<Dinosaur> findByTypeIgnoreCase(String type);

	List<Dinosaur> findByDiet(String diet);

	List<Dinosaur> findByHeight(Integer height);

	List<Dinosaur> findByNumTeeth(Integer numTeeth);

}
