package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
		userSelections();

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

		if (typeOfJet.equals("passenger")) {
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

	private void userSelections() {
		Scanner userInput = new Scanner(System.in);
		boolean keepChoosing = true;

		while (keepChoosing) {
			menu();
			int userChoice = userInput.nextInt();
			switch (userChoice) {
			case 1:
				listFleet();
				break;
			case 2:
				flyAllJets();
				break;
			case 3:
				viewFastestJet();
				break;

			default:
				System.out.println("Please enter a valid number: ");
			}
		}

	}

	private void listFleet() {
		for (Jet jet : this.airField.getFleet()) {
			System.out.println(jet.toString());
		}
	}

	private void flyAllJets() {
		for (Jet jet : this.airField.getFleet()) {
			jet.fly();
		}
	}

	private void viewFastestJet() {
		double highestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : this.airField.getFleet()) {
			if (jet.getSpeed() > highestSpeed) {
				highestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		if (fastestJet != null) {
			System.out.println(fastestJet.toString());
		}
	}

	private void menu() {
		System.out.println("------------------------------------");
		System.out.println("--              MENU              --");
		System.out.println("--                                --");
		System.out.println("-- 1. List fleet                  --");
		System.out.println("-- 2. Fly all jets                --");
		System.out.println("-- 3. View fastest jet            --");
		System.out.println("-- 4. View jet with longest range --");
		System.out.println("-- 5. Load all Cargo Jets         --");
		System.out.println("-- 6. Dogfight!                   --");
		System.out.println("-- 7. Add a jet to Fleet          --");
		System.out.println("-- 8. Remove a jet from Fleet     --");
		System.out.println("-- 9. Quit                        --");
		System.out.println("------------------------------------");
	}

}
