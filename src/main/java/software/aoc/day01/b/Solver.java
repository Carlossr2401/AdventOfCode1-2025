package software.aoc.day01.b;

import java.io.IOException;
import java.util.List;

public class Solver {

    private final InstructionReader reader;

    public Solver(InstructionReader reader) {
        this.reader = reader;
    }

    public int solve() throws IOException {
        List<String> instructions = reader.readAllInstructions();
        Dial dial = new Dial(instructions);
        return dial.getZeros();
    }
}
