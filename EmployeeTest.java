 /***************************************************************************
 * Karl Rezansoff
 * CST8110_310 
 * Assignment 3: Classes and Control Structures 
 * Purpose: This will create Employee class objects and display to user.
 * Updated 07/21/2019
 *
 ****************************************************************************/

public class EmployeeTest {
	public static void main(String[] args) {
		
		//creating objects of employee class and
		//calculating income 
		Employee emp1 = new Employee();
		emp1.calculateNetIncome();
		
		Employee emp2 = new Employee(1010,"John","Doe",65000,.04,8000);
		emp2.calculateNetIncome();
		
		Employee emp3 = new Employee();
		emp3.readEmployeeDetails();
		emp3.calculateNetIncome();
		
		Employee emp4 = new Employee();
		emp4.readEmployeeDetails();
		emp4.calculateNetIncome();
		
		Employee emp5 = new Employee();
		emp3.readEmployeeDetails();
		emp3.calculateNetIncome();
		
		//displaying info for all objects 
		emp1.displayInfo();
		emp2.displayInfo();
		emp3.displayInfo();
		emp4.displayInfo();
		emp5.displayInfo();
		
		
		
	}
	
	
}
