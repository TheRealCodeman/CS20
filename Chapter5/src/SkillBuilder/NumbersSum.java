package SkillBuilder;

import java.util.Scanner;

public class NumbersSum {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		// Prompt the user for a number
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		int sum = 0;

		// Display numbers from 1 to the entered number and calculate the sum
		System.out.println("Numbers:");
		for (int i = 1; i <= number; i++) {
			System.out.println(i);
			sum += i;
		}

		// Display the sum below the numbers
		System.out.println("Sum: " + sum);

		scanner.close();

	}

}
