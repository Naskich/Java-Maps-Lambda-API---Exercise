
/*4.	Orders
Write a program, which keeps information about products and their prices. Each product has a name, a price and its quantity. If the product doesn't exist yet, add it with its starting quantity.
If you receive a product, which already exists, increase its quantity by the input quantity and if its price is different, replace the price as well.
You will receive products' names, prices and quantities on new lines. Until you receive the command "buy", keep adding items. When you do receive the command "buy", print the items with their names and total price of all the products with that name. 
Input
•	Until you receive "buy", the products come in the format: "{name} {price} {quantity}"
•	The product data is always delimited by a single space
Output
•	Print information about each product, following the format: 
"{productName} -> {totalPrice}"
•	Format the average grade to the 2nd decimal place
Examples
Input	Output
Beer 2.20 100
IceTea 1.50 50
NukaCola 3.30 80
Water 1.00 500
buy	Beer -> 220.00
IceTea -> 75.00
NukaCola -> 264.00
Water -> 500.00
Beer 2.40 350
Water 1.25 200
IceTea 5.20 100
Beer 1.20 200
IceTea 0.50 120
buy	Beer -> 660.00
Water -> 250.00
IceTea -> 110.00
CesarSalad 10.20 25
SuperEnergy 0.80 400
Beer 1.35 350
IceCream 1.50 25
buy	CesarSalad -> 255.00
SuperEnergy -> 320.00
Beer -> 472.50
IceCream -> 37.50

 * */

import java.nio.Buffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

	public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);		
		
		Map<String, Double> productsPrice = new LinkedHashMap<>();
		Map<String, Integer> productsQuantity = new LinkedHashMap<>();
		
		String productsCommand = scanner.nextLine();
		while (!productsCommand.equals("buy")) {
			
			String input = productsCommand.split(" ")[0];
			double priceProduct = Double.parseDouble(productsCommand.split(" ")[1]);
			int quantityProduct = Integer.parseInt(productsCommand.split(" ")[2]);
			
			productsPrice.put(input, priceProduct);
			
			if (!productsQuantity.containsKey(input)) {
				productsQuantity.put(input, quantityProduct);	
			} else {
				productsQuantity.put(input, productsQuantity.get(input)+quantityProduct);
			}				
			productsCommand = scanner.nextLine();
			}	
		
	System.out.println();
	for (Map.Entry<String, Double>entry: productsPrice.entrySet()) {
		String nameProduct = entry.getKey();
		Double sumProduct = entry.getValue() * productsQuantity.get(nameProduct);
		System.out.printf("%s -> %.2f%n",nameProduct,sumProduct);

		}
	}
}