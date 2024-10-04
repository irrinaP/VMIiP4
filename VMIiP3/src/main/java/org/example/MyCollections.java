package org.example;

import java.util.*;

public class MyCollections {

    // a) Создайте массив из N случайных чисел от 0 до 100.
    public static int[] createRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    // b) На основе массива создайте список List.
    public static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int value : array) {
            list.add(value);
        }
        return list;
    }

    // c) Отсортируйте список по возрастанию.
    public static void sortListAscending(List<Integer> list) {
        Collections.sort(list);
    }

    // d) Отсортируйте список в обратном порядке.
    public static void sortListDescending(List<Integer> list) {
        list.sort(Collections.reverseOrder());
    }

    // e) Перемешайте список.
    public static void shuffleList(List<Integer> list) {
        Collections.shuffle(list);
    }

    // f) Выполните циклический сдвиг на 1 элемент.
    public static void rotateList(List<Integer> list) {
        Collections.rotate(list, 1);  // Выполняем циклический сдвиг на 1 элемент вправо
    }

    // g) Оставьте в списке только уникальные элементы.
    public static List<Integer> uniqueElements(List<Integer> list) {
        Set<Integer> uniqueSet = new HashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }

    // h) Оставьте в списке только дублирующиеся элементы.
    public static List<Integer> duplicateElements(List<Integer> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : list) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    // i) Из списка получите массив.
    public static int[] listToArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }

    // j) Посчитайте количество вхождений каждого числа в массив и выведите на экран.
    public static void countOccurrences(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println("Число " + entry.getKey() + " встречается " + entry.getValue() + " раз(а).");
        }
    }
}
