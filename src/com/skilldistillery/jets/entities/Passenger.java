package com.skilldistillery.jets.entities;
//jetImpl in user stories
public class Passenger extends Jet {
	
	private String model;
	private double speed;
	private int range;
	private long price;
	
	
	public Passenger() {
		super();
	}

	public Passenger(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	@Override
	public void fly() {
		double runTime;
		System.out.println("Type: Passenger Jet " + " model: " + model + ", speed: " + speed + "(knots), range: " + range + "(miles), price: $" + price);
		runTime = range / speed;
		System.out.println("** This Jet can fly for " + runTime + " hours.");
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
		builder.append("Passenger [model=");
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
