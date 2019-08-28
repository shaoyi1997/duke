import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {

    @Test
    void testDescriptionGetter() {
        assertEquals("Test | 12/12/2000 0800", new Deadline("Test", "12/12/2000 0800").getDescription());
    }

    @Test
    void testStringConversion() {
        assertEquals("[D][\u2718] Test (by: 12/12/2000 0800)",
                new Deadline("Test", "12/12/2000 0800").toString());
    }
}