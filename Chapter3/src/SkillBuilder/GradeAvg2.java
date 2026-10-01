package SkillBuilder; // <--- ADD THIS LINE HERE

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates the average of 5 user-provided grades. Includes input validation
 * to prevent crashes from non-numeric input and checks to ensure grades fall
 * within a realistic 0-100 range.
 */
public class GradeAvg2 {
	private static final int TOTAL_GRADES = 5;

	public static void main(String[] args) {
		double sum = 0;
		int count = 1;

		// Use try-with-resources to automatically close the Scanner
		try (Scanner scanner = new Scanner(System.in)) {
			while (count <= TOTAL_GRADES) {
				try {
					System.out.print("Enter Grade #" + count + ": ");
					int gradeInput = scanner.nextInt();

					// Validate that the grade falls within a logical school boundary
					if (gradeInput < 0 || gradeInput > 100) {
						System.out.println("Invalid entry. Grades must be between 0 and 100.");
						continue; // Skip rest of loop to retry the current grade number
					}

					System.out.println("Received input: " + gradeInput);
					sum += gradeInput;
					count++; // Only increment if input was successful and valid

				} catch (InputMismatchException e) {
					System.out.println("Error: Please enter a valid whole number integer.");
					scanner.next(); // Clear the bad token from the scanner buffer
				} catch (Exception e) {
					System.out.println("An unexpected error occurred: " + e.getMessage());
				}
			}

			double average = sum / TOTAL_GRADES;
			System.out.printf("%nYour average is: %.2f%n", average);
		}
	}
}

/*
 * 
 * An object drops 100 m above the ground. Input how many seconds the object
 * falls for between 0 and 4.5 : 5 Number must be between 0 and 4.5. Re-enter:
 * An object drops 100 m above the ground. Input how many seconds the object
 * falls for between 0 and 4.5 : -1 Number must be between 0 and 4.5. Re-enter:
 * An object drops 100 m above the ground. Input how many seconds the object
 * falls for between 0 and 4.5 : 4.647 Number must be between 0 and 4.5.
 * Re-enter: An object drops 100 m above the ground. Input how many seconds the
 * object falls for between 0 and 4.5 : 2.3453 After 2.3453 seconds, the
 * object's height from the ground will then be 73.047882759 m.
 * 
 */
