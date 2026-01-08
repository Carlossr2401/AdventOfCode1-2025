import org.junit.Test;
import software.aoc.day01.b.Dial;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestsB {

    private ArrayList<String> createMovements(String... moves) {
        return new ArrayList<>(List.of(moves));
    }

    @Test
    public void testPassThroughZero() {
        // En la Parte B, cuenta cada vez que pisa el 0 durante el movimiento.
        // 50 -> L51
        // Paso 50: llega al 0. (Cuenta 1)
        // Paso 51: llega al 99.
        ArrayList<String> movements = createMovements("L51");
        Dial dial = new Dial(movements);

        assertEquals(1, dial.getZeros());
    }

    @Test
    public void testMultiplePassesThroughZero() {
        // 50 -> R150
        // Paso 50: llega al 0. (Cuenta 1)
        // Paso 150: llega al 0 nuevamente. (Cuenta 2)
        ArrayList<String> movements = createMovements("R150");
        Dial dial = new Dial(movements);

        assertEquals(2, dial.getZeros());
    }

    @Test
    public void testNoZeroInteraction() {
        // 50 -> R10 llegamos a 60.
        // 60 -> L20 llegamos a 40.
        // Nunca cruza el 0.
        ArrayList<String> movements = createMovements("R10", "L20");
        Dial dial = new Dial(movements);

        assertEquals(0, dial.getZeros());
    }

    @Test
    public void testExactZeroLanding() {
        // 50 -> L50.
        // Termina en 0. Cuenta 1.
        ArrayList<String> movements = createMovements("L50");
        Dial dial = new Dial(movements);

        assertEquals(1, dial.getZeros());
    }
}
