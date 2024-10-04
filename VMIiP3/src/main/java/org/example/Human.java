package org.example;

import java.util.Objects;

// Класс, представляющий человека с именем, фамилией и возрастом.
public class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    // Конструктор
    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Геттеры
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // Сравнение по фамилии, затем по имени, если фамилии совпадают
    @Override
    public int compareTo(Human other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        return (lastNameComparison != 0) ? lastNameComparison : this.firstName.compareTo(other.firstName);
    }

    // Переопределенный метод toString для более читаемого вывода
    @Override
    public String toString() {
        return String.format("%s %s (возраст: %d)", firstName, lastName, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Human human = (Human) obj;
        return age == human.age &&
                firstName.equals(human.firstName) &&
                lastName.equals(human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
