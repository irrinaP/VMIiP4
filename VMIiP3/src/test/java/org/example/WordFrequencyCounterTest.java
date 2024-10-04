package org.example;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFrequencyCounterTest {

    @Test
    public void testCountWordFrequencies() {
        String text = "Hello world! Hello everyone. This is a test. Hello world!";
        Map<String, Integer> frequencies = WordFrequencyCounter.countWordFrequencies(text);

        assertEquals(3, frequencies.get("hello"));
        assertEquals(2, frequencies.get("world"));
        assertEquals(1, frequencies.get("everyone"));
        assertEquals(1, frequencies.get("this"));
        assertEquals(1, frequencies.get("is"));
        assertEquals(1, frequencies.get("a"));
        assertEquals(1, frequencies.get("test"));
    }
}
