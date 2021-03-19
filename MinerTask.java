
/*2.	A Miner Task
Until you receive "stop" command, you will be given a sequence 
of strings, each on a new line. Every odd line on the console is representing
 a resource (e.g. Gold, Silver, Copper, etc.) and every even - quantity.
  Your task is to collect the resources and print them each on a new line.
Print the resources and their quantities in format: {resource} –> {quantity}
The quantities inputs will be in the range [1 … 2 000 000 000]
Examples
Input	Output		Input	Output
Gold
155
Silver
10
Copper
17
stop	Gold -> 155
Silver -> 10
Copper -> 17		gold
155
silver
10
copper
17
gold
15
stop	gold -> 170
silver -> 10
copper -> 17

 * */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Map<String, Integer> materialResource = new LinkedHashMap<>();
		String material = scanner.nextLine();
		
		while (!material.equals("stop")) {
			int quantityMaterial = Integer.parseInt(scanner.nextLine());
			
			if (!materialResource.containsKey(material)) {
				materialResource.put(material, quantityMaterial);
			} else {
				materialResource.put(material, materialResource.get(material)+quantityMaterial);
			}
			material = scanner.nextLine();
		}
		printMaterial(materialResource);
	}
	public static void printMaterial(Map<String, Integer> materialResource) {
		for (Map.Entry<String, Integer>entry: materialResource.entrySet()) {
			System.out.println( entry.getKey()+" -> "+entry.getValue());
		}
	}
}
