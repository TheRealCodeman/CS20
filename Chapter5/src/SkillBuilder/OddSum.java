package SkillBuilder;

import java.util.Scanner;

public class OddSum {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		// Prompt the user for a number
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		int sum = 0;

		// Sum the odd numbers from 1 to the entered number
		for (int i = 1; i <= number; i++) {
			if (i % 2 != 0) {
				sum += i;
			}
		}

		// Display the sum of odd numbers
		System.out.println("Sum of odd numbers: " + sum);

		scanner.close();

	}

}
