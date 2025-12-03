package software.ulpgc.adventofcode;

import java.util.ArrayList;

public class Dial {
    private final ArrayList<String> movements;
    private int estado;
    private int zeros;

    public Dial(ArrayList<String> movements) {
        estado = 50;
        this.movements = movements;
        zeros = 0;
    }

    public int calculateState() {
        movements.forEach(this::sum);
        return estado;
    }

    public int getZeros() {
        calculateState();
        return zeros;
    }

    private void sum(String movement) {
        estado += getValue(movement);
        this.estado = (estado % 100 + 100) % 100;
        checkZeros();
    }

    private int getValue(String movement) {
        return (characterSeparation(movement) == 'L')
                ? -1 * numberSeparation(movement)
                : numberSeparation(movement);
    }

    private char characterSeparation(String movement) {
        return movement.charAt(0);
    }

    private int numberSeparation(String movement) {
        return Integer.parseInt(movement.substring(1));
    }

    private void checkZeros() {
        if (estado == 0) zeros++;
    }
}
