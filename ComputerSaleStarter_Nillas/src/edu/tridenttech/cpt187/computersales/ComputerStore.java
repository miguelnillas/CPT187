package edu.tridenttech.cpt187.computersales;

import java.util.ArrayList;
import java.util.Scanner;

import edu.tridenttech.cpt187.computersales.model.Catalog;
import edu.tridenttech.cpt187.computersales.model.Computer;
import edu.tridenttech.cpt187.computersales.model.Upgrade;

public class ComputerStore {
	
	// private static StringBuffer MENU_CHARS =  new StringBuffer("ABCQ");
	private static String MENU_CHARS =  "ABCDQ";

	private static String[] MENU_DESCRIPTIONS = {
			"Enter Customer Sale",
	        "Modify Base Price",
	        "Modify Upgrade Price",
	        "List Sales",
	        "Quit"
	        };

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Computer> baseModelList = catalog.getBaseModelList();
        ArrayList<Upgrade> upgradeList = catalog.getUpgradeList();
        char baseModelSelection;
        char upgradeSelection;
        char mainSelection = ' ';
        
        mainSelection = getMainSelection(keyboard);
        while (mainSelection != 'Q') {
            if (mainSelection == 'A') {
                baseModelSelection = getValidatedComputerSelection(keyboard, baseModelList);
                upgradeSelection = getValidatedUpgradeSelection(keyboard, upgradeList);
                // TODO complete the code for the user's choice
            	System.out.printf("%c is still incomplete!%n", mainSelection);
            // TODO, add code for the other selections
            } else if (mainSelection == 'B') {
            	System.out.printf("%c not yet implemented!%n", mainSelection);
            } else if (mainSelection == 'C') {
            	System.out.printf("%c not yet implemented!%n", mainSelection);
            } else {
            	System.out.printf("%c noe yet implemented!%n", mainSelection);
            }

            // get the user's selection from the main menu.
            mainSelection = getMainSelection(keyboard);
        }
        // call your method to display the daily report
    }
    
    private static void displayMainMenu() {
    	System.out.println("Please select from the following menu: ");
        for (int i=0; i < MENU_CHARS.length(); i++) {
        	System.out.printf("%c) %s%n", MENU_CHARS.charAt(i), MENU_DESCRIPTIONS[i]);
        }
    }
    
    private static char getMainSelection(Scanner keyboard) {
    	displayMainMenu();
        char selection = keyboard.nextLine().toUpperCase().charAt(0);
        while (MENU_CHARS.indexOf(selection) < 0) {
        	System.out.printf("Invalid Selection: %c%n", selection);
            displayMainMenu();
            selection = keyboard.nextLine().toUpperCase().charAt(0);
        }
        return selection;
    }

    private static char getValidatedComputerSelection(Scanner keyboard, ArrayList<Computer> modelList) {
        char selection = 0;
        selection = displayComputerMenu(keyboard, modelList);
        while (!validateAbcSelection(selection, modelList.size())) {
            System.out.println("Invalid selection.  Please re-enter your selection.");
            selection = displayComputerMenu(keyboard, modelList);
        }
        return selection;
    }

    private static char displayComputerMenu(Scanner input, ArrayList<Computer> modelList) {
        char selection = 0;
        char selChar = 'A';
        System.out.println("Which model of computer would you like?\nSelect from the following menu:");
        for(Computer comp : modelList) {
            System.out.printf("%c) %-15s%-45s%8.2f%n", selChar, comp.getName(), comp.getDescription(), comp.getPrice());
            selChar++;
        }
        selection = input.nextLine().charAt(0);
        return Character.toUpperCase(selection);
    }
    
    private static boolean validateAbcSelection(char selection, int numChoices) {
        boolean isValid = true; // assumption is false
        int testNdx = selection - 'A';
        // menu is A,B,C... for each item in the list
        if (testNdx < 0 || testNdx > numChoices) {
            isValid = false;
        }
        return isValid;
    }
    
    private static char getValidatedUpgradeSelection(Scanner input, ArrayList<Upgrade> upgradeList) {
        char selection = 0;
        selection = displayUpgradeMenu(input, upgradeList);
        while (!validateAbcSelection(selection, upgradeList.size())) {
            System.out.println("Invalid selection.  Please re-enter your selection.");
            selection = displayUpgradeMenu(input, upgradeList);
        }
        return selection;
    }

    private static char displayUpgradeMenu(Scanner input, ArrayList<Upgrade> upgradeList) {
        char selection = 0;
        char selChar = 'A';
        System.out.println("Which upgrade would you like?\n" + 
                           "Select from the following menu:");
        for(Upgrade comp : upgradeList) {
            System.out.printf("%c) %-15s%-45s%8.2f%n", selChar,
                    comp.getName(), comp.getDescription(), comp.getPrice());
            selChar++;
        }
        selection = input.nextLine().charAt(0);
        return Character.toUpperCase(selection);
    }
}
