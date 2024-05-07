package edu.tridenttech.cpt187.computersales.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
			
	private ArrayList<Computer> baseModelList = new ArrayList<Computer>();
	private ArrayList<Upgrade> upgradeList = new ArrayList<Upgrade>();
	
	public Catalog() {
		loadModels();
		loadUpgrades();
	}

	/**
	 * Loading models using a string as a fake file.
	 */
	private void loadModels() {
		String fakeFile = "Jaguar      419.99 P17 laptop with microtron technology.\n"
						+ "SnowLeopard 518.99 L15 laptop with blacksmith screen.\n"
						+ "Sabertooth  599.99 S13 laptop with altraX motherboard.\n";
		Scanner fakeInput = new Scanner(fakeFile);
		while (fakeInput.hasNext()) {
			String name = fakeInput.next();
			double price = fakeInput.nextDouble();
			String description = fakeInput.nextLine();
			baseModelList.add(new Computer(name, description, price));
		}
		fakeInput.close();
	}

	/**
	 * Loading upgrades using arrays
	 */
	private void loadUpgrades() {
        String[] TEST_UPGRADE_NAMES = {"HD upgrade", "MEM upgrade", "Total Upgrade", "None" };
        double[] TEST_UPGRADE_PRICES = {419.99, 518.99, 599.99, 0.00 };
        String[] TEST_UPGRADE_DESCRIPTIONS = {
                "Add two Terabyte hard drive",
                "Add sixteen gigabyte memory card.",
                "Above upgrades plus Zenon-7 graphics card.",
                "no-upgrade added"
        };

		for (int i=0; i < TEST_UPGRADE_NAMES.length; i++) {
			String name = TEST_UPGRADE_NAMES[i];
			String description = TEST_UPGRADE_DESCRIPTIONS[i];
			double price = TEST_UPGRADE_PRICES[i];
			upgradeList.add(new Upgrade(name, description, price));
		}
	}
	
	/**
	 * @return Returns a copy of the list of base models
	 */
	public ArrayList<Computer> getBaseModelList() {
		// TODO -- return a copy of the list of base models
		return null;
	}
	
	/**
	 * @return Returns a copy of the list of possible upgrades
	 */
	public ArrayList<Upgrade> getUpgradeList() {
		// TODO -- return a copy of the list of possible upgrades
		return null;
	}
}