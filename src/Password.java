import java.security.SecureRandom;
import java.util.Map;


public class Password {

    // SecureRandom is used for cryptographically strong random numbers
    // Suitable for password generation instead of Random
    private static SecureRandom random = new SecureRandom();


    /**
     * Generates a password composed of `numWords` words from the provided Diceware map
     * ^-^
     * Note: This method currently prints dice rolls and resulting words for learning purposes
     * In production, you would separate logic from UI and avoid printing inside this method
     */
    public static String generatePassword(int numWords, Map<String, String> dicewareMap) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numWords; i++) {
            // Roll 5 and look up the word in the Diceware map
            String diceRoll = rollDiceKey();
            String word = dicewareMap.get(diceRoll);

            // Print rolled dice and the word just for educational purposes
            ConsoleUI.sleep(1000);
            System.out.println("We rolled 5 dice:" + diceRoll);
            if (word == null) {
                throw new IllegalStateException("Dice key not found in Diceware map: " + diceRoll);
            }

            ConsoleUI.sleep(500);

            System.out.println("The word is: " + word);

            // Append the word to the password
            password.append(word);

            // Add a space between words, except after the last one
            if (i < numWords - 1) {
                password.append(" ");
            }
        }
        return password.toString();
    }

    /**
     * Rolls 5 dice and returns a string representing the Diceware key
     * Each digit represents the result of one six-sided dice (1-6) :)
     */
    private static String rollDiceKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int dice = random.nextInt(6) + 1;
            key.append(dice);
        }
        return key.toString();
    }

}
