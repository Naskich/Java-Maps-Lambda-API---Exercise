
/*10.	*SoftUni Exam Results
Judge statistics on the last Programing Fundamentals exam was not working correctly,
 so you have the task to take all the submissions and analyze them properly.
  You should collect all the submission and print the final results and statistics
   about each language that the participants submitted their solutions in.
You will be receiving lines in the following format: "{username}-{language}-{points}"
 until you receive "exam finished". You should store each username and his submissions and points. 
You can receive a command to ban a user for cheating in the following format:
 "{username}-banned". In that case, you should remove the user from the contest, 
 but preserve his submissions in the total count of submissions for each language.
After receiving "exam finished", print each of the participants, ordered descending 
by their max points, then by username, in the following format:
Results:
{username} | {points}
?
After that print each language, used in the exam, ordered descending by
 total submission count and then by language name, in the following format:
Submissions:
{language} - {submissionsCount}
?
Input / Constraints
Until you receive "exam finished", you will be receiving participant submissions
 in the following format: "{username}-{language}-{points}"
You can receive a ban command -> "{username}-banned"
The points of the participant will always be a valid integer in the range [0-100]
Output
?	Print the exam results for each participant, ordered descending by max points and
 then by username, in the following format:
Results:
{username} | {points}
?
?	After that print each language, ordered descending by total submissions and then by language name, in the following format:
Submissions:
{language} - {submissionsCount}
?
?	Allowed working time/memory: 100ms/16MB
Examples
Input	Output	Comment
Pesho-Java-84
Gosho-C#-70
Gosho-C#-84
Kiro-C#-94
exam finished	Results:
Kiro | 94
Gosho | 84
Pesho | 84
Submissions:
C# - 3
Java - 1	We order the participant descending by max points and then by name, printing 
only the username and the max points.
After that we print each language along with the count of submissions, ordered descending
 by submissions count, and then by language name.
Pesho-Java-91
Gosho-C#-84
Kiro-Java-90
Kiro-C#-50
Kiro-banned
exam finished	Results:
Pesho | 91
Gosho | 84
Submissions:
C# - 2
Java - 2	Kiro is banned so he is removed from the contest, but his submissions are
 still preserved in the languages submissions count. 
So although there are only 2 participants in the results, there are 4 submissions in total.
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SoftUniExamResult {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        Map<String, Integer> nameStudentsPoint =  new HashMap<>();
	        Map<String, Integer> nameLanguagePoint =  new HashMap<>();
	        String command = scanner.nextLine();
	        while (!command.equals("exam finished")){
	                String [] arrCommand = command.split("-");
	                String nameStudents  = arrCommand [0];
	                if (arrCommand.length==3){
	                    String programLanguage = arrCommand [1];
	                    int points =Integer.parseInt(arrCommand [2]);
	                    if (!nameStudentsPoint.containsKey(nameStudents)){
	                        nameStudentsPoint.put(nameStudents, points);
	                    } else {
	                        int currentPoints = nameStudentsPoint.get(nameStudents);
	                        if (points>currentPoints){
	                            nameStudentsPoint.put(nameStudents, points);
	                        }
	                    }
	                    if (!nameLanguagePoint.containsKey(programLanguage)){
	                        nameLanguagePoint.put(programLanguage,1);
	                    } else {
	                        nameLanguagePoint.put(programLanguage, nameLanguagePoint.get(programLanguage)+1);
	                    }
	                } else {
	                    nameStudentsPoint.remove(nameStudents);
	                }
	            command = scanner.nextLine();
	        }
	        printResult(nameStudentsPoint);
	        printSubmissions(nameLanguagePoint);
	    }
	    public static void printResult(Map<String, Integer> nameStudentsPoint){
	        System.out.println("Results:");
	        nameStudentsPoint.entrySet().stream()
	                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed()
	                        .thenComparing(Map.Entry.comparingByKey()))
	                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
	    }
	    public static void printSubmissions(Map<String, Integer> nameLanguagePoint){
	        System.out.println("Submissions:");
	        nameLanguagePoint.entrySet().stream()
	                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed()
	                        .thenComparing(Map.Entry.comparingByKey()))
	                .forEach(e -> System.out.println(e.getKey() + " - " +e.getValue()));
	    }
	}

