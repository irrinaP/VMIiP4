package org.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSwitcherTest {

    @Test
    public void testSwitchMap() {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("One", 1);
        originalMap.put("Two", 2);
        originalMap.put("Three", 3);

        Map<Integer, String> switchedMap = MapSwitcher.switchMap(originalMap);

        assertEquals("One", switchedMap.get(1));
        assertEquals("Two", switchedMap.get(2));
        assertEquals("Three", switchedMap.get(3));
    }
}
