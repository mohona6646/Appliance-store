
//----------------------------------------------
//Assignment 1 
//Question 1 Part 1
//----------------------------------------------
//Written by: Marita Brichan (40138194) and Mohona Mazumdar (40129421)
//This program is designed to create a class Appliance that helps store 
//owners create appliances, using its methods and attributes

/**Names and IDs: Marita Brichan (40138194) and Mohona Mazumdar (40129421)
 * <br>
 * COMP249 
 * <br>
 * Assignment #1
 * <br>
 * Due Date: Friday, 31st January 2020
 * 
 * @author  Marita Brichan and Mohona Mazumdar
 *<br>
 *<br> 
 *
 * This program program will help store owners to store appliances in a program 
 * with their information such as the price, the brand and what type of appliance they are
 * it will firstly ask the user what he wants to do, he can add new appliances
 * change some informations such as price, brand and/or type
 * it can also search for all the products in the same brand
 * it can also search for all the products  under a certain price chosen by the user
 *
 */
 
public class Appliance { 
	
	/**
	 * Creates attributes for objects of class Appliance
	 */
	private String type;
	private String brand;
	private long serialNum;
	private double price;
	private static int count = 0;
	
	/**
	 * The constructor will create the object with the passed parameters
	 * @param type attribute
	 * @param brand attribute
	 * @param price attribute
	 */
	public Appliance(String type, String brand, double price) { 
		this.type = type;
		this.brand = brand;
		this.serialNum = 1000000 + count;
		count++;
		if(price < 1) {
			this.price = 1; 
		}
		else {
			this.price = price;
		}
	}
  
	
  /**
   * This constructor will create a copy constructor that accepts an object appliance as the parameter
   * @param other appliance
   */
  public Appliance(Appliance other){
    this.type = other.type;
    this.brand = other.brand; 
    /**
     * Adds the serial number to the count
     */
   		this.serialNum = 1000000 + count;
		count++;
		if(this.price < 1) {
			this.price = 1;
		}
		else {
			this.price = other.price;
		}
  }
	
  /**
   * This constructor creates an object by default 
   */
	public Appliance() {
		type = "";
		brand = "";
		this.serialNum = 1000000 + count;
		count++;
		price = 1;
	}
	
	/**
	 * This accessor method will return the type of the object 
	 * @return String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 *  This accessor method will return the brand of the object 
	 * @return String
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * This accessor method will return the serial number of the object 
	 * @return String
	 */
	public long getSerialNum() {
		return serialNum;
	}
	
	/**
	 * This accessor method will return the price of the object 
	 * @return String
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This mutator method changes the value of object's type accepting a String as parameter
	 * @param type appliance
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * This mutator method changes the value of object's brand accepting a String as parameter
	 * @param brand appliance
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * This mutator method changes the value of object's price accepting a double as parameter
	 * In the case where the price is under 1, the method sets the price to 1
	 * @param price double 
	 */
	public void setPrice(double price) {
		if(price < 1) {
			this.price = 1; 
		}
		else {
			this.price = price;
		}
	}
	
	/**
	 * ToString method that returns the object's information to the user
	 */
	public String toString() {
		return "Appliance Serial # " + this.serialNum + 
				"\nBrand: " + this.brand +
				"\nType: " + this.type +
				"\nPrice: " + this.price;
	}
	
	/**
	 * This static method returns the number of appliances created
	 * @return integer
	 */
	public static int findNumberOfCreatedAppliances() {
		return count;
	}
	
	/**
	 * This method returns a boolean expression if two appliances are the same
	 * @param other appliance
	 * @return boolean
	 */
	public boolean equals(Appliance other) {
		return ((this.brand).equals(other.getBrand()) && (this.type).equals(other.getType()) && this.price == other.getPrice());
	}

}
