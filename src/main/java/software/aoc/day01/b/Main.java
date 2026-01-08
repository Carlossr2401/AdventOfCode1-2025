package software.aoc.day01.b;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        InstructionReader reader = new FileInstructionReader("src/main/resources/dialInput");
        Solver solver = new Solver(reader);
        System.out.println(solver.solve());
    }
}
