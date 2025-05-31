import java.util.Scanner;

public class InputValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean isValid;

        do {
            isValid = true; // Assume valid for this attempt

            System.out.print("Enter a number between 1 and 10: ");

            try { // <--- Start of the try block
                userInput = scanner.nextInt(); // This might cause an InputMismatchException

                // If nextInt() succeeds, then check the range
                if (userInput < 1 || userInput > 10) {
                    System.out.println("Invalid input. Please try again. The number must be between 1 and 10.");
                    isValid = false; // Set to false if out of range
                }

            } catch (java.util.InputMismatchException e) { // <--- If nextInt() failed, catch the error
                System.out.println("Invalid input! Please enter a whole number (e.g., 5).");
                isValid = false; // Definitely not valid if it's not even a number
                scanner.next(); // IMPORTANT: Consume the invalid input from the scanner
                // without this, it would loop infinitely on the bad input
            }

        } while (!isValid);

        System.out.println("Thank you! You entered a valid number: " + userInput);
        scanner.close();
    }
}