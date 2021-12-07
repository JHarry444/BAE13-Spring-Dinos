package com.qa.dinos.domain;

public class Dinosaur {

	private String diet;

	private Integer numTeeth;

	private String type;

	private Integer height;

	public Dinosaur() {
		super();
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
