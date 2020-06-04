import java.util.Scanner;

//-----------------------------------------------------
//Assignment 1 
//Question: Part II
// Written by: Marita Brichan (40138194) and Mohona Mazumdar (40129421)
//-----------------------------------------------------


public class Driver {  
	/* 
	 * 
	 * This program will help store owners to store appliances in a program 
	 * with their information such as the price, the brand and what type of appliance they are
	 * it will firstly ask the user what he wants to do, he can add new appliances
	 * change some informations such as price, brand and/or type
	 * it can also search for all the products in the same brand
	 * it can also search for all the products  under a certain price chosen by the user
	 *
	 */

	public static void main(String[] args) {
		//Scanner object is created to read input from the user
		Scanner keyIn = new Scanner(System.in); 

		//Displays the opening message
		System.out.println("\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n\t*\t\t\t\t\t\t*" + "\n\t*\tWelcome to Marita and Mohona's program\t*"+"\n\t*\t\t\t\t\t\t*"+ "\n\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");

		//Prompts the user to enter the number of appliances
		System.out.println("How many appliances would you like for your store?");

		//variable of type integer that will store the maximum number of appliances entered by user
		int maxAppliances = keyIn.nextInt();

		//an array of objects of the size entered by the user
		Appliance [] inventory = new Appliance[maxAppliances];

		//a variable of type boolean
		boolean program = false;

		//a variable of type integer set to the value 0 that will count how many times the user got the password wrong
		int passwordCount = 0;

		//a while loop so that the program runs as long as the user wants it to
		while(!program){
			
			//Display a message asking the used what he wants to do
			System.out.println("What do you want to do?" + "\n\t1.\tEnter new appliances (password required)" +
					"\n\t2.\tChange information of an appliance (password required)" +
					"\n\t3.\tDisplay all appliances by a specific brand" + 
					"\n\t4.\tDisplay all appliances under a certain a price" + 
					"\n\t5.\tQuit" +
					"\nPlease enter your choice");
			
			//an integer variable that will represent the user's choice of what he wants to do
			int choice = keyIn.nextInt();
			
			//a String constant that will store the password in order for the user to have access to certain changes and informations
			final String PASSWORD = "c249";
			
			//if the user wants to enter new appliances (choice 1)
			if(choice == 1) {
				
				//ask the user to enter the password
				System.out.println("Please the enter the password");
				
				//a string that represents the password typed by the user
				String pass = keyIn.next();
				
				//count this as a password attempt in case it is not right (to be verified later)
				passwordCount++;
				
				//a boolean for a loop that represents the right password, in order to enter a loop and ask the user to enter his password multiple times in case he gets it wrong
				boolean rightPassword = false;
				
				//a while loop in order for the program to ask the user to enter his password multiple times in case he gets it wrong
				while(!rightPassword){
					
					//if the password is correct, then everything is good and the user can do the wanted operations
					if (pass.equals(PASSWORD)){
						
						//change the value of rightPassword, because in this case the user has entered the right password
						rightPassword = true;
						
						//reinitialize the password count in case the user wants to go back, he'd still have 12 attempts before the program crashes
						passwordCount = 0;

						//Prompts the user for the number of appliances to add
						System.out.println("How many appliances would you like to add?");

						//a variable of type integer to store the number of appliances that the user wants to enter for the moment 
						int numOfAppliances = keyIn.nextInt();

						//this is variable of type boolean that creates a loops in order for the user to put in as much appliances as he want
						boolean appliance = true;

						//While loop that will iterate as long as the boolean is true in order to be able to add multiple appliances
						while (appliance) {

							//Conditional statement assuring that the number of new appliances entered by the user
							//is less than or equal to the number of spaces left to add appliances in the store
							if (numOfAppliances<=maxAppliances-Appliance.findNumberOfCreatedAppliances()) {
								
								//k represents the number of appliances created before entering the loop
								int k = Appliance.findNumberOfCreatedAppliances();
								
								//a for loop that will create new objects in the array, as much as the user wanted at the beginning
								for (int i=Appliance.findNumberOfCreatedAppliances(); i<(numOfAppliances+k);i++ ){

									//Prompts the user to enter the type of the new appliance
									System.out.println("For the appliance "+(i+1)+ ", give the following "+
											"information.\n1.Type:");

									//an object of type String that points to the type entered by the user
									String typeFirst = keyIn.next();

									//an object String that points to the type entered by the user too, in case it is composed of more than one word, it will read what is left on the line
									String typeSecond = keyIn.nextLine();
									
									//put all the words typed by the user to compare the type
									String theType = typeFirst + typeSecond;
									
									//a boolean in order to know if the object typed by the user is one of the accepted ones
									boolean rightType = false;
									
									//if the type is not an accepted one, then promote the user to enter it a second time with the while loop
									if(!(theType.equalsIgnoreCase("fridge")||theType.equalsIgnoreCase("air conditioner")||theType.equalsIgnoreCase("washer")||theType.equalsIgnoreCase("dryer")||theType.equalsIgnoreCase("freezer")||theType.equalsIgnoreCase("stove")||theType.equalsIgnoreCase("dishwasher")||theType.equalsIgnoreCase("water heaters")||theType.equalsIgnoreCase("microwave"))) {
									
										while(!rightType) {
											
											//Display an error message
											System.out.println("!!!Error, this type does not exist, try again.");
											
											//ask the user to type in his type again
											typeFirst = keyIn.next();
											typeSecond = keyIn.nextLine();
											theType = typeFirst + typeSecond;
											
											//if the type is an accepted one, then we get out of the loop, of else, ask the user again and again until he gets it right
											if(theType.equalsIgnoreCase("fridge")||theType.equalsIgnoreCase("air conditioner")||theType.equalsIgnoreCase("washer")||theType.equalsIgnoreCase("dryer")||theType.equalsIgnoreCase("freezer")||theType.equalsIgnoreCase("stove")||theType.equalsIgnoreCase("dishwasher")||theType.equalsIgnoreCase("water heaters")||theType.equalsIgnoreCase("microwave")) {
												
												rightType = true;
												
												break;
											
											}
											
										}
									
									}

									//Prompts the user to enter the brand name of the new appliance the user wishes to add
									System.out.println("2.Brand:");

									//an object String that points to the brand entered by the user
									String theBrand = keyIn.next();

									//Prompts the user to enter the price of the new appliance the user wishes to add
									System.out.println("3.price:");

									//a variable of type double to point to the value of the price entered by the user
									double thePrice = keyIn.nextDouble();

									//Create the object of type appliance with the information given by the user and stores it in the array of type appliance
									inventory [i] = new Appliance(theType,theBrand,thePrice); 

									//Displays the information of the new appliance added by the user 
									System.out.println("You just added:\n" + inventory[i]);
								}
								//Changes the value of the boolean appliance to false as the program is done adding new appliances for the user to exit the loop
								appliance = false;
							}

							//Conditional else statement in the case where the number of new appliances the user wishes to add is greater than the maximum space for appliances
							else {

								//While loop that iterates as long as the number of appliances the user wishes to add is greater than the number of spaces left in the store
								while (numOfAppliances!=(maxAppliances-Appliance.findNumberOfCreatedAppliances())||numOfAppliances>(maxAppliances-Appliance.findNumberOfCreatedAppliances())){

									//Displays to the user the number of spaces for appliances he/she can add in the store
									System.out.println("You can only add "+ (maxAppliances-Appliance.findNumberOfCreatedAppliances())+
											" appliances.");

									//Prompts the user to enter the number of appliances the user wishes to add
									System.out.println("How many appliances would you like to add?");

									//Stores the number entered by the user in the variable of how many appliances he wants to add
									numOfAppliances = keyIn.nextInt();

									//Conditional statement to check whether the number of appliances the user
									//wishes to add is less than or equal to the number of spaces left to add appliances in the store
									if (numOfAppliances<=maxAppliances-Appliance.findNumberOfCreatedAppliances())

										//If the conditional statement is satisfied, breaks from the while loop
										break;
								}
							}
						}

						//Prompts the user to enter a number that corresponds to his next action
						System.out.println("What do you want to do now?" +
								"\n\t1.\tGo back to the main meanu" + 
								"\n\t2.\tQuit the program");

						//a variable of type integer that points to the number entered by the user to know what the user chooses to do next
						int brandChoice = keyIn.nextInt();

						//Conditional statement in the case where the number entered by the user is 1
						if(brandChoice == 1) {

							//If the conditional statement is satisfied, breaks from the current loop
							break;
						}

						//Conditional statement in the case where the number entered by the user is 2
						if(brandChoice == 2) {

							//Displays the closing message 
							System.out.println("Quitting... Thank you for using this program for your store!");

							//Exits from the program
							System.exit(0);
						}
					}
					
					//if the password entered is wrong
					else{
						//change the value of wrongPassword to true, because now it's obvious that the password is wrong
						boolean wrongPassword = true;
						//enter a loop to ask the user to enter the password 2 more times before sending him back to the main menu in case he gets in wrong 3 times
						for(int i=0; i<2 ; i++){
							//count how many attempts the user tried
							passwordCount++;
							//display an error message
							System.out.print("Wrong password. Try again.");
							//ask the use to type the password again
							pass = keyIn.next();
							//if the typed password is right, then change the value of wrongPassword, and get allow the user to do the changes he wants by exiting this loop
							if(pass.equals(PASSWORD)){
								wrongPassword = false;
								break;
							}
						}
						
						//if the password have been types 3, 6 or 9 times, get the user back to the main menu, if the user types it wrong 12 times, then exit the whole program and display an error message not allowing him to type anymore password attempts
						if(passwordCount%3 == 0 && wrongPassword){
							if(passwordCount == 12){
								System.out.print("Program detected suspicious activities and will terminate immediately!");
								System.exit(0);
							}
							break;
						}
					}
				}
			}

			//In the case where the choice of the user from the menu is 2
			else if(choice == 2) {

				//ask the user to enter the password
				System.out.println("Please the enter the password");
				
				//a string that represents the password typed by the user
				String pass = keyIn.next();
				
				//count this as a password attempt in case it is not right (to be verified later)
				passwordCount++;
				
				//a boolean for a loop to know if the typed password is right or not
				boolean rightPassword = false;
				
				//a while loop in order for the program to ask the user to enter his password multiple times in case he gets it wrong
				while(!rightPassword){
					
					//if the password is correct, then everything is good and the user can do the wanted operations
					if (pass.equals(PASSWORD)){
						
						rightPassword = true;
						
						//reinitialize the password count in case the user wants to go back, he'd still have 12 attempts before the program crashes
						passwordCount = 0;

						//Prompts the user to enter the serial number of the appliance the user wishes to change
						System.out.println("Enter the serial number of the appliance you would like to update.");

						//a boolean that points to the value false as long as the serial number does not point to an object
						boolean serialNumExists = false;

						//a variable of type integer that points to the value 0 for the loop, but it is initialized here, because its value will be used later on after the for loop
						int i=0;

						//While loop that iterates as long as the boolean serialNumExists is true in order to ask the user to retype the serial number in case it does not point to any objects or he wants to change the object he is working on
						while (!serialNumExists) {
							
							//a variable of type long that points to the value entered by the user
							long serialNum = keyIn.nextLong();
							
							//For loop that iterates as many times as the number of items in the inventory array
							for (i=0; i<inventory.length; i++){
								
								if (inventory[i]!=null) {
								//Conditional statement that checks whether the serial number entered by the user equals 
								//to one of the serial numbers of the objects in the array
								if (inventory[i].getSerialNum()==serialNum) {
									
									//Displays the information of the appliance asked by the user
									System.out.println(inventory[i]);
									
									//Changes the boolean value to true in order to indicate that the serial number points to a certain object
									serialNumExists = true;
									break;
								}
							}
						}

							//Conditional statement that executes only if satisfied by the boolean in case the serial number does not point to any objects
							if (!serialNumExists) {

								//Displays the message that informs the user of an error with the serial number
								//and gives options for the user's next actions
								System.out.println("There is no appliance in the inventory with this serial number.\n"+
										"What would you like to do?" +"\n\t 1.Enter another serial number" +
										"\n\t 2.Quit this program" + "\n\t 3.Go back to the main menu");

								//a variable of type integer that points to a number entered by the user to know what he wants to do next
								int option = keyIn.nextInt();

								//Conditional statement which checks if the number entered by the user is 1
								if (option==1) {

									//Continues the current loop, which allows the user to retype the serial number
									System.out.println("Enter the serial number:");
									
									continue;
									
								}
								
								//Conditional statement which   exits the program
								else if (option==2)
									System.exit(0);
								
								//conditional statement to exit this loop and go back to the main menu
								else if(option==3)
									break;
								
							}
							
						}
						
						//since there is 2 nested loops, this statement allows for the program to go back to the main menu in case the user chooses to
						if(!serialNumExists)
							break;
						
						//a boolean that represents how if the user wants to continue making change to the appliances or not
						boolean change = false;
						
						//while loop that works as long as the user wants to make changes to his appliances again and again
						while(!change)
						{
							//Display a message asking the user what he wants to do
							System.out.println("What information would you like to change?" + 
									"\n\t1.\tbrand" + 
									"\n\t2.\ttype" +
									"\n\t3.\tprice" +
									"\n\t4.\tQuit" +  
									"\nEnter your choice>");
							
							//changeChoice represents what the user chooses to do
							int changeChoice = keyIn.nextInt();

							//if the user chooses to change the brand
							if(changeChoice == 1){
								//ask the user o what brand he wants to change it
								System.out.println("To what brand would you like to change the object?");
								//newBrand is the brand to which the user wants to change it
								String newBrand = keyIn.next();
								//change it in the object
								inventory[i].setBrand(newBrand);
								//display the change done
								System.out.println(inventory[i]);
								//ask the user what he wants to do next
								System.out.println("What do you want to do now?" +
										"\n\t1.\tChange another information for the same object" +
										"\n\t2.\tGo back to the main menu" + 
										"\n\t3.\tQuit the program");
								//brandChoice is what the user chooses to do next
								int brandChoice = keyIn.nextInt();
								//is he chooses to change another information, go back to the beginning of this loop with continue
								if(brandChoice == 1) {
									continue;
								}

								//if he chooses to go back to the main menu, then break out of this loop and go back to the main menu
								if(brandChoice == 2) {
									break;
								}

								//if the user chooses to exit the program, then exit the program, but display an existing message first
								if(brandChoice == 3) {
									System.out.println("Quitting... Thank you for using this program for your store!");
									System.exit(0);
								}
							}

							//if the user decides to change the type of the object
							else if(changeChoice == 2){
								//ask him to what he wants to change
								System.out.println("To what type would you like to change the object?");
								//typeFirst is the first word of the type to which the user wants to change
								String typeFirst = keyIn.next();
								//typeSecond is the rest of the name of the type, in case it is made out of more than one word
								String typeSecond = keyIn.nextLine();
								//put all the words together in newType, which represents the new type to which the user wants to change the object
								String newType = typeFirst + typeSecond;	
								
								//rightType represents if the user types an accepted type
								boolean rightType = false;
								//if it is not an accepted type
								if(!((newType.equalsIgnoreCase("fridge")||newType.equalsIgnoreCase("air conditioner")||newType.equalsIgnoreCase("washer")||newType.equalsIgnoreCase("dryer")||newType.equalsIgnoreCase("freezer")||newType.equalsIgnoreCase("stove")||newType.equalsIgnoreCase("dishwasher")||newType.equalsIgnoreCase("water heaters")||newType.equalsIgnoreCase("microwave")))) {
									//enter a loop which will ask again and again until he gets a type that is accepted
									while(!rightType) {
										//display an error message
										System.out.println("!!!Error, this type does not exist, try again.");
										//change the type user's input
										typeFirst = keyIn.next();
										typeSecond = keyIn.nextLine();
										newType = typeFirst + typeSecond;
										//verify if the type is accepted 
										if(newType.equalsIgnoreCase("fridge")||newType.equalsIgnoreCase("air conditioner")||newType.equalsIgnoreCase("washer")||newType.equalsIgnoreCase("dryer")||newType.equalsIgnoreCase("freezer")||newType.equalsIgnoreCase("stove")||newType.equalsIgnoreCase("dishwasher")||newType.equalsIgnoreCase("water heaters")||newType.equalsIgnoreCase("microwave")) {
											//if the type is accepted, then set it
											inventory[i].setType(newType);
											//change the value of rightType
											rightType = true;
											//display the appliance with the change to the user
											System.out.println(inventory[i]);
											//break out of this loop
											break;
										}
									}
								}
								
								//if the type is an accepted one
								else {
									//set the new type
									inventory[i].setType(newType);
									//display the appliance along with the new change
									System.out.println(inventory[i]);
								}
								
								//ask the user what he wants to do 
								System.out.println("What do you want to do now?" +
										"\n\t1.\tChange another information for the same object" +
										"\n\t2.\tGo back to the main menu" + 
										"\n\t3.\tQuit the program");
								
								//typeChoice represents the user's choice of what to do next
								int typeChoice = keyIn.nextInt();
								
								//is he chooses to change another information, go back to the beginning of this loop with continue
								if(typeChoice == 1) {
									continue;
								}

								//if he chooses to go back to the main menu, then break out of this loop and go back to the main menu
								if(typeChoice == 2) {
									break;
								}

								//if the user chooses to exit the program, then exit the program, but display an existing message first
								if(typeChoice == 3) {
									System.out.println("Quitting... Thank you for using this program for your store!");
									System.exit(0);
								}
							}
							
							//if the user chooses to change the price
							else if(changeChoice == 3){
								//ask the user to what he wants to change the price
								System.out.println("To what price would you like to change the object?");
								//newPrice represents the price change that the user wants
								double newPrice = keyIn.nextDouble();
								//set the new price in the appliance 
								inventory[i].setPrice(newPrice);
								//display the object along with the new change 
								System.out.println(inventory[i]);
								//ask the user what he wants to do next
								System.out.println("What do you want to do now?" +
										"\n\t1.\tChange another information for the same object" +
										"\n\t2.\tGo back to the main menu" + 
										"\n\t3.\tQuit the program");
								
								//priceChoice is what the user chooses to do next
								int priceChoice = keyIn.nextInt();
								
								//is he chooses to change another information, go back to the beginning of this loop with continue
								if(priceChoice == 1) {
									continue;
								}

								//if he chooses to go back to the main menu, then break out of this loop and go back to the main menu
								if(priceChoice == 2) {
									break;
								}

								//if the user chooses to exit the program, then exit the program, but display an existing message first
								if(priceChoice == 3) {
									System.out.println("Quitting... Thank you for using this program for your store!");
									System.exit(0);
								}
							}
							
							//if the user chooses to quit, then get out of this loop, and go back to the main menu with the break and change the "change" variable value to true, since he does not want to make any more changes
							else if(changeChoice == 4){
								change = true;
								break;
							}

							//if the user chose any other number than what was suggested, display an error message
							else{
								System.out.println("Error! This is not an allowed choice.");
							}
						} 
					}
					
					//if the password entered is wrong
					else{
						//change the value of wrongPassword to true, because now it's obvious that the password is wrong
						boolean wrongPassword = true;
						//enter a loop to ask the user to enter the password 2 more times before sending him back to the main menu in case he gets in wrong 3 times
						for(int i=0; i<2 ; i++){
							//count how many attempts the user tried
							passwordCount++;
							//display an error message
							System.out.print("Wrong password. Try again.");
							//ask the use to type the password again
							pass = keyIn.next();
							//if the typed password is right, then change the value of wrongPassword, and get allow the user to do the changes he wants by exiting this loop
							if(pass.equals(PASSWORD)){
								wrongPassword = false;
								break;
							}
						}
						
						//if the password have been types 3, 6 or 9 times, get the user back to the main menu, if the user types it wrong 12 times, then exit the whole program and display an error message not allowing him to type anymore password attempts
						if(passwordCount%3 == 0 && wrongPassword){
							break;
						}
					}
				}
			}

			//Conditional statement in the case where the user picks choice 3 from the menu
			else if(choice == 3) {


				//a boolean in order to enter a loop in case the user wants to search for more than one brand or the wanted brand does not exist
				boolean brand = false;

				//While loop that iterates in case the user wants to search another brand or the brand does not exist, to allow him to retype it again and do the search again and again until he chooses otherwise
				while(!brand) {

					//a boolean that indicates if the brand exists or not in the store
					boolean brandExists = false;

					//Prompts the user to enter the brand name of the appliances the user wishes to display
					System.out.println("Enter the brand name of the appliances you would like to be displayed");

					//a String that points to the data entered by user to know what brand the user wants to search
					String chosenBrand = keyIn.next();
					
					//enter a for loop to find appliances with this brand name, display it and then change the value of brandExists in order to know that there are appliances with this brand name
					for (int j=0; j<Appliance.findNumberOfCreatedAppliances();j++){
						if (chosenBrand.equalsIgnoreCase(inventory[j].getBrand())) {
							System.out.println(inventory[j]);
							brandExists = true;
						}
					}

					//In the case where there are no appliances with this brand name Display an error message and ask the user what he wants to do next
					if(!brandExists) {
						System.out.println("There is no appliances with this brand name. What do you want to do?" +
								"\n\t1.\tReenter another brand name" + 
								"\n\t2.\tGo back to the main meanu" + 
								"\n\t3.\tQuit the program");
					}

					//if there are appliances in this brand name, still ask the user what he wants to do next
					else {

						//Prompts the user to choose from one of the options
						System.out.println("What do you want to do now?" +
								"\n\t1.\tReenter another brand name" +
								"\n\t2.\tGo back to the main meanu" + 
								"\n\t3.\tQuit the program");
					}

					//a variable of type integer that reads input from the user that represents what the user chooses to do next
					int brandChoice = keyIn.nextInt();

					//In the case where the choice from the user is 1
					if(brandChoice == 1) {
						//go back to the beginning of this loop and let the user enter another brand name
						continue;
					}

					//In the case where the choice from the user is 2
					if(brandChoice == 2) {
						//break from this loop to go back to the main menu
						break;
					}

					//In the case  where the choice is 3
					if(brandChoice == 3) { 

						//Displays the exit message
						System.out.println("Quitting... Thank you for using this program for your store!");

						//Exits from the program
						System.exit(0);
					}

				}
			}


			//In the case where the choice entered by the user from the menu is 4
			else if(choice == 4) {
				
				//a boolean the represents the loop for finding appliance cheaper than, in case the user wants to type another price or types the wrong password, to let him try again
				boolean price = false;


				//While loop that iterates as long as the boolean is false, to let the user types another price in case he wants to or gets types a price with no cheaper products
				while(!price) {

					//a boolean that represents if the price exists, which means that there are appliances with a price cheaper than the price entered by the user
					boolean priceExists = false;
					//Prompts the user to enter the maximum price at which the appliances the user wants to display
					System.out.println("Enter the maximum price of the appliances you would like to be displayed");
					
					//a double variable that indicates the price that the user chooses to use to find appliances cheaper than this
					double choosenNum = keyIn.nextDouble();

					//For loop that iterates as many times as the number of appliance objects  to know if there are any appliances with a price under the one chosen by the user, display the appliances to the user and change the value of pricExists in order to know that it was possible to find appliances cheaper than what the user types
					for  (int i=0; i<Appliance.findNumberOfCreatedAppliances();i++) {

						//In the case where the object in the array has the same price or is less than the price entered by user
						if (inventory[i].getPrice()<= choosenNum) {

							//Displays the information of the appliance object 
							System.out.println(inventory[i]); 
							priceExists = true;}
					}


					//In the case there are no appliances equal or under the price display an error message and ask the user what he wants to do next
					if (!priceExists) {
						System.out.println("There is no appliances equal or under this price. What do you want to do?" +
								"\n\t1.\tReenter another the price" + 
								"\n\t2.\tGo back to the main menu" + 
								"\n\t3.\tQuit the program");
					}

					//Prompts the user to choose an option for his next actions
					else {
						System.out.println("What do you want to do now?" + 
								"\n\t1.\tReenter another price" +
								"\n\t2.\tGo back to the main menu" + 
								"\n\t3.\tQuit the program");
					}
					
					//priceChoice represents the user choice of what to do next
					int priceChoice = keyIn.nextInt();

					//In the case where the choice from the user is 1
					if(priceChoice == 1) {

						//Go back to the beginning of the current loop and starts another iteration
						continue;
					}

					//In the case where the choice from the user is 2
					if(priceChoice == 2) {

						//In the case where the choice from the user is 2, break this loop and go back to the main menu
						break;
					}

					//In the case where the choice from the user is 3
					if(priceChoice == 3) {

						//Displays the exit message
						System.out.println("Quitting... Thank you for using this program for your store!");

						//Exits from the program
						System.exit(0);
					}
				}
			}

			else if(choice == 5) {

				//Displays the exit message
				System.out.println("Quitting... Thank you for using this program for your store!");

				//Breaks from the current loop
				break;
			}

			else {

				//Breaks the loop and starts a new iteration
				continue;
			}			
		}

		//Closes the scanner object
		keyIn.close();

	}

}