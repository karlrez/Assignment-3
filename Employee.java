
/***************************************************************************
* Karl Rezansoff
* CST8110_310 
* Assignment 3: Classes and Control Structures 
* Purpose: This Employee class will take user input for employees, make calculations and print out results to user.
* Updated 07/21/2019
*
****************************************************************************/

import java.util.Scanner;

public class Employee {
	private long empNumber;
	private String firstName, lastName, fullName="";
	private double baseSalary, bonusPercent, incentivesTotal, deduction, netIncome;
	private int numIncentives;
	private static int displayTitleLoop = 1, displayTitleCount = 1, displayInfoLoop = 1; // static so all objects share
																							// the same value for this
																							// variable
	private boolean loop; // this variable will be used in my loops in the readEmployee details method

	Scanner input = new Scanner(System.in);

	// default constructor sets name to "Not Set"
	public Employee() {
		firstName = "Not";
		lastName = "Set";

		displayTitleCount++; // increments by one for each employee
								// later used when title is printed out to user

	}

	// parameterized constructor
	public Employee(long empNumber, String firstName, String lastName, double baseSalary, double bonusPercent,
			double deduction) {
		this.empNumber = empNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.baseSalary = baseSalary;
		this.bonusPercent = bonusPercent;
		this.deduction = deduction;
	}

	// takes in user input for employee details
	public void readEmployeeDetails() {
		displayTitle(); // calling display title method to print a title to user

		System.out.print("Enter Employee Number: ");
		// below will loop if input is not Long variable type
		loop = true;
		while (loop) {
			if (input.hasNextLong()) {// checks if input is Long
				empNumber = input.nextLong();// empNumber is initialized to input value
				loop = false;
			} else {
				System.out.print("Please re-enter employee number without letters: ");
				input.nextLine();// this pauses loop until user inputs again
			}
		}
		System.out.print("Enter First Name: ");
		firstName = input.next();
		System.out.print("Enter Last Name: ");
		lastName = input.next();

		System.out.print("Enter Base Salary: ");
		loop = true;
		while (loop) {
			if (input.hasNextDouble()) {
				baseSalary = input.nextDouble();
				if (baseSalary >= 0) {
					loop = false;
				} else {
					System.out.print("Base Salary cannot be a negative number, please re-enter: ");
					input.next();
				}
			} else {
				System.out.print("Base salary cannot include letters, please re-enter: ");
				input.next();
			}
		}
		// this loop will first check if input is a double variable type and then will
		// check if bonusPercent is between 0-1 before ending
		System.out.print("Enter Bonus Percent: ");
		loop = true;
		while (loop) {
			if (input.hasNextDouble()) {
				bonusPercent = input.nextDouble();

				if (bonusPercent >= 0 && bonusPercent <= 1) {
					loop = false;
				} else {
					System.out.print("Bonus percent should be within 0-1, please re-enter: ");
					input.next();
				}

			} else {
				System.out.print("Bonus percent should be within 0-1, please re-enter: ");
				input.next();
			}
		}

		System.out.print("Enter number of incentives: ");
		loop = true;
		while (loop) {
			if (input.hasNextInt()) {
				numIncentives = input.nextInt();
				if (numIncentives >= 0) {
					loop = false;
				} else {
					System.out.print("Number of incentives should be greater than or equal to 0: ");
					input.next();
				}
			} else {
				System.out.print("Number of incentives should be greater than or equal to 0: ");
				input.next();
			}
		}
		// if incentives is greater than zero will call numIncentives to take user input
		if (numIncentives > 0) {
			readIncentives();
		}

		System.out.print("Enter Deductions: ");
		loop = true;
		while (true) {
			if (input.hasNextDouble()) {
				deduction = input.nextDouble();
				break; // loop=false did not stop the loop for some reason
			} else {
				System.out.print("Do not input letters, please enter zero for no deductions: ");
				input.next();
			}
		}
	}

	// this method will loop for each incentive
	// and a while loop is used to check if input is between 1-1000
	private void readIncentives() {
		// incentiveAmount is the amount input from user, resets to zero after each loop
		double incentiveAmount = 0;

		for (int i = 1; i <= numIncentives; i++) {
			loop = true; // when loop is true while loop below will run
			incentivesTotal += incentiveAmount;
			// this loop will loop until input can be parsed to a double and is between
			// 1-10000
			System.out.printf("Enter amount of incentive %d: ", i);
			while (loop) {

				if (input.hasNextDouble()) {
					incentiveAmount = input.nextDouble();
					if (incentiveAmount >= 1 && incentiveAmount <= 10000) {
						loop = false;
					} else {
						System.out.print("Incentive amount should be within 1-10000, please re-enter: ");
						input.next();
					}
				} else {
					System.out.print("Incentive amount should be within 1-10000, please re-enter: ");
					input.next();
				}
			}
		}
	}

	public void calculateNetIncome() {
		netIncome = baseSalary * (1 + bonusPercent) + incentivesTotal - deduction;
	}

	public void displayTitle() {
		for (; displayTitleLoop > 0; displayTitleLoop--) {
			System.out.println("PAYROLL CALCULATOR\n==================");
		}
		System.out.println("\nEnter details of Employee " + displayTitleCount);
	}

	public void displayInfo() {
		// only want title to display once so it will loop through once
		for (; displayInfoLoop > 0; displayInfoLoop--) {// will loop once so title only prints once
			System.out.println(
					"\n\nEmployee Number     |          Name        | Base Salary | Bonus Percent | Number of Incentives | Total Incentive Amount | Deduction | Net Income |\n"
							+ "---------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		fullName=fullName.concat(firstName).concat(" ").concat(lastName);
		System.out.printf("%19d | %20s |: %10.2f | %13.2f | %20d | %22.2f | %9.2f | %10.2f |\n", empNumber,
				fullName, baseSalary, bonusPercent, numIncentives, incentivesTotal, deduction, netIncome);
	}
	}

