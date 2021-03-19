
/*1.	Count Chars in a String
Write a program, which counts all characters in a string except space (' ').
Print all occurrences in the following format:
{char} -> {occurrences}
Examples
Input	Output
text	t -> 2
e -> 1
x -> 1
text text text
	t -> 6
e -> 3
x -> 3
 * */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		String words = scanner.nextLine();

		Map<Character, Integer> numberString= new LinkedHashMap<>();
		
		for (int i = 0; i <= words.length()-1; i++) {
			char alphabet = words.charAt(i);
			
			if (alphabet == ' ') {
				continue;
			}
			if (!numberString.containsKey(alphabet)) {
				numberString.put(alphabet, 1);
			} else {
				numberString.put(alphabet, numberString.get(alphabet) + 1);
			}
		}
		for (Map.Entry<Character, Integer>entry: numberString.entrySet()) {
			System.out.println( entry.getKey()+" -> "+entry.getValue());
		}
	}
}
