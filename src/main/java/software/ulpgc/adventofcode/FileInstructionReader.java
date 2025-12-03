package software.ulpgc.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public record FileInstructionReader(String filePath) {

    public ArrayList<String> readAllInstructions() throws IOException {
        ArrayList<String> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();

                if (!trimmedLine.isEmpty()) {
                    instructions.add(trimmedLine);
                }
            }
        }

        return instructions;
    }
}
