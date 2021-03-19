
/*6.	Courses
Write a program, which keeps information about courses. Each course has a name and registered students.
You will receive course name and student name, until you receive the command "end". Check if such course already exists, and if not - add the course. Register the user into the course. When you do receive the command "end", print the courses with their names and total registered users, ordered by the count of registered users in descending order. For each contest print registered users ordered by name in ascending order.
Input
•	Until you receive "end", the input come in the format: "{courseName} : {studentName}"
•	The product data is always delimited by " : "
Output
•	Print information about each course, following the format: 
"{courseName}: {registeredStudents}"
•	Print information about each student, following the format:
"-- {studentName}"
Examples
Input	Output
Programming Fundamentals : John Smith
Programming Fundamentals : Linda Johnson
JS Core : Will Wilson
Java Advanced : Harrison White
end	Programming Fundamentals: 2
-- John Smith
-- Linda Johnson
JS Core: 1
-- Will Wilson
Java Advanced: 1
-- Harrison White
Algorithms : Jay Moore
Programming Basics : Martin Taylor
Python Fundamentals : John Anderson
Python Fundamentals : Andrew Robinson
Algorithms : Bob Jackson
Python Fundamentals : Clark Lewis
end	Python Fundamentals: 3
-- Andrew Robinson
-- Clark Lewis
-- John Anderson
Algorithms: 2
-- Bob Jackson
-- Jay Moore
Programming Basics: 1
-- Martin Taylor
 * */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Courses {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		 Map<String, List<String>> coursesLernt = new LinkedHashMap<>();
		 
		 String schoolSubjects = scanner.nextLine();
		 
		 while (!schoolSubjects.equals("end")) {
		
			 String courseName = schoolSubjects.split(" : ")[0];
			 String studentsName = schoolSubjects.split(" : ")[1];
			 
			 if (!coursesLernt.containsKey(courseName)) {
				 coursesLernt.put(courseName, new ArrayList<>());
			 	}
					coursesLernt.get(courseName).add(studentsName);
					 
			 schoolSubjects = scanner.nextLine();
		}
		 coursesLernt.entrySet().stream()
		 .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
		 .forEach(e -> {
			 System.out.println(e.getKey() + ": " + e.getValue().size());
			 e.getValue().stream()
			 .sorted(String :: compareTo)
			 .forEach(student -> System.out.println("-- "+student));
		 });
	}	 
}
