import java.util.Scanner;

public class Employee {
	private long empNumber;
	private String firstName, lastName;
	private double baseSalary, bonusPercent, incentivesTotal, deduction, netIncome;
	private int numIncentives;

	public Employee() {
		firstName = "Not";
		lastName = "Set";

	}

	public Employee(long empNumber, String firstName, String lastName, double baseSalary, double bonusPercent,
			double deduction) {
		this.empNumber = empNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.baseSalary = baseSalary;
		this.bonusPercent = bonusPercent;
		this.deduction = deduction;
	}

	public void readEmployeeDetails() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Employee Number: ");
		for(int i=0;i<1;) {
		try {
			empNumber = input.nextLong();
		}
		catch(Exception e) {
			System.out.println("Please re-enter employee number");
		}
		if (input.hasNextLong()) {
			i++;
		}
		}
		
		
		
		System.out.print("Enter First Name: ");
		firstName = input.next();
		System.out.print("Enter Last Name: ");
		lastName = input.next();
		System.out.print("Enter Base Salary: ");
		baseSalary = input.nextDouble();
		System.out.print("Enter Bonus Percent: ");
		bonusPercent = input.nextDouble();

		/*System.out.print("Enter number of incentives: ");
		boolean loop1 = true;

		do {
			System.out.print("Enter number of incentives: ");
			if (input.hasNextInt()) {
				numIncentives = input.nextInt();
				loop1 = false;
			} else {
				System.out.println("Number of incentives should be greater than 0");
			}
		} while (loop1 == true);

		/*
		 * if (numIncentives<0) {
		 * System.out.println("Number of incentives should be greater than 0"); } if
		 * (numIncentives>0) { readIncentives(); loop1=false; } else { loop1=false;
		 */

		System.out.print("Enter Deductions: ");
		deduction = input.nextDouble();

	}

	private void readIncentives() {
		// Incentive amount should be within 1-10
		System.out.println("woooo");
	}

	@Override
	public String toString() {
		return "Employee [empNumber=" + empNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", baseSalary=" + baseSalary + ", bonusPercent=" + bonusPercent + ", incentivesTotal="
				+ incentivesTotal + ", deduction=" + deduction + ", netIncome=" + netIncome + ", numIncentives="
				+ numIncentives + "]";
	}

}
