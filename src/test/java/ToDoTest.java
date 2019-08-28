import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    @Test
    void testStringConversion() {
        assertEquals("[T][\u2718] Test", (new ToDo("Test")).toString());
    }
}