package SkillBuilder;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates the average of 5 user-provided grades. Includes input validation
 * to prevent crashes from non-numeric input.
 */
public class GradeAvg {

	private static final int TOTAL_GRADES = 5;

	public static void main(String[] args) {
		double sum = 0;
		int count = 1;

		// Use try-with-resources to automatically close the Scanner
		try (Scanner scanner = new Scanner(System.in)) {

			while (true) {
				try {
					System.out.print("Enter Grade #" + count + ": ");
					int gradeInput = scanner.nextInt();

					System.out.println("Received input: " + gradeInput);
					sum += gradeInput;
					
					if (gradeInput < 0 || gradeInput > 100) {
						
						System.out.println("School grades do not go below 0 or above 100. Re-enter:");
					}
					
					else {
					
						count++; // Only increment if input was successful
					}
					
					if (count == TOTAL_GRADES) {
						
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println("Error: Please enter a valid whole number integer.");
					scanner.next(); // CRITICAL: Clear the bad token from the scanner buffer
				} catch (Exception e) {
					System.out.println("An unexpected error occurred: " + e.getMessage());
				}
			}

			double average = sum / TOTAL_GRADES;
			System.out.printf("\nYour average is: %.2f%n", average);
		}
	}
}

/* 

Enter Grade #1: -1
Received input: -1
School grades do not go below 0 or above 100. Re-enter:
Enter Grade #1: 101
Received input: 101
School grades do not go below 0 or above 100. Re-enter:
Enter Grade #1: 89
Received input: 89
Enter Grade #2: 88
Received input: 88
Enter Grade #3: 91
Received input: 91
Enter Grade #4: 96
Received input: 96

Your average is: 92.80
*/