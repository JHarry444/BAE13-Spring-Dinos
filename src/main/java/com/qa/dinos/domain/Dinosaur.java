package com.qa.dinos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // flags class as a table to Spring Data
public class Dinosaur {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;

	@Column(nullable = false)
	private String diet;

	@Column(unique = true)
	private Integer numTeeth;

	private String type;

	private Integer height;

	public Dinosaur() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public Integer getNumTeeth() {
		return numTeeth;
	}

	public void setNumTeeth(Integer numTeeth) {
		this.numTeeth = numTeeth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Dinosaur [diet=" + diet + ", numTeeth=" + numTeeth + ", type=" + type + ", height=" + height + "]";
	}

}
