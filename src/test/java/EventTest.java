import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testDescriptionGetter() {
        assertEquals("Test | 12/12/2000 0800", new Event("Test", "12/12/2000 0800").getDescription());
    }

    @Test
    void testStringConversion() {
        assertEquals("[E][\u2718] Test (at: 12/12/2000 0800)",
                new Event("Test", "12/12/2000 0800").toString());
    }
}