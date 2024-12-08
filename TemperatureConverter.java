import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu options
        System.out.println("Temperature Converter");
        System.out.println("Choose an option:");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");

        // Get user choice
        int choice = getUserChoice(scanner);

        // Get temperature input based on user choice
        double temperature = getTemperatureInput(scanner, choice);

        // Perform the conversion based on user's choice
        if (choice == 1) {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f Celsius is %.2f Fahrenheit.%n", temperature, fahrenheit);
        } else if (choice == 2) {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f Fahrenheit is %.2f Celsius.%n", temperature, celsius);
        }

        // Close the scanner
        scanner.close();
    }

    // Method to get a valid user choice
    private static int getUserChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                System.out.print("Enter your choice (1 or 2): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Method to get a valid temperature input
    private static double getTemperatureInput(Scanner scanner, int choice) {
        double temperature;
        while (true) {
            try {
                System.out.print("Enter the temperature: ");
                temperature = Double.parseDouble(scanner.nextLine());

                // Validate for physically impossible temperatures
                if (choice == 1 && temperature < -273.15) { // Celsius to Fahrenheit
                    System.out.println("Invalid input: Temperatures cannot be below absolute zero (-273.15°C).");
                } else if (choice == 2 && temperature < -459.67) { // Fahrenheit to Celsius
                    System.out.println("Invalid input: Temperatures cannot be below absolute zero (-459.67°F).");
                } else {
                    return temperature;  // Valid input, return the temperature
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Method to convert Celsius to Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}