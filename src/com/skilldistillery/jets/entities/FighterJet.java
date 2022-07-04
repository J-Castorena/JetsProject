package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	private String model;
	private double speed;
	private int range;
	private long price;

	
	
	public FighterJet() {

	}

	public FighterJet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}

	@Override
	public void fly() {
		System.out.println("Fighter jet flying.");
	}
	
	public void fight() {
		System.out.println("LOCKED ON TO TARGET. Engaging. PEW-PEW!!! ");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FighterJet [model=");
		builder.append(model);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", range=");
		builder.append(range);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}
