package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Passenger;

public class JetsApplication {
	private AirField airField;

	public static void main(String[] args) {
		JetsApplication jApp = new JetsApplication();
		jApp.run();

		// TODO Auto-generated method stub

	}

	private void run() {
		createAirField();
	}

	private void createAirField() {
		this.airField = new AirField();
		List<Set<String>> namesJets = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetInfo = line.split(",");
				Jet jet = jetBuilder(jetInfo);
				if (jet != null) {
					this.airField.moveJetIntoFleet(jet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private Jet jetBuilder(String[] jetInfo) {
		String typeOfJet = jetInfo[0];
		String model = jetInfo[1];
		double speed = Double.parseDouble(jetInfo[2]);
		int range = Integer.parseInt(jetInfo[3]);
		long price = Long.parseLong(jetInfo[4]);

		if (typeOfJet.equals("passeneger")) {
			Passenger jet = new Passenger(model, speed, range, price);
			return jet;
		} else if (typeOfJet.equals("cargoplane")) {
			CargoPlane jet = new CargoPlane(model, speed, range, price);
			return jet;
		} else if (typeOfJet.equals("fighterjet")) {
			FighterJet jet = new FighterJet(model, speed, range, price);
			return jet;
		} else {
			Jet jet = null;
			return jet;
		}

	}

}
