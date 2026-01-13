// Hello :)

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) throws IOException {

        // Main entry point of the password generator application.
        // For personal projects: IOException is thrown directly for simplicity.
        // In production, we would handle exceptions more gracefully :)
        final Scanner scanner = new Scanner(System.in);
        String input;

        // Display the menu and instructions to the user
        ConsoleUI.showMenu(scanner);
        do {
            // Ask the user how many words the password should have
            int numWords = ConsoleUI.readUserInput(scanner);
            // Load Diceware map from the file (diceware.txt)
            Map<String, String> dicewareMap = DicewareRepository.load("diceware.txt");
            // Generate the password using the Diceware map and generatePassword prints dice rolls and words for learning purposes.
            String password = Password.generatePassword(numWords, dicewareMap);
            ConsoleUI.sleep(700);
            // Print the password and instructions
            System.out.println("\nYour Password:\n" + ConsoleUI.bar + "\n" + password + "\n" + ConsoleUI.bar);
            System.out.println("Now you need create a short story with each word to memorize!\n");

            // Ask if the user wants to generate another password
            System.out.print("Do you want to generate another password? (y/n): ");
            input = scanner.nextLine().trim().toLowerCase();

            // Validate input
            while (!input.equals("y") && !input.equals("n")) {
                System.out.print("Invalid input. Please enter 'y' or 'n': ");
                input = scanner.nextLine().trim().toLowerCase();
            }
        } while (input.equals("y"));
        System.out.println("Goodbye!!! Thank you for using the PasswordGenerator by Rayssa Reis <3");
        scanner.close();
    }
}
