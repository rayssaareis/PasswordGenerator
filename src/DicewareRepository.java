import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DicewareRepository {

    /**
     * Loads a Diceware map from a text file (diceware.txt)
     * Each line in the file should contain a dice roll key followed by a word, separated by whitespace.
     * Example: "11111 apple" ...
     */
    public static Map<String, String> load(String filePath) throws IOException {
        Map<String, String> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // skip empty lines

                // Split line by whitespace to separate key and word (diceware.txt)
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    // Currently only uses the second token as the word
                    // In production, consider joining remaining parts if words contain spaces :)
                    map.put(parts[0], parts[1]);
                }
            }
        }

        return map;
    }
}
