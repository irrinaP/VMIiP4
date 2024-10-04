package org.example;

import java.util.Comparator;

// Компаратор для сравнения людей по фамилии
public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        // Обрабатываем случай, когда фамилия может быть null
        if (h1.getLastName() == null && h2.getLastName() == null) {
            return 0;
        } else if (h1.getLastName() == null) {
            return -1;
        } else if (h2.getLastName() == null) {
            return 1;
        }

        // Сравниваем фамилии без учета регистра
        return h1.getLastName().compareToIgnoreCase(h2.getLastName());
    }
}
