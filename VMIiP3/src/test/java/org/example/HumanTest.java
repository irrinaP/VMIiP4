package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    @Test
    public void testComparable() {
        Human h1 = new Human("Иван", "Петров", 25);
        Human h2 = new Human("Анна", "Сидорова", 30);
        Human h3 = new Human("Сергей", "Иванов", 22);

        assertTrue(h1.compareTo(h2) < 0); // Петров > Сидорова
        assertTrue(h2.compareTo(h3) > 0); // Сидорова < Иванов
        assertTrue(h1.compareTo(h3) > 0); // Петров < Иванов
    }

    @Test
    public void testHumanComparatorByLastName() {
        HumanComparatorByLastName comparator = new HumanComparatorByLastName();
        Human h1 = new Human("Иван", "Петров", 25);
        Human h2 = new Human("Анна", "Сидорова", 30);
        Human h3 = new Human("Сергей", "Иванов", 22);

        assertTrue(comparator.compare(h1, h2) < 0); // Петров > Сидорова
        assertTrue(comparator.compare(h2, h3) > 0); // Сидорова < Иванов
        assertTrue(comparator.compare(h1, h3) > 0); // Петров < Иванов

    }

    @Test
    public void testTreeSetWithCustomComparator() {
        TreeSet<Human> treeSet = new TreeSet<>(new HumanComparatorByLastName());
        treeSet.add(new Human("Иван", "Петров", 25));
        treeSet.add(new Human("Анна", "Сидорова", 30));
        treeSet.add(new Human("Сергей", "Иванов", 22));

        assertEquals(3, treeSet.size()); // Проверяем, что в сет добавлено 3 человека
    }

    @Test
    public void testTreeSetWithAnonymousComparator() {
        TreeSet<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.add(new Human("Иван", "Петров", 25));
        treeSetByAge.add(new Human("Анна", "Сидорова", 30));
        treeSetByAge.add(new Human("Сергей", "Иванов", 22));

        assertEquals(3, treeSetByAge.size()); // Проверяем, что в сет добавлено 3 человека
    }
}
