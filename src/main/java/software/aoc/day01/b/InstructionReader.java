package software.aoc.day01.b;

import java.io.IOException;
import java.util.List;

public interface InstructionReader {
    List<String> readAllInstructions() throws IOException;
}
