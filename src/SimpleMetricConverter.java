import java.util.Scanner;

public class SimpleMetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        
        System.out.println("Welcome to the Metric Converter!");
        System.out.println("Enter your query in the format: '<value> <from_unit> to <to_unit>'.");
        System.out.println("Example: '1 kg to lb'");
        System.out.println("Type 'exit' to quit the program.");

        while (true) {
            System.out.print("Enter your conversion query: ");
            input = scanner.nextLine().toLowerCase();

            // Check if the user wants to exit
            if (input.equals("exit")) {
                System.out.println("Thank you for using the Metric Converter. Goodbye!");
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length != 4 || !tokens[2].equals("to")) {
                System.out.println("Invalid format. Please use: '<value> <from_unit> to <to_unit>'.");
                continue;
            }

            try {
                double value = Double.parseDouble(tokens[0]);
                String fromUnit = tokens[1];
                String toUnit = tokens[3];
                double result = convert(value, fromUnit, toUnit);

                if (result == -1) {
                    System.out.println("Conversion not supported. Please try again.");
                } else {
                    System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid numeric value.");
            }
        }
        scanner.close();
    }

    public static double convert(double value, String fromUnit, String toUnit) {
        if (fromUnit.equals("kg") && toUnit.equals("lb")) {
            return value * 2.20462;
        } else if (fromUnit.equals("g") && toUnit.equals("oz")) {
            return value * 0.035274;
        } else if (fromUnit.equals("km") && toUnit.equals("mile")) {
            return value * 0.621371;
        } else if (fromUnit.equals("mm") && toUnit.equals("inch")) {
            return value * 0.0393701;
        } else {
            return -1; 
        }
    }
}