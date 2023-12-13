
import java.util.Scanner;
import java.util.*;

public class Dates {

	private static String[] monthy = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			int day;
			String monthString;
			int year;
			String[] parts = input.split("[/-]");
			if (parts.length != 3) {
				System.out.println("Invalid enter the date in the format 'day/month/year'.");

			}
			
			if (input.startsWith("/") || input.startsWith("-")) {
			    System.out.println("Separator before the days.");
			}
			try {
				 day = Integer.parseInt(parts[0]);
				 monthString = parts[1];
				 year = Integer.parseInt(parts[2]);

				 date(day, monthString, year);
			} catch (NumberFormatException e) {
				System.out.println("Invalid enter the numeric values for day and year.");

			}
		}
		scanner.close();
	}

	public static boolean date(int day, String monthString, int year) {
		String monthName;
		int days;
		int years;
		int sd = Integer.parseInt(monthString);
		char[] charArray = { '-', '/' };

		if (day >= 0 && day <= 31) {
			if (day <= 9) {

				days = Integer.parseInt("0" + day);

			} else {
				days = day;
			}
			System.out.print(String.format("%02d", days) + " ");
		} else {
			System.out.println("Day is out of range");
			return false;
		}

		try {

			
			for (int i = 0; i < monthy.length; i++) {
				if (monthy[i].matches(monthString) || monthString.matches("[a-zA-Z]{3}")) {
					monthName = monthy[i];
					System.out.print(monthName);
					return true;
				}
			}

			if (sd >= 1 && sd <= 12) {
				monthName = monthy[sd - 1];
				System.out.print(monthName + " ");
			} else {
				System.out.println("Invalid date number. Please enter a number between 1 and 12.");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid month input. Please enter a valid number.");
			return false;
		}

		if (year > 49 && year < 100) {
			years = Integer.parseInt("19" + year);
			System.out.print(years);
		} else if (year < 50) {
			years = Integer.parseInt("20" + year);
			System.out.print(years);
		} else if (year > 1752 && year < 3001) {
			years = year;
			System.out.print(years);
		} else {
			System.out.println("Invalid year. Please enter a valid year.");
			return false;
		}

		if (charArray.length > 1 && (charArray[1] == monthString.charAt(monthString.length() - 1))) {
			System.out.println("Error: Separator after the year.");
			return false;
		}
		return true;
	}

}
