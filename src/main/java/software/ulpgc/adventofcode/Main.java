package software.ulpgc.adventofcode;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        FileInstructionReader file = new FileInstructionReader("src/main/resources/dialInput");
        Dial dial = new Dial(file.readAllInstructions());
        System.out.println(dial.getZeros());
    }
}
