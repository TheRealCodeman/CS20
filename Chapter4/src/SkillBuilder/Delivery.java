package SkillBuilder;

import java.util.Scanner;

public class Delivery {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				// Prompt the user for package dimensions
				System.out.print("Enter the length of the package: ");
				double length = scanner.nextDouble();

				System.out.print("Enter the width of the package: ");
				double width = scanner.nextDouble();

				System.out.print("Enter the height of the package: ");
				double height = scanner.nextDouble();

				// Check if any single dimension exceeds 10
				if (length > 10 || width > 10 || height > 10) {
					System.out.println("Rejected");
				} else {
					System.out.println("Accepted");
					break;
				}

			}

			catch (Exception e) {

				System.out.println("There was an error stating: " + e + "\nTry again.\n");
				scanner.next();
			}

		}

		scanner.close();
	}
}
