package SkillBuilder;

import java.util.Scanner;

public class TempConverter {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner userinput = new Scanner(System.in);

		System.out.print("Enter any number representing degrees farenheit (°F): ");
		double F = userinput.nextDouble();

		// FIXED: Declared C, changed 5/9 to 5.0/9.0, and replaced {} with ()
		double C = (5.0 / 9.0) * (F - 32);

		System.out.println("Temperature in Celsius (°C) is: " + C);

		// Close scanner resource
		userinput.close();
	}
}


/*

Enter any number representing degrees farenheit (°F): 789
Temperature in Celsius (°C) is: 420.5555555555556

*/