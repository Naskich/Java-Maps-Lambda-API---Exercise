
/*3.	Legendary Farming
You've beaten all the content and the last thing left to accomplish is own a legendary item. However, it's a tedious process and requires quite a bit of farming. 
Anyway, you are not too pretentious - any legendary will do. The possible items are:
•	Shadowmourne - requires 250 Shards
•	Valanyr - requires 250 Fragments
•	Dragonwrath - requires 250 Motes
Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as 
"2 motes 3 ores 15 stones". Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes, ordered by quantity in descending order, then by name in ascending order, each on a new line. Finally, print the collected junk items, in alphabetical order.
Input
•	Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
Output
•	On the first line, print the obtained item in format {Legendary item} obtained!
•	On the next three lines, print the remaining key materials in descending order by quantity
o	If two key materials have the same quantity, print them in alphabetical order
•	On the final several lines, print the junk items in alphabetical order
o	All materials are printed in format {material}: {quantity}
o	All output should be lowercase, except the first letter of the legendary
Examples
Input	Output
3 Motes 5 stones 5 Shards
6 leathers 255 fragments 7 Shards	Valanyr obtained!
fragments: 5
shards: 5
motes: 3
leathers: 6
stones: 5
123 silver 6 shards 8 shards 5 motes
9 fangs 75 motes 103 MOTES 8 Shards
86 Motes 7 stones 19 silver	Dragonwrath obtained!
shards: 22
motes: 19
fragments: 0
fangs: 9
silver: 123

 * */
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Scanner input = new Scanner(System.in);
		 
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();
 
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        int lastNumber = 0;
        String winner = " ";
        
        while (winner.equals(" ")){
        	
            String[] data = input.nextLine().toLowerCase().split("\\s+");
 //ясно
            for(int a = 0; a < data.length; a++){
                if(a % 2 != 0){
                	
                    if(data[a].equalsIgnoreCase("shards") || data[a].equalsIgnoreCase("fragments") || data[a].equalsIgnoreCase("motes")){
                        lastNumber = keyMaterials.get(data[a]);
                        keyMaterials.put(data[a], lastNumber + Integer.parseInt(data[a - 1]));
 
                        if(winner.equalsIgnoreCase(" ")){
                            winner = determinesWinner(keyMaterials, winner, data[a]);
                            if(!winner.equals(" ")){
                                recalculatesWinnerMaterial(keyMaterials, data[a]);
                                break;
                            }
                        }
                    }
                    else{
                        junkMaterials.putIfAbsent(data[a], 0);
                        lastNumber = junkMaterials.get(data[a]);
                        junkMaterials.put(data[a], lastNumber + Integer.parseInt(data[a - 1]));
                    }
                }
            }
 
        }
 
        System.out.println(winner + " obtained!");      
        keyMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));
 
      
        junkMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));
        
    }
 
    public static String determinesWinner(TreeMap<String, Integer> junkMaterials, String winner, String key){
        if(junkMaterials.get(key) >= 250){
            switch (key){
                case "shards": winner = "Shadowmourne"; break;
                case "fragments": winner = "Valanyr"; break;
                case "motes": winner = "Dragonwrath"; break;
                default: break;
            }
        }
        return winner;
    }
 
    public static void recalculatesWinnerMaterial(TreeMap<String, Integer> keyMaterials, String key){
        int newValue = keyMaterials.get(key) - 250;
        keyMaterials.put(key, newValue);
    }
}