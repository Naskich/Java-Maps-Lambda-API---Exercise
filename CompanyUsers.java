

/*8.	Company Users
Write a program which keeps information about companies and their employees.
You will receive company name and employee's id, until you receive the command "End". Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.
When you finish reading data, order the companies by the name in ascending order.
Print the company name and each employee's id in the following format:
{companyName}
-- {id1}
-- {id2}
-- {idN}
Input / Constraints
•	Until you receive "End", the input come in the format: "{companyName} -> {employeeId}"
•	The input always will be valid
Examples
Input	Output
SoftUni -> AA12345
SoftUni -> BB12345
Microsoft -> CC12345
HP -> BB12345
End	HP
-- BB12345
Microsoft
-- CC12345
SoftUni
-- AA12345
-- BB12345
SoftUni -> AA12345
SoftUni -> CC12344
Lenovo -> XX23456
SoftUni -> AA12345
Movement -> DD11111
End	Lenovo
-- XX23456
Movement
-- DD11111
SoftUni
-- AA12345
-- CC12344

 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class CompanyUsers {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	TreeMap<String, ArrayList<String>>idCompanyName = new TreeMap<>();
	String command = scanner.nextLine();
	while (!command.equals("End")) {
		String[] tokens = command.split(" -> ");
		String company = tokens[0];
		String id = tokens[1];
		if (!idCompanyName.containsKey(company)) {
			idCompanyName.put(company, new ArrayList<String>());
		}
		if (idCompanyName.containsKey(company) && !idCompanyName.get(company).contains(id)) {
			idCompanyName.get(company).add(id);
		}
		command = scanner.nextLine();
    }
    printCompanyName(idCompanyName);
	}
	public static void  printCompanyName(TreeMap<String, ArrayList<String>>idCompanyName){
	for (var entry : idCompanyName.entrySet()) {
		System.out.println(entry.getKey());
		for (String ids : entry.getValue()) {
		System.out.println("-- "+ ids);
		}
	}
	}
}