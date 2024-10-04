package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequencies(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Разделяем текст на слова, игнорируя регистр
        String[] words = text.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) { // Проверяем, что слово не пустое
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }
}
