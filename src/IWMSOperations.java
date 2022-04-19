import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class IWMSOperations {
	public ArrayList<String> 		productID = new ArrayList<String>();
	public ArrayList<String> 		itemName = new ArrayList<String>();
	public ArrayList<String> 		producer = new ArrayList<String>();
	public ArrayList<String> 		itemCategory = new ArrayList<String>();
	public ArrayList<Integer> 		locationCode = new ArrayList<Integer>();
	public ArrayList<Double> 		productPrice = new ArrayList<Double>();
	public ArrayList<Double> 		listingPrice = new ArrayList<Double>();
	public ArrayList<Double> 		discount  	= new ArrayList<Double>();
	public ArrayList<Integer> 		itemQuantity  = new ArrayList<Integer>();
	public ArrayList<LocalDateTime> datePurchased = new ArrayList<LocalDateTime>();
	public ArrayList<LocalDateTime> dateExpired 	= new ArrayList<LocalDateTime>();


	public ArrayList<String> 		productIDDel = new ArrayList<String>();
	public ArrayList<String> 		itemNameDel = new ArrayList<String>();
	public ArrayList<String> 		producerDel = new ArrayList<String>();
	public ArrayList<String> 		itemCategoryDel = new ArrayList<String>();
	public ArrayList<Integer> 		locationCodeDel = new ArrayList<Integer>();
	public ArrayList<Double> 		productPriceDel = new ArrayList<Double>();
	public ArrayList<Double> 		listingPriceDel = new ArrayList<Double>();
	public ArrayList<Double> 		discountDel  = new ArrayList<Double>();
	public ArrayList<Integer> 		itemQuantityDel = new ArrayList<Integer>();
	public ArrayList<LocalDateTime> datePurchasedDel = new ArrayList<LocalDateTime>();
	public ArrayList<LocalDateTime> dateExpiredDel 	= new ArrayList<LocalDateTime>();


	public void loadEntries() {
	ProductList PL = new ProductList();	// Accessing attribute lists from class methods 

		//ProductId
		String productIDArrLoad[] = PL.getProductID();
		String itemNameArr[] = PL.getItemName();
		String producerArr[] = PL.getProducer();
		String itemCategoryArr[] = PL.getItemCategory();
		int locationCodeArr[] = PL.getLocationCode();
		double productPriceArr[] = PL.getProductPrice();
		double listingPriceArr[] = PL.getListingPrice();
		double discountArr[] = PL.getDiscount();
		int itemQuantityArr[] = PL.getItemQuantity();
		LocalDateTime datePurchasedArr[] = PL.getDatePurchased();
		LocalDateTime dateExpiredArr[] = PL.getDateExpired();


		for(int i=0;i<productIDArrLoad.length;i++){
			productID.add(productIDArrLoad[i]);
			itemName.add(itemNameArr[i]);
			producer.add(producerArr[i]);
			itemCategory.add(itemCategoryArr[i]);
			locationCode.add(locationCodeArr[i]);
			productPrice.add(productPriceArr[i]);
			listingPrice.add(listingPriceArr[i]);
			discount.add(discountArr[i]);
			itemQuantity.add(itemQuantityArr[i]);
			datePurchased.add(datePurchasedArr[i]);
			dateExpired.add(dateExpiredArr[i]);
		}
		
	}
	
	// Method to display all attributes
	public void displayAllAttributes(int i) {
		System.out.println("\n");
		System.out.println("ProductID : " + productID.get(i));
		System.out.println("Product Name : " + itemName.get(i));
		System.out.println("Producer : " + producer.get(i));
		System.out.println("Product Type Code : " + itemCategory.get(i));
		System.out.println("Location Code : " + locationCode.get(i));
		System.out.println("Product Price : " + productPrice.get(i));
		System.out.println("Listing Price : " + listingPrice.get(i));
		System.out.println("Discount(%) : " + discount.get(i));
		System.out.println("Item Quantity : " + itemQuantity.get(i));
		System.out.println("Date Purchased : " + datePurchased.get(i));
		System.out.println("Date Expired : " + dateExpired.get(i));
	}
	//1: search product my product name
	public void searchProductsByProdutName() {
		String name;
		boolean productFound = false;
		System.out.println("Please enter the product name to be searched : ");
		Scanner sc1 = new Scanner(System.in);
		name = sc1.nextLine();
		for(int i=0 ; i<productID.size() ; i++){
			String products;
			products = itemName.get(i);		// Remove and replace all white spaces for easier comparison
			boolean found = products.equalsIgnoreCase(name);		// Matching input search value with product ID list of values
			
			if(found){
				displayAllAttributes(i);
				productFound = true;
			}
		}
		if(productFound == false) {
			System.out.println("No record found with product name: " + name);
		}
	}
	
	//2: search product by other attributes
	public void searchProductsByOtherAttributes() {
		 String choice;
		 int value1 = 0,attribute = 0;
		 String value2 = null;
		 String product3;
		  
		 System.out.println("Please enter the product attribute type to be searched : a)Integer or b)String ");   //User input product attribute type
		 Scanner sc3 = new Scanner(System.in);
		 choice = sc3.next();
		  
		 if(choice.equalsIgnoreCase("a")){
			 System.out.println("Please enter the product attribute integer value to be searched : ");  //User input product attribute integer value
			 Scanner sc4 = new Scanner(System.in);
			 value1 = sc4.nextInt();
		  }
		  
		  if(choice.equalsIgnoreCase("b")){
			  System.out.println("Please enter the product attribute string value to be searched : ");   //User input product attribute string value
			  Scanner sc5 = new Scanner(System.in);
			  value2 = sc5.next();
		  }
				  
			System.out.println("Please enter the attribute based on which product to be searched : "
				  + "\n 1.Product ID  2.Product Name  3.Producer  4.Product Type Code"
				  + "\n 5.Location Code  6.Retail Price  7.Listing Price  8.Discount(%) 9.Stock Quantity"); //User input product attribute to be searched
		  Scanner sc2 = new Scanner(System.in);
		  attribute = sc2.nextInt();
		  switch(attribute) {
		  	case 1:	for(int i=0 ; i<productID.size() ; i++){
			  			if(productID.get(i).equals(value2))
			  				displayAllAttributes(i);
			  			}
		  			break;
		  			
		  	case 2:	for(int i=0 ; i<itemName.size() ; i++){	
		  				product3 = itemName.get(i).replaceAll("\\s","");
		  				if(product3.equalsIgnoreCase(value2))
		  					displayAllAttributes(i);
		  				}
		  			break;
			case 3: for(int i=0 ; i<producer.size() ; i++){
						if(producer.get(i).equalsIgnoreCase(value2))
							displayAllAttributes(i);
					}
					break;
			case 4: for(int i=0 ; i<itemCategory.size() ; i++){
						if(itemCategory.get(i).equalsIgnoreCase(value2))
							displayAllAttributes(i);
					}
					break;
			case 5: for(int i=0 ; i<locationCode.size() ; i++){
						if(locationCode.get(i).equals(value1))
							displayAllAttributes(i);
					}
					break;
			case 6: for(int i=0 ; i<productPrice.size() ; i++){
						if(productPrice.get(i).equals(value1))
							displayAllAttributes(i);
					}
					break;
			case 7: for(int i=0 ; i<listingPrice.size() ; i++){
						if(listingPrice.get(i).equals(value1))
							displayAllAttributes(i);
					}
					break;
			case 8: for(int i=0 ; i<discount.size() ; i++){
						if(discount.get(i).equals(value1))
							displayAllAttributes(i);
					}
					break;
			case 9: for(int i=0 ; i<itemQuantity.size() ; i++){
						if(itemQuantity.get(i).equals(value1))
							displayAllAttributes(i);
					}
					break;
			default: System.out.println("Invalid input");

					
		  }
	}
	
	//3: show entire inventory
	public void showEntireInventory() {
		System.out.println("********************************************");
		System.out.println("************* Full INVENTORY ***************");
		System.out.println("********************************************");		
		for(int i=0 ; i<productID.size() ; i++){		// Display entire inventory with all attributes
			displayAllAttributes(i);
		 }

	}
	
	//4: show inventory by producer
	public void showInventoryByProducer() {
		System.out.println("INVENTORY BY PRODUCER : \n ");
		for(int i=0 ; i<producer.size() ; i++) {
			System.out.println("Product ID : " + productID.get(i));
			System.out.println("Product Name : " + itemName.get(i));
			System.out.println("Producer : " + producer.get(i));
			System.out.println("");
		 }
	}
	
	//5: show inventory by Location Code
	public void showInventoryByLocationCode() {
		System.out.println("INVENTORY BY Location Code : \n ");							// Display inventory By Type
		for(int i=0 ; i<locationCode.size() ; i++){
			System.out.println("Product ID : " + productID.get(i));
			System.out.println("Product Name : " + itemName.get(i));
			System.out.println("Location Code : " + locationCode.get(i));
			System.out.println("");
		}
	}
	
	//6: List products by product price
	public void listProductsByPrice() {
		System.out.println("LIST OF PRODUCTS BY PRODUCT PRICE : \n ");					// Display list of products by price
		for(int i=0 ; i<productPrice.size() ; i++) {
			System.out.println("Product ID : " + productID.get(i));
			System.out.println("Product Name : " + itemName.get(i));
		    System.out.println("Product Price : " + productPrice.get(i));
		    System.out.println("");
		}
	}
	
	//7: List products by item quantity
	public void listProductsbyAvailability() {
		System.out.println("LIST OF PRODUCTS BY STOCK : \n ");					// Display list of products by stock
		for(int i=0 ; i<itemQuantity.size() ; i++) {
			System.out.println("Product ID : " + productID.get(i));
			System.out.println("Product Name : " + itemName.get(i));
			System.out.println("Stock Quantity : " + itemQuantity.get(i));
			System.out.println("");
		}
	}
	
	//8: Show current discount items
	public void showCurrentDiscountItems() {
		System.out.println("LIST OF DISCOUNTED ITEMS : \n ");	// Display list of discounted items where discount price < current price
		for(int i=0 ; i<productID.size() ; i++) {
			  if(listingPrice.get(i) < productPrice.get(i)) {
				  System.out.println("Product ID : " + productID.get(i));
				  System.out.println("Product Name : " + itemName.get(i));
				  System.out.println("Current Price : " + productPrice.get(i));
				  System.out.println("Discount Price : " + listingPrice.get(i));
				  System.out.println("");
			  }
		}
	}
	
	//9: Add record/product
	public void addNewRecod() {
		 System.out.print("Please Enter The Product Id: ");
		 Scanner add = new Scanner(System.in);
		 String addString = add.nextLine();
		 int id = Integer.parseInt(addString);
			// check if record exists
			if(productID.indexOf(id) != -1) {              
				System.out.println("A record with product id: " + id + " already exists");
				return;
			}
		 System.out.print("\nPlease Enter Product Name: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter Producer: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter The Product Type Code: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter The Location Code: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter The Retail Price: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter The Listing Price: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter The Discount: ");
		 addString = addString + "," + add.nextLine();
		 System.out.print("\nPlease Enter The Stock Quantity: ");
		 addString = addString + "," + add.nextLine();
		 addRecord(addString);	
		 System.out.print("\n1 Record was added! ");
	}
	
	public void addRecord(String addString) {
		String[] detailAddArr = addString.split(",");     //Type Conversion based on Inputs of Array List
		int lc = Integer.parseInt(detailAddArr[4]);
		double amsrp = Integer.parseInt(detailAddArr[5]);
		double acp = Integer.parseInt(detailAddArr[6]);
		double adp = Integer.parseInt(detailAddArr[7]);
		int asq = Integer.parseInt(detailAddArr[8]);
		
		productID.add(detailAddArr[0]);								  // Adding User-input record details to the Array lists
		itemName.add(detailAddArr[1]);
		producer.add(detailAddArr[2]);
		itemCategory.add(detailAddArr[3]);
		locationCode.add(lc);
		productPrice.add(amsrp);
		listingPrice.add(acp);
		discount.add(adp);
		itemQuantity.add(asq);
		datePurchased.add(LocalDateTime.now());
		dateExpired.add(LocalDateTime.now().plusMonths(1));
	}
	
	
	//10: Remove record
	
	public void deleteRecord() {
		System.out.println("Please Enter The id of the Product to be deleted");
		Scanner Del = new Scanner(System.in);
		int delId = Del.nextInt();
		deleteRecord(delId);
		System.out.print("\n1 record with product id: " + delId + " was deleted!");
	}
	
	public void deleteRecord(int delId){
		int delIndex = productID.indexOf(delId);		  // Finding index value corresponding to the product ID in the Array list
		// check if record exists
		if(delIndex == -1) {
			System.out.println("No record found with product id: " + delId);
		}
		else {
			productIDDel.add(productID.get(delIndex));
			itemNameDel.add(itemName.get(delIndex));
			producerDel.add(producer.get(delIndex));
			itemCategoryDel.add(itemCategory.get(delIndex));
			locationCodeDel.add(locationCode.get(delIndex));
			productPriceDel.add(productPrice.get(delIndex));
			listingPriceDel.add(listingPrice.get(delIndex));
			discountDel.add(discount.get(delIndex));
			itemQuantityDel.add(itemQuantity.get(delIndex));
			datePurchasedDel.add(datePurchased.get(delIndex));
			dateExpiredDel.add(dateExpired.get(delIndex));

			productID.remove(delIndex);						  // Deleting record details for given productID from the Array lists
			itemName.remove(delIndex);
			producer.remove(delIndex);
			itemCategory.remove(delIndex);
			locationCode.remove(delIndex);
			productPrice.remove(delIndex);
			listingPrice.remove(delIndex);
			discount.remove(delIndex);
			itemQuantity.remove(delIndex);
			datePurchased.remove(delIndex);
			dateExpired.remove(delIndex);
			System.out.println("1 record with product id: " + delId + " was deleted!");
		}
		
	}
	//11: Change record
	public void changeRecord() {
		System.out.println("Please Enter The Product ID of the item you wish to update:");
		Scanner up = new Scanner(System.in);		     
		String updationString = up.nextLine();
		int id = Integer.parseInt(updationString);
		// check if record exists
		if(productID.indexOf(id) == -1) {              
			System.out.println("No record found with product id: " + id);
			return;
		}
		System.out.println("1. Product Name");
		System.out.println("2. Producer");
		System.out.println("3. Product Type Code");
		System.out.println("4. Location Code");
		System.out.println("5. Retail Price");
		System.out.println("6. Listing Price");
		System.out.println("7. Discount");
		System.out.println("Please select a field from above which you would like to update:");
		updationString = updationString + "," + up.nextLine();
		System.out.println("Please enter the updated value:");
		updationString = updationString + "," + up.nextLine();
		updateRecord(updationString);
	}
	
	public void updateRecord(String updationString)
	{
		String[] detailArr = updationString.split(",");						//Type Conversion based on Inputs of Array List
		int id = Integer.parseInt(detailArr[0]);
		int fieldCode = Integer.parseInt(detailArr[1]);
		int uptIndex = productID.indexOf(id);
		
		switch(fieldCode)													//Switch Case to Auto-Select Field to be Updated
		{
		case 1: System.out.println("Product Name Updated");
				itemName.set(uptIndex, detailArr[2]);
				break;
		case 2: System.out.println("Producer Updated");
				producer.set(uptIndex, detailArr[2]);
				break;
		case 3: System.out.println("Product Type Code Updated");
				itemCategory.set(uptIndex, detailArr[2]);
				break;
		case 4: System.out.println("Location Code Updated");
				locationCode.set(uptIndex, Integer.parseInt(detailArr[2]));
				break;
		case 5: System.out.println("Retail Price Updated");
				productPrice.set(uptIndex, Double.parseDouble(detailArr[2]));
				break;	
		case 6: System.out.println("Listing Price Updated");
				listingPrice.set(uptIndex, Double.parseDouble(detailArr[2]));
				break;
		case 7: System.out.println("Discount Updated");
				discount.set(uptIndex, Double.parseDouble(detailArr[2]));
				break;
		case 8: System.out.println("Item Quantity Updated");
				itemQuantity.set(uptIndex, Integer.parseInt(detailArr[2]));
				break;
		default: System.out.println("Invalid field selection!");
		}
	}

	public void rollbackRecord()
	{
		System.out.println("Are you sure you want to rollback recently deleted item? (Y/N)");
		Scanner roll = new Scanner(System.in);
		String rollbackString = roll.nextLine();

		if(rollbackString.equals("Y")){
			if(productIDDel.size() == 0)
			{
				System.out.println("No item to rollback!");
				return;
			}
			productID.add(productIDDel.get(productIDDel.size()-1));
			itemName.add(itemNameDel.get(itemNameDel.size()-1));
			producer.add(producerDel.get(producerDel.size()-1));
			itemCategory.add(itemCategoryDel.get(itemCategoryDel.size()-1));
			locationCode.add(locationCodeDel.get(locationCodeDel.size()-1));
			productPrice.add(productPriceDel.get(productPriceDel.size()-1));
			listingPrice.add(listingPriceDel.get(listingPriceDel.size()-1));
			discount.add(discountDel.get(discountDel.size()-1));
			itemQuantity.add(itemQuantityDel.get(itemQuantityDel.size()-1));
			datePurchased.add(datePurchasedDel.get(datePurchasedDel.size()-1));
			dateExpired.add(dateExpiredDel.get(dateExpiredDel.size()-1));
		}
		else if(rollbackString.equals("N")){
			System.out.println("Rollback Cancelled!");
			return;
		}
		else{
			System.out.println("Invalid Input!");
		}
	}
}
