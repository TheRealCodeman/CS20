package Mastery;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ObjectHeight {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner scanner = new Scanner(System.in);

		// Declare variable
		double t;

		// User-input debugging
		while (true) {
			try {
				// User prompt
				System.out.print(
						"An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : ");
				t = scanner.nextDouble();

				// Verify number is within allowed range
				if (t >= 0 && t <= 4.5) {
					break;
				} else {
					System.out.println("Number must be between 0 and 4.5. Re-enter: ");
				}
			} catch (InputMismatchException e) {
				// Log input-error
				System.out.println("Cannot use other symbols in place of a number. Re-enter: ");
				scanner.nextLine();
			}
		}

		// Final error-free result
		System.out.println("After " + t + " seconds, the object's height from the ground will then be "
				+ (100 - 4.9 * Math.pow(t, 2)) + " m.");

		// Close scanner
		scanner.close();
	}
}

/*

An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 5
Number must be between 0 and 4.5. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : -1
Number must be between 0 and 4.5. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 4.647
Number must be between 0 and 4.5. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 2.3453
After 2.3453 seconds, the object's height from the ground will then be 73.047882759 m.

*/