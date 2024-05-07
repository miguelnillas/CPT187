/*Creator: Miguel Nillas
 * Start Date: 04/07/2024
 * Assignment: CPT 187 Project 5
 * Class Purpose: Main class, controls use of Inventory and Item class and interacts with user
 */

package edu.cpt187;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	 
	
	public static void main(String[] args) 
	{
		Inventory inventory = new Inventory();
		 Scanner scanner = new Scanner(System.in);
		 
		 //load
		 
			 inventory.loadItemList("inventory.txt");
			 System.out.println("Load success");
		 
		 
		displayMenu();
		char choice = validateMenuOption(scanner);
		
		while(choice != 'Q');
		{
			if(choice == 'F') //find
			{
				System.out.println("Find Item by Name: ");
				String input = scanner.nextLine();
				inventory.findItemByName(input);
				displayMenu();
				 choice = validateMenuOption(scanner);
			}
			else if(choice == 'A') //add
			{
				inventory.addItem(createItem(scanner));
				displayMenu();
				 choice = validateMenuOption(scanner);
			}
			else if(choice == 'L') //list all
			{
				ArrayList<Item> newItemList = inventory.getItemList();
				 System.out.println("List of All Items:");
			        System.out.printf("%-20s %-10s %-10s %-10s\n", "Item", "Price", "Stock", "Reorder");
			        for (Item item : newItemList) {
			            System.out.printf("%-20s %-10.2f %-10d %-10d\n", item.getItemName(), item.getPrice(), item.getStock(), item.getReorder());
			        }
			        displayMenu();
					 choice = validateMenuOption(scanner);
			}
			else
			{
				System.out.println("Invalid choice. Please try again.");
				displayMenu();
				 choice = validateMenuOption(scanner);
			}
		}
		System.out.println("Goodbye");
		scanner.close();
	}//end of main method
	
	private static void displayMenu()
	{
		System.out.println("Menu");
		System.out.println("F - find an item");
		System.out.println("A - add a new item");
		System.out.println("L - List all items");
		System.out.println("Q - quit");
		
	}
	
	private static char validateMenuOption(Scanner scanner)
	{
		String input = scanner.nextLine().toUpperCase();
		return input.charAt(0);
	}
	
	
	
	//hmm
	private static Item createItem(Scanner scanner)
	{
		System.out.println("Create new Item:");
		System.out.println("Name: ");
		String name = scanner.nextLine();
		
		System.out.println("Price: ");
		double price = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Reorder amount: ");
		int reorderAmount = Integer.parseInt(scanner.nextLine());
		return new Item(name, price, reorderAmount);
	}
}//end of main class
