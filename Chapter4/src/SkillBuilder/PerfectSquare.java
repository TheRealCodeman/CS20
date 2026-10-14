package SkillBuilder;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PerfectSquare {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			try {
				System.out.print("Enter an integer: ");
				int number = input.nextInt();

				int squareRoot = (int) Math.sqrt(number);

				if (squareRoot * squareRoot == number) {
					System.out.println(number + " is a perfect square.");
				} else {
					System.out.println(number + " is not a perfect square.");
				}

				break;
			}

			catch (InputMismatchException e) {

				System.out.println("No non-integer is accepted and this program");

				System.out.println("isn't designed to properly handle anything more than 9 digits.\n");
				input.nextLine();

			}
		}

		input.close();
	}
}
