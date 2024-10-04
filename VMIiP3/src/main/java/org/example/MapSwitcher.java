package org.example;

import java.util.HashMap;
import java.util.Map;

public class MapSwitcher {

    // Метод для смены местами ключей и значений в Map
    public static <K, V> Map<V, K> switchMap(Map<K, V> originalMap) {
        Map<V, K> switchedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            if (switchedMap.containsKey(entry.getValue())) {
                System.out.println("Внимание! Дубликат значения: " + entry.getValue());
            }
            switchedMap.put(entry.getValue(), entry.getKey());
        }

        return switchedMap;
    }
}
