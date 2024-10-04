package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyCollectionsTest {
    @Test
    public void testCreateRandomArray() {
        int[] array = MyCollections.createRandomArray(10);
        assertEquals(10, array.length);
        for (int num : array) {
            assertTrue(num >= 0 && num <= 100);
        }
    }

    @Test
    public void testArrayToList() {
        int[] array = {1, 2, 3};
        List<Integer> list = MyCollections.arrayToList(array);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testSortListAscending() {
        List<Integer> list = Arrays.asList(3, 1, 2);
        MyCollections.sortListAscending(list);
        assertEquals(Arrays.asList(1, 2, 3), list);
    }

    @Test
    public void testSortListDescending() {
        List<Integer> list = Arrays.asList(1, 3, 2);
        MyCollections.sortListDescending(list);
        assertEquals(Arrays.asList(3, 2, 1), list);
    }

    @Test
    public void testShuffleList() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> original = new ArrayList<>(list);
        MyCollections.shuffleList(list);
        assertNotEquals(original, list); // Проверяем, что порядок изменился
    }

    @Test
    public void testRotateList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        MyCollections.rotateList(list);
        assertEquals(Arrays.asList(2, 3, 1), list);
    }

    @Test
    public void testUniqueElements() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> unique = MyCollections.uniqueElements(list);
        assertEquals(Arrays.asList(1, 2, 3), unique);
    }

    @Test
    public void testDuplicateElements() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> duplicates = MyCollections.duplicateElements(list);
        assertEquals(Arrays.asList(2, 3), duplicates);
    }

    @Test
    public void testListToArray() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int[] array = MyCollections.listToArray(list);
        assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    public void testCountOccurrences() {
        int[] array = {1, 1, 2, 3, 3, 3};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        MyCollections.countOccurrences(array);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Число 1 встречается 2 раз(а)."));
        assertTrue(output.contains("Число 2 встречается 1 раз(а)."));
        assertTrue(output.contains("Число 3 встречается 3 раз(а)."));
    }
}