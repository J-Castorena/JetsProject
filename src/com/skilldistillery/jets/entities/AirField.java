package com.skilldistillery.jets.entities;

import java.util.*;

public class AirField {
	private List<Jet> fleet;

	public AirField() {
		this.fleet = new ArrayList<>();

	}

	public void moveJetIntoFleet(Jet jet) {
		this.fleet.add(jet);
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

}
