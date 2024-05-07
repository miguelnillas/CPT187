/*Creator: Miguel Nillas
 * Start Date: 04/07/2024
 * Assignment: CPT 187 Project 5
 * Class Purpose: This class creates a database for items class
 */
package edu.cpt187;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory 
{
	private ArrayList<Item> itemList;
	
	//constr
	public Inventory() 
	{
		this.itemList = new ArrayList<>();
	}
	
	//loading items from .txt file
	public void loadItemList(String fileName)
	{
		//try and catch 
		try
		{
			File file = new File(fileName);
			Scanner fileScanner = new Scanner(file);
			
			//skip header
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				//"\s+" splitting string for one or more spaces 
				String [] parts = line.split("\\s+");
				String itemName = parts[0];
				double price = Double.parseDouble(parts[1]);
				int stock = Integer.parseInt(parts[2]);
				int reorder = Integer.parseInt(parts[3]);
				Item item = new Item(itemName, price, stock, reorder);
				addItem(item);
				
			}
			fileScanner.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found: " + fileName);
		}
	}
	
	public int getNumItems() {
		return itemList.size();
	}
	
	
	//binary search
	public Item findItemByName(String itemName)
	{
		int left = 0;
		int right = itemList.size() - 1;
		
		while(left <= right)
		{
			int mid = left + (right - left) /2;
			Item midItem = itemList.get(mid);
			int compare = midItem.getItemName().compareToIgnoreCase(itemName);
			
			if(compare == 0)
			{
				return midItem; //found it
			}
			else if( compare <0)
			{
				left = mid +1; //search right 
			}
			else
			{
				right = mid -1; //search left
			}
		}
		return null; // no found sowwy
	}
	
	public void addItem(Item item)
	{
		int index = 0;
		int listSize = itemList.size();
		while(index < listSize && itemList.get(index).getItemName().compareToIgnoreCase(item.getItemName()) < 0)
		{
			index++;
		}
		itemList.add(index, item);
	}
	
	public void removeItem(Item item)
	{
		itemList.remove(item);
	}
	
	//alter
	public ArrayList<Item> getItemList()
	{
		return new ArrayList<>(itemList);
	}
	
	
}//end of inventory class
