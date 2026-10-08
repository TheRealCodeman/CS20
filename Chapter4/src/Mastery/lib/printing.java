/*

Program: Printing.java          Last Date of this Revision: October 5, 2026

Purpose: An application that reads the number of copies to print, finds the
 matching copy range and price per copy in a price list (Java map), and
 outputs the triggered key-value pair and the total cost of the order.

IPO:
 Input:   number of copies (whole number, 1 or more)
 Process: look up the copy range in a TreeMap of key-value pairs (first copy
          count in range -> price per copy), then multiply copies by price
 Output:  the triggered key-value pair (copy range and rate) and the total cost

Author: Christian
School: CHHS
Course: Computer Programming 20 - CSE2140 Second Language Programming 1

*/

package Mastery.lib;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap; // Ensure TreeMap is imported for PRICE_LIST usage

public class printing {

	// Price list attribute: key = first copy count in a range, value = price per
	// copy
	private static final TreeMap<Integer, Double> PRICE_LIST = new TreeMap<>();

	static {
		PRICE_LIST.put(1, 0.30); // 1 - 99 copies
		PRICE_LIST.put(100, 0.28); // 100 - 499 copies
		PRICE_LIST.put(500, 0.27); // 500 - 749 copies
		PRICE_LIST.put(750, 0.26); // 750 - 1000 copies
		PRICE_LIST.put(1001, 0.25); // over 1000 copies
	}

	public static void main(String[] args) {
		
		// Declare variable (int, because copies are always whole numbers)
		int copies = 0;

		// User-input debugging and automatically closes scanner when done (try-with-resources)
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				try {
					// User prompt
					System.out.print("Enter the number of copies to print (whole numbers only): ");
					copies = scanner.nextInt();

					// Verify number is within allowed range
					if (copies >= 1) {
						break;
					} else {
						System.out.println("Number of copies must be at least 1. Re-enter: ");
					}
				} catch (InputMismatchException e) {
					// Log input-error and clear the bad input from the Scanner buffer
					if (!scanner.hasNextInt() && !scanner.hasNextLong()) {
						
						System.out.println("Cannot use decimals or other symbols in place of a whole number or enter a quantity unrealistically feasible. Re-enter: ");
						}
					
					else {
						
						System.out.println("Do you think that amount is even available to the world? Re-enter: ");
						
					}
					
					scanner.nextLine();
				}
			}
		}

		// Find the key-value pair whose range contains the number of copies
		Map.Entry<Integer, Double> rate = PRICE_LIST.floorEntry(copies);

		// Final error-free result
		System.out.println("Price list entry triggered: " + rangeOf(rate.getKey()) + " copies = $"
				+ String.format("%.2f", rate.getValue()) + " per copy");
		System.out.printf("Total cost of %d copies: $%.2f%n", copies, copies * rate.getValue());


	}

	/*
	 * Function: rangeOf Pre-condition: key is a key in PRICE_LIST Post-condition:
	 * returns the copy range as text, e.g., "100-499" or "1001+"
	 */
	private static String rangeOf(int key) {
		Integer nextKey = PRICE_LIST.higherKey(key);
		return (nextKey == null) ? key + "+" : key + "-" + (nextKey - 1);
	}
}

/*
 * Screen Dump
 * 
 * Test Case 1: Successful output, lowest price range (50) Enter the number of
 * copies to print (whole numbers only): 50 Price list entry triggered: 1-99
 * copies = $0.30 per copy Total cost of 50 copies: $15.00
 * 
 * Test Case 2: Boundary held, last copy count of a range (499) Enter the number
 * of copies to print (whole numbers only): 499 Price list entry triggered:
 * 100-499 copies = $0.28 per copy Total cost of 499 copies: $139.72
 * 
 * Test Case 3: Boundary broken, first copy count of the next range (100) Enter
 * the number of copies to print (whole numbers only): 100 Price list entry
 * triggered: 100-499 copies = $0.28 per copy Total cost of 100 copies: $28.00
 * 
 * Test Case 4: Successful output, 750-1000 range (750) Enter the number of
 * copies to print (whole numbers only): 750 Price list entry triggered:
 * 750-1000 copies = $0.26 per copy Total cost of 750 copies: $195.00
 * 
 * Test Case 5: Successful output, highest range with no upper limit (1500)
 * Enter the number of copies to print (whole numbers only): 1500 Price list
 * entry triggered: 1001+ copies = $0.25 per copy Total cost of 1500 copies:
 * $375.00
 * 
 * Test Case 6: Illogical inputs (0, abc, 2.5), then valid input (500) Enter the
 * number of copies to print (whole numbers only): 0 Number of copies must be at
 * least 1. Re-enter: Enter the number of copies to print (whole numbers only):
 * abc Cannot use decimals or other symbols in place of a whole number.
 * Re-enter: Enter the number of copies to print (whole numbers only): 2.5
 * Cannot use decimals or other symbols in place of a whole number. Re-enter:
 * Enter the number of copies to print (whole numbers only): 500 Price list
 * entry triggered: 500-749 copies = $0.27 per copy Total cost of 500 copies:
 * $135.00
 * 
 */
