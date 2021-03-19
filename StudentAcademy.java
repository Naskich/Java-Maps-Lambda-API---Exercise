

/*7.	Student Academy
Write a program, which keeps information about students and their grades.
On the first line you will receive number n. After that you will receive n pair of rows.
 First you will receive the student's name, after that you will receive his grade. 
 Check if student already exists, and if not - add him. Keep track of all grades for each student.
When you finish reading data, keep students with average grade higher or equal to 4.50. 
Order filtered students by average grade in descending order.
Print the students and their average grade in format:
"{name} –> {averageGrade}"
Format the average grade to the 2nd decimal place.
Examples
Input	Output		Input	Output
5
John
5.5
John
4.5
Alice
6
Alice
3
George
5	John -> 5.00
George -> 5.00
Alice -> 4.50		5
Amanda
3.5
Amanda
4
Rob
5.5
Christian
5
Robert
6	Robert -> 6.00
Rob -> 5.50
Christian -> 5.00

 * */

import java.util.*;
public class StudentAcademy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int numberStudents =Integer.parseInt(scanner.nextLine());
        int numbers = 0;

        Map<String, List <Double>> nameStudents = new LinkedHashMap<>();

        while (numbers!=numberStudents) {
            String name = scanner.nextLine();
            double studentValue = Double.parseDouble(scanner.nextLine());
            
            if (!nameStudents.containsKey(name)) {
            	
                nameStudents.put(name, new ArrayList<>());
                nameStudents.get(name).add(studentValue);
                
            } else {             
                nameStudents.get(name).add(studentValue);
            	   }
            numbers++;
        }        
        Map<String, Double> midleSum = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> number : nameStudents.entrySet()) {
            double sum = number.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (sum >= 4.50) {
               midleSum.put(number.getKey(), sum);
            }
        }
        printSum(midleSum); 
    }  
	public static void printSum(Map<String, Double> midleSum){
		  midleSum.entrySet().stream()
	        .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
	        .forEach(grade -> {
	            System.out.println(String.format("%s -> %.2f", grade.getKey(), grade.getValue()));
	        });
	}
}