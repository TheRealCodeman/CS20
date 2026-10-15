package SkillBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class hurricane_display {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			// Create an ArrayList object
			ArrayList<String> HURRICANE_SCALE = new ArrayList<>(
					Arrays.asList("Category 1: 74-95 mph or 64-82 kt or 119-153 km/hr",
							"Category 2: 96-110 mph or 83-95 kt or 154-177 km/hr",
							"Category 3: 111-130 mph or 96-113 kt or 178-209 km/hr",
							"Category 4: 131-155 mph or 114-135 kt or 210-249 km/hr",
							"Category 5: greater than 155 mph or 135 kt or 249 km/hr"));

			// Prompt:
			System.out.println(
					"Enter any index number in hurricane category. (E.g., 1 for Hurricane 1, 2 for Hurricane 2, etc...)");

			// Category input:
			int hurricaneCategoryInput = -1;

			while (hurricaneCategoryInput < 1 || hurricaneCategoryInput > 5) {
				try {
					System.out.println("Enter a hurricane category (numbers 1-5): ");
					hurricaneCategoryInput = scanner.nextInt();

					if (hurricaneCategoryInput < 1 || hurricaneCategoryInput > 5) {
						System.out.println("You must enter a valid category between 1 and 5. Try again.");
					}
				} catch (Exception e) {
					System.out.println("Error was found stating: " + e);
					scanner.next(); // Clear invalid input
				}
			}

			System.out.println("You picked:\n" + HURRICANE_SCALE.get(hurricaneCategoryInput - 1));
		}
	}
}