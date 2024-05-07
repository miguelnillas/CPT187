/*Creator: Miguel Nillas
 * Start Date: 04/07/2024
 * Assignment: CPT 187 Project 5
 * Class Purpose: Skeleton for item object
 */
package edu.cpt187;

public class Item {

	private String itemName;
	private double price;
	private int stock;
	private int reorder;
	
	//const
	public Item(String inItemName, double inPrice, int inStock, int inReorder)
	{
		this.itemName = inItemName;
		this.price = inPrice;
		this.stock = inStock;
		this.reorder = inReorder;
	}
	//overloaded constr
	
	public Item(String inItemName, double inPrice, int inReorder)
	{
		this.itemName = inItemName;
		this.price = inPrice;
		this.stock = inReorder * 2;
		this.reorder = inReorder;
	}
	
	
	//getters
	
	public String getItemName()
	{
		return itemName;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getStock()
	{
		return stock;
	}
	
	public int getReorder()
	{
		return reorder;
	}
	
	public void reduceStock(int amount)
	{
		if(amount > 0 && amount <= stock)
		{
			stock = stock - amount;
		}
		else
		{
			System.out.println("Invalid amount to reduce");
		}
	}
	
	public void reorder(int amount)
	{
		if(amount > 0)
		{
			stock = amount + stock;
		}
		else
		{
			System.out.println("Invalid amount to add");
		}
	}
	
}//end item class
