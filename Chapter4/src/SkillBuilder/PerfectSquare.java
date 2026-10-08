package SkillBuilder;

import java.util.Scanner;

public class PerfectSquare {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int number = input.nextInt();

		int squareRoot = (int) Math.sqrt(number);

		if (squareRoot * squareRoot == number) {
			System.out.println(number + " is a perfect square.");
		} else {
			System.out.println(number + " is not a perfect square.");
		}

		input.close();
	}
}
